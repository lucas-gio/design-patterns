package com.application.builder.withInheritanceStaticInnerClass;

import com.application.builder.relatedEntities.PostOffice;
import com.application.builder.withStaticInnerClass.Customer;

/**
 * Representa el retiro de una compra que se realizará en la sucursal de correo.
 */
public class InPostOffice extends PurchaseWithdrawal {
    // El cliente que retira.
    private final Customer withdrawalCustomer;

    // Número de pedido para el retiro.
    private final String orderNumber;

    // La sucursal de correo elegida por el cliente.
    private final PostOffice postOffice;

    // AL construir la instancia específica debe previamente construir los atributos comunes, por eso
    // llamar antes a super.
    private InPostOffice(Builder builder){
        super(builder);
        this.withdrawalCustomer = builder.withdrawalCustomer;
        this.orderNumber = builder.orderNumber;
        this.postOffice = builder.postOffice;
    }

    public static class Builder extends PurchaseWithdrawal.Builder<Builder>{
        private final Customer withdrawalCustomer; // -> requerido
        private final String orderNumber; // -> requerido
        private final PostOffice postOffice; // -> requerido

        public Builder(Customer withdrawalCustomer, String orderNumber, PostOffice postOffice){
            this.withdrawalCustomer = withdrawalCustomer;
            this.orderNumber = orderNumber;
            this.postOffice = postOffice;
        }

        // El build abstracto se implementa acá retornando la instancia específica
        // construída por su builder específico.
        @Override
        public InPostOffice build(){
            return new InPostOffice(this);
        }

        // La construcción de los atributos comunes que están en la superclase se realizará
        // utilizando el builder extendido. Por eso el builder base utilizará este this específico.
        @Override
        protected Builder self(){
            return this;
        }
    }
}
