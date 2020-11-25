package com.application.builder.withInheritanceStaticInnerClass

import com.application.builder.relatedEntities.*
import com.application.builder.withStaticInnerClass.*
import spock.lang.Specification

import java.time.LocalDateTime

class purchaseWithdrawalTest extends Specification {

    def "Se prueba la creación de un retiro de venta por sucursal que se realice correctamente"(){
        when: "Se construyen una intancia con un nuevo retiro de venta por sucursal"
        // Compró item 1, e item 2; el día 1/1/2020; lo retira el día siguiente; compró el cliente cliente1.

        Item item1 = new Item([code:"1", description:"1"])
        Item item2 = new Item([code:"2", description:"2"])
        LocalDateTime purchaseDateTime = LocalDateTime.of(2020, 01, 01, 0,0,0)
        LocalDateTime withdrawalDate = LocalDateTime.of(2020, 01, 02, 0,0,0)
        Customer customer = new Customer.Builder("cliente1", "nombre1", "apellido1", CustomerType.GOLD).withFrequency(CustomerFrequency.LESS_FREQUENT).build()

        InStore purchaseWithdrawalInStore = new InStore.Builder()
                .withWithdrawalDate(withdrawalDate)
                .withPurchasedItems([item1, item2])
                .withCalculatedCostWithTaxes(new BigDecimal("505.98"))
                .withCustomer(customer)
                .withPurchaseDateTime(purchaseDateTime)
                .withIncludedOffers(true)
                .withPurchaseInHotSale(false)
                .build()

        then: "Se obtiene el retiro con los datos válidos"
        purchaseWithdrawalInStore.purchasedItems
        purchaseWithdrawalInStore.purchasedItems.size() == 2
        purchaseWithdrawalInStore.purchasedItems.code.containsAll([item1.code, item2.code])
        purchaseWithdrawalInStore.purchasedItems.description.containsAll([item1.description, item2.description])
        purchaseWithdrawalInStore.calculatedCostWithTaxes == new BigDecimal("505.98")
        purchaseWithdrawalInStore.customer
        purchaseWithdrawalInStore.customer.code == "cliente1"
        purchaseWithdrawalInStore.customer.name == "nombre1"
        purchaseWithdrawalInStore.customer.lastName == "apellido1"
        purchaseWithdrawalInStore.customer.type == CustomerType.GOLD
        purchaseWithdrawalInStore.customer.frequency == CustomerFrequency.LESS_FREQUENT
        purchaseWithdrawalInStore.purchaseDateTime == purchaseDateTime
        purchaseWithdrawalInStore.includedOffers
        !purchaseWithdrawalInStore.purchaseInHotSale

        and: "Los atributos específicos de este tipo de retiro tienen su valor correspondiente"
        purchaseWithdrawalInStore.withdrawalDate == withdrawalDate
    }

    def "Se prueba la creación de un retiro de venta por correo que se realice correctamente"(){
        when: "Se construye la instancia de un nuevo retiro de venta por correo con su info. El cliente que hace el retiro es el mismo que hizo la compra. "
        // Compró item 1, e item 2; el día 1/1/2020; compró el cliente cliente1 y lo retira él mismo; en la sucursal east de correo argentino; con el nro. de retiro:1234.

        Item item1 = new Item([code:"1", description:"1"])
        Item item2 = new Item([code:"2", description:"2"])
        LocalDateTime purchaseDateTime = LocalDateTime.of(2020, 01, 01, 0,0,0)
        Customer customer = new Customer.Builder("cliente1", "nombre1", "apellido1", CustomerType.GOLD).withFrequency(CustomerFrequency.LESS_FREQUENT).build()
        PostOffice selectedPostOffice = PostOffice.newInstance(PostOffice.PostOfficeCode.CORREO_ARGENTINO, PostOffice.PostOfficeBranch.EAST)

        InPostOffice purchaseWithdrawalInPostOffice = new InPostOffice.Builder(customer, "1234", selectedPostOffice)
                .withPurchasedItems([item1, item2])
                .withCalculatedCostWithTaxes(new BigDecimal("505.98"))
                .withCustomer(customer)
                .withPurchaseDateTime(purchaseDateTime)
                .withIncludedOffers(true)
                .withPurchaseInHotSale(false)
                .build()

        then: "Se obtiene el retiro con los datos válidos"
        purchaseWithdrawalInPostOffice.purchasedItems
        purchaseWithdrawalInPostOffice.purchasedItems.size() == 2
        purchaseWithdrawalInPostOffice.purchasedItems.code.containsAll([item1.code, item2.code])
        purchaseWithdrawalInPostOffice.purchasedItems.description.containsAll([item1.description, item2.description])
        purchaseWithdrawalInPostOffice.calculatedCostWithTaxes == new BigDecimal("505.98")
        purchaseWithdrawalInPostOffice.customer
        purchaseWithdrawalInPostOffice.customer.code == "cliente1"
        purchaseWithdrawalInPostOffice.customer.name == "nombre1"
        purchaseWithdrawalInPostOffice.customer.lastName == "apellido1"
        purchaseWithdrawalInPostOffice.customer.type == CustomerType.GOLD
        purchaseWithdrawalInPostOffice.customer.frequency == CustomerFrequency.LESS_FREQUENT
        purchaseWithdrawalInPostOffice.purchaseDateTime == purchaseDateTime
        purchaseWithdrawalInPostOffice.includedOffers
        ! purchaseWithdrawalInPostOffice.purchaseInHotSale

        and: "Los atributos específicos de este tipo de retiro tienen su valor correspondiente"
        purchaseWithdrawalInPostOffice.withdrawalCustomer.code == "cliente1"
        purchaseWithdrawalInPostOffice.orderNumber == "1234"
        purchaseWithdrawalInPostOffice.postOffice.code == PostOffice.PostOfficeCode.CORREO_ARGENTINO
        purchaseWithdrawalInPostOffice.postOffice.branch == PostOffice.PostOfficeBranch.EAST

    }
}
