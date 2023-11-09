package com.finalproject.controller;


import com.finalproject.enums.Enums;
import com.finalproject.exception.ValidationErrorResponse;
import com.finalproject.model.ConversionRequest;
import com.finalproject.model.ConversionResponse;

import com.finalproject.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/rate")
    public ResponseEntity<?> getExchangeRate(@RequestParam String source, @RequestParam String target) {
        Double rate = currencyService.getRate(source, target);
        if(rate == null){
            ValidationErrorResponse errorResponse = new ValidationErrorResponse(Enums.ErrorMessages.RATE_IS_NULL_EXCEPTION.getValue());
            logger.error(errorResponse.getError() + " Rate :" + rate);//debug ve error moddayken de loga yazdıgı için error kullandım.
            return ResponseEntity.badRequest().body(errorResponse);
        }
        return ResponseEntity.ok(rate);
    }

    @PostMapping("/convert")
    public ResponseEntity<?> convertCurrencies(@RequestBody ConversionRequest request) {
        ConversionResponse response;
        if(request.getSource().equalsIgnoreCase(request.getTarget())){
            ValidationErrorResponse errorResponse = new ValidationErrorResponse(Enums.ErrorMessages.SOURCE_AND_TARGET_MUST_BE_DIFFERENT.getValue());
            logger.error(errorResponse.getError()+ " Source: " + request.getSource() + " Target: " + request.getTarget());
            return ResponseEntity.badRequest().body(errorResponse);
        }else{
            response = currencyService.convertCurrencies(request);
            if(Objects.isNull(response)){
                ValidationErrorResponse errorResponse = new ValidationErrorResponse(
                        String.format(Enums.ErrorMessages.CONVERT_RESPONSE_IS_NULL_EXCEPTION.getValue(),request.getSource(),request.getTarget()));
                logger.error(errorResponse.getError() + " response: " + response);
                return ResponseEntity.badRequest().body(errorResponse);
            }
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/conversion-list")
    public ResponseEntity<?> getConversionList(
            @RequestParam String transactionId,
            @RequestParam String transactionDate) {

        //Test amaçlı TEST_TRANSACTION_DATE tanımlanmıştır.
        // H2 db ye sürekli conn kurup date almaya üşendiğim için "aa123123aa" ve null inputu girmek istedim.
        // transactionId ler unique oldugu için beklediğim veriyi date den bağımsız çekebiliyorum zaten.
        Date date = null;
        if(transactionDate.equals("") || transactionDate.equalsIgnoreCase(Enums.TestParameters.TEST_TRANSACTION_DATE.getValue())){
            date = new Date();
        }else{
            SimpleDateFormat dateFormat = new SimpleDateFormat(Enums.ValidParameters.VALID_DATE_FORMAT.getValue());
            try {
                date = dateFormat.parse(transactionDate);
            } catch (ParseException e) {
                String errorMessage = Enums.ErrorMessages.INVALID_DATE_FORMAT_EXCEPTION.getValue() +
                        Enums.ValidParameters.VALID_DATE_FORMAT.getValue();
                ValidationErrorResponse errorResponse = new ValidationErrorResponse(errorMessage);
                logger.error(errorMessage + " date: " + date);
                return ResponseEntity.badRequest().body(errorResponse);
            }
        }
        List<ConversionResponse> responseList = currencyService.getConversionList(transactionId, date);
        if(responseList.size()==0){
            ValidationErrorResponse errorResponse = new ValidationErrorResponse(Enums.ErrorMessages.CONVERSION_LIST_EXCEPTION.getValue());
            logger.error(errorResponse.getError() + " response list size : " + responseList.size());
            return ResponseEntity.badRequest().body(errorResponse);
        }
        return ResponseEntity.ok(responseList);
    }
}


