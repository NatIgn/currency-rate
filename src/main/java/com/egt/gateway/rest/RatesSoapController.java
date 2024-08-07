package com.egt.gateway.rest;

import com.egt.gateway.dao.CurrencyDAO;
import com.egt.gateway.dao.CurrencyExchangeRateDAO;
import com.egt.gateway.dao.RequestDAO;
import com.egt.gateway.entity.*;
import com.egt.gateway.service.CurrencyExchangeRateService;
import com.egt.gateway.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/xml_api")
public class RatesSoapController {

    private final String serviceName = "EXT_SERVICE_1";

    private RequestService requestService;
    private CurrencyExchangeRateService currencyExchangeRateService;


    @Autowired
    public RatesSoapController (RequestService requestService, CurrencyExchangeRateService currencyExchangeRateService) {
        this.requestService = requestService;
        this.currencyExchangeRateService = currencyExchangeRateService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path="/command", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public CurrencyExchangeRate returnCommand(@RequestBody Command command) {
        String endpoint = "command/" + serviceName;
        RequestEntity requestEnt = this.requestService.findById(command.getId());

        if (requestEnt != null) {
            throw new RequestAlreadyExistException("Request with same id already exist");
        }

        CurrencyExchangeRate currencyExchangeRate;

        try{
            currencyExchangeRate = this.currencyExchangeRateService.getByCurrencyCode(command.getGet().getCurrency());
        } catch (EmptyResultDataAccessException exc) {
            throw new NoResultsFoundException("There are no results for this currency");
        }

        RequestEntity newRequest = new RequestEntity(endpoint,command.getId(), new Timestamp(System.currentTimeMillis()), command.getGet().getConsumerId());
        try {
            this.requestService.save(newRequest);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Couldn't save the request data");
        }

        return currencyExchangeRate;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path="history", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public List<CurrencyExchangeRate> returnHistory(@RequestBody Command command){
        String endpoint = "history/" + serviceName;
        RequestEntity requestEnt = this.requestService.findById(command.getId());

        if (requestEnt != null) {
            throw new RequestAlreadyExistException("Request with same id already exist");
        }

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        int hoursToSubtract = -1 * command.getHistory().getPeriod();
        calendar.add(Calendar.HOUR, hoursToSubtract);
        Date previousDate = calendar.getTime();

        List<CurrencyExchangeRate> currencyExchangeRate = this.currencyExchangeRateService.getHisoryCurrencyDataByCurrencyCode(command.getHistory().getCurrency(), previousDate, today);
        RequestEntity newRequest = new RequestEntity(endpoint, command.getId(), new Timestamp(System.currentTimeMillis()), command.getHistory().getConsumer());

        try {
            this.requestService.save(newRequest);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Couldn't save the request data");
        }
        return currencyExchangeRate;
    }
}
