package com.finalproject.repository;

import com.finalproject.model.ConversionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversionRepository extends JpaRepository<ConversionEntity, Long> {

    ConversionEntity findByTransactionId(String transactionId);

}

