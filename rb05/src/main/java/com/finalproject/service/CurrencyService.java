package com.finalproject.service;


import com.finalproject.model.ConversionEntity;
import com.finalproject.model.ConversionRequest;
import com.finalproject.model.ConversionResponse;
import com.finalproject.model.CurrencyEntity;
import com.finalproject.repository.ConversionRepository;
import com.finalproject.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    ConversionRepository conversionRepository;

    public Double getRate(String source, String target) {
        CurrencyEntity entity = currencyRepository.findBySourceAndTarget(source, target);
        if(!Objects.isNull(entity)){
            return entity.getRate();
        }
        return null;
    }

    public ConversionResponse convertCurrencies(ConversionRequest request) {
        CurrencyEntity entity = currencyRepository.findBySourceAndTarget(request.getSource(), request.getTarget());
        ConversionResponse response = null;
        if(!Objects.isNull(entity)){
            double calculatedAmount = request.getAmount() * entity.getRate();

            ConversionEntity conversionEntity = ConversionEntity.builder()
                    .amount(request.getAmount())
                    .calculatedAmount(calculatedAmount)
                    .transactionId(UUID.randomUUID().toString())
                    .transactionDate(LocalDateTime.now())
                    .entity(entity)
                    .build();

            conversionEntity = conversionRepository.save(conversionEntity);

            response = ConversionResponse.builder()
                    .amount(calculatedAmount)
                    .target(request.getTarget())
                    .transactionId(conversionEntity.getTransactionId())
                    .build();
        }
        return response;

    }

    public List<ConversionResponse> getConversionList(String transactionId, Date transactionDate) {
        ConversionEntity entity = conversionRepository.findByTransactionId(transactionId);
        List<ConversionResponse> responseList = new ArrayList<>();
        if(!Objects.isNull(entity)){
            responseList.add(ConversionResponse.builder()
                    .amount(entity.getCalculatedAmount())
                    .target(entity.getEntity().getTarget())
                    .transactionId(entity.getTransactionId())
                    .build());
        }
        return responseList;
    }
}
