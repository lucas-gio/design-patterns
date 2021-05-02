package com.application.builder.withStaticInnerClass;

import com.application.builder.relatedEntities.*;

import java.util.Date;
import java.util.List;

public class Customer {
    // Al construirse se le asignan los valores, por lo tanto son finales.
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

    // Siempre constructor privado, para obligar el uso del builder.
    private Customer(Builder builder){
        code = builder.code;
        name = builder.name;
        lastName = builder.lastName;
        birthDate = builder.birthDate;
        type = builder.type;
        registrationDate = builder.registrationDate;
        loyaltyCards = builder.loyaltyCards;
        frequency = builder.frequency;
        lastPurchaseDate = builder.lastPurchaseDate;
        preferredItems = builder.preferredItems;
        city = builder.city;
        state = builder.state;
        country = builder.country;
        isActive = builder.isActive;

        // VALIDACIONES DESPUÉS DE ESTE PUNTO, SIEMPRE SOBRE LA NUEVA INSTANCIA
        // Y NO SOBRE EL BUILDER. De esa manera es thread safe.
    }

    public static class Builder implements ICustomerBuilder {
        // Una copia de los mismos atributos de la clase a construir. Valores opcionales asignados.
        // Son finales aquellos atributos requeridos.
        private final String code;
        private final String name;
        private final String lastName;
        private Date birthDate = null;
        private final CustomerType type;
        private Date registrationDate = null;
        private List<Card> loyaltyCards = null;
        private CustomerFrequency frequency = null;
        private Date lastPurchaseDate = null;
        private List<Item> preferredItems = null;
        private City city = null;
        private State state = null;
        private Country country = null;
        private Boolean isActive = true;

        // Constructor con sólo los atributos mínimos requeridos que un cliente debería tener.
        public Builder(String code, String name, String lastName, CustomerType type){
            this.code = code;
            this.name = name;
            this.lastName = lastName;
            this.type = type;
        }

        @Override
        public Customer build() {
            return new Customer(this);
        }

        //setters.
        public Builder withBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder withRegistrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder withLoyaltyCards(List<Card> loyaltyCards) {
            this.loyaltyCards = loyaltyCards;
            return this;
        }

        public Builder withFrequency(CustomerFrequency frequency) {
            this.frequency = frequency;
            return this;
        }

        public Builder withLastPurchaseDate(Date lastPurchaseDate) {
            this.lastPurchaseDate = lastPurchaseDate;
            return this;
        }

        public Builder withPreferredItems(List<Item> preferredItems) {
            this.preferredItems = preferredItems;
            return this;
        }

        public Builder withCity(City city) {
            this.city = city;
            return this;
        }

        public Builder withState(State state) {
            this.state = state;
            return this;
        }

        public Builder withCountry(Country country) {
            this.country = country;
            return this;
        }

        public Builder withIsActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }
    }
}