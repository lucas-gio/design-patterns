package com.application.builder.withSeparatedClasses;

import com.application.builder.relatedEntities.*;

import java.util.Date;
import java.util.List;

public class CustomerBuilder implements ICustomerBuilder{
    // Una copia de los mismos atributos de la clase a construir. Valores opcionales asignados.
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
    public CustomerBuilder(String code, String name, String lastName, CustomerType type){
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
    public CustomerBuilder withBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public CustomerBuilder withRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public CustomerBuilder withLoyaltyCards(List<Card> loyaltyCards) {
        this.loyaltyCards = loyaltyCards;
        return this;
    }

    public CustomerBuilder withFrequency(CustomerFrequency frequency) {
        this.frequency = frequency;
        return this;
    }

    public CustomerBuilder withLastPurchaseDate(Date lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
        return this;
    }

    public CustomerBuilder withPreferredItems(List<Item> preferredItems) {
        this.preferredItems = preferredItems;
        return this;
    }

    public CustomerBuilder withCity(City city) {
        this.city = city;
        return this;
    }

    public CustomerBuilder withState(State state) {
        this.state = state;
        return this;
    }

    public CustomerBuilder withCountry(Country country) {
        this.country = country;
        return this;
    }

    public CustomerBuilder withIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    //Getters.
    // Notar que al estar en la misma clase es mejor bajarles el acceso de public
    // a visible al paquete.
    String getCode() {
        return code;
    }

    String getName() {
        return name;
    }

    String getLastName() {
        return lastName;
    }

    Date getBirthDate() {
        return birthDate;
    }

    CustomerType getType() {
        return type;
    }

    Date getRegistrationDate() {
        return registrationDate;
    }

    List<Card> getLoyaltyCards() {
        return loyaltyCards;
    }

    CustomerFrequency getFrequency() {
        return frequency;
    }

    Date getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    List<Item> getPreferredItems() {
        return preferredItems;
    }

    City getCity() {
        return city;
    }

    State getState() {
        return state;
    }

    Country getCountry() {
        return country;
    }

    Boolean getIsActive() {
        return isActive;
    }
}