package com.egt.gateway.rest;

import com.egt.gateway.dao.CurrencyDAO;
import com.egt.gateway.dao.CurrencyExchangeRateDAO;
import com.egt.gateway.dao.RequestDAO;
import com.egt.gateway.entity.*;
import com.egt.gateway.service.CurrencyExchangeRateService;
import com.egt.gateway.service.ProduceMessageService;
import com.egt.gateway.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/json_api")
public class RatesRestController {

    private final String serviceName = "EXT_SERVICE_2";

    private RequestService requestService;
    private CurrencyExchangeRateService currencyExchangeRateService;
    private ProduceMessageService produceMessageService;

    @Autowired
    public RatesRestController(RequestService requestService, CurrencyExchangeRateService currencyExchangeRateService, ProduceMessageService produceMessageService) {
        this.requestService = requestService;
        this.currencyExchangeRateService = currencyExchangeRateService;
        this.produceMessageService = produceMessageService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path="/current")
    public CurrencyExchangeRate getCurrentRates(@RequestBody RestRequestObj req) {
        String endpoint = "current/" + serviceName;

        RequestEntity requestEnt = this.requestService.findById(req.getRequestId());
        if (requestEnt != null) {
            throw new RequestAlreadyExistException("Request with same id already exist");
        }

        CurrencyExchangeRate currencyExchangeRate;

        try {
            currencyExchangeRate = this.currencyExchangeRateService.getByCurrencyCode(req.getCurrency());

        } catch (EmptyResultDataAccessException exc) {
            throw new NoResultsFoundException("There are no results for this currency");
        }

        RequestEntity newRequest = new RequestEntity(endpoint, req.getRequestId(), req.getTimestamp(), req.getClientId());
        try {
            this.requestService.save(newRequest);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Couldn't save the request data");
        }

        produceMessageService.produceMessage(newRequest.toString());

        return currencyExchangeRate;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path="/history")
    public List<CurrencyExchangeRate> getCurrencyRatesFromDate(@RequestBody RestRequestObj req) {

        String endpoint = "history/" + serviceName;
        RequestEntity requestEnt = this.requestService.findById(req.getRequestId());

        if (requestEnt != null) {
            throw new RequestAlreadyExistException("Request with same id already exist");
        }

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        int hoursToSubtract = -1 * req.getPeriod();
        calendar.add(Calendar.HOUR, hoursToSubtract);
        Date previousDate = calendar.getTime();

        List<CurrencyExchangeRate> currencyExchangeRate = this.currencyExchangeRateService.getHisoryCurrencyDataByCurrencyCode(req.getCurrency(), previousDate, today);

        RequestEntity newRequest = new RequestEntity(endpoint, req.getRequestId(), req.getTimestamp(), req.getClientId());
        try {
            this.requestService.save(newRequest);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Couldn't save the request data");
        }

        produceMessageService.produceMessage(newRequest.toString());

        return currencyExchangeRate;
    }
}
