package com.application.builder.withSeparatedClasses;

import com.application.builder.relatedEntities.*;

import java.util.Date;
import java.util.List;

public class Customer {
    private final String code;
    private final String name;
    private final String lastName;
    private final Date birthDate;
    private final CustomerType type;
    private final Date registrationDate;
    private final List<Card> loyaltyCards;
    private final CustomerFrequency frequency;
    private final Date lastPurchaseDate;
    private final List<Item> preferredItems;
    private final City city;
    private final State state;
    private final Country country;
    private final Boolean isActive;

    // LO MALO DE ESTA VERSIÓN ES DEJAR EL CONSTRUCTOR VISIBLE.
    Customer(CustomerBuilder builder){
        code = builder.getCode();
        name = builder.getName();
        lastName = builder.getLastName();
        birthDate = builder.getBirthDate();
        type = builder.getType();
        registrationDate = builder.getRegistrationDate();
        loyaltyCards = builder.getLoyaltyCards();
        frequency = builder.getFrequency();
        lastPurchaseDate = builder.getLastPurchaseDate();
        preferredItems = builder.getPreferredItems();
        city = builder.getCity();
        state = builder.getState();
        country = builder.getCountry();
        isActive = builder.getIsActive();

        // VALIDACIONES DESPUÉS DE ESTE PUNTO, SIEMPRE SOBRE LA NUEVA INSTANCIA
        // Y NO SOBRE EL BUILDER. De esa manera es thread safe.
    }
}