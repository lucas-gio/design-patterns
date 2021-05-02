package com.application.builder.withInheritanceStaticInnerClass;

import com.application.builder.relatedEntities.Item;
import com.application.builder.withStaticInnerClass.Customer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Representa el retiro de una compra realizada en la tienda online.
 */
public abstract class PurchaseWithdrawal {
    protected List<Item> purchasedItems;
    protected BigDecimal calculatedCostWithTaxes;
    protected Customer customer;
    protected LocalDateTime purchaseDateTime;
    protected Boolean includedOffers;
    protected Boolean purchaseInHotSale;

    PurchaseWithdrawal(Builder<?> builder){
        purchasedItems = builder.purchasedItems;
        calculatedCostWithTaxes = builder.calculatedCostWithTaxes;
        customer = builder.customer;
        purchaseDateTime = builder.purchaseDateTime;
        includedOffers = builder.includedOffers;
        purchaseInHotSale = builder.purchaseInHotSale;
    }

    public abstract static class Builder<T extends Builder<T>>{
        protected List<Item> purchasedItems;
        protected BigDecimal calculatedCostWithTaxes;
        protected Customer customer;
        protected LocalDateTime purchaseDateTime;
        protected Boolean includedOffers;
        protected Boolean purchaseInHotSale;

        // Setters. Retornan self ya que este builder no se usa; se usa su builder hijo.
        public T withPurchasedItems(List<Item> purchasedItems){
            self().purchasedItems = purchasedItems;
            return self();
        }
        public T withCalculatedCostWithTaxes(BigDecimal calculatedCostWithTaxes){
            self().calculatedCostWithTaxes = calculatedCostWithTaxes;
            return self();
        }
        public T withCustomer(Customer customer){
            self().customer = customer;
            return self();
        }
        public T withPurchaseDateTime(LocalDateTime purchaseDateTime){
            self().purchaseDateTime = purchaseDateTime;
            return self();
        }
        public T withIncludedOffers(Boolean includedOffers){
            self().includedOffers = includedOffers;
            return self();
        }

        public T withPurchaseInHotSale(Boolean purchaseInHotSale){
            self().purchaseInHotSale = purchaseInHotSale;
            return self();
        }

        //Las clases hijas deberán implementar este self retornando this.
        protected abstract T self();

        // La construcción de cada objeto dependerá de las subclases.
        protected abstract PurchaseWithdrawal build();
    }
}