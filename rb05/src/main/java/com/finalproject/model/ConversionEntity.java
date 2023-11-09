package com.finalproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConversionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String transactionId;
    @Column(nullable = false)
    private LocalDateTime transactionDate;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private double calculatedAmount;

    @ManyToOne
    @JoinColumn(name = "entity_id", referencedColumnName = "id", nullable = false)
    private CurrencyEntity entity;

}

