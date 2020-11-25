package com.application.builder.withInheritanceStaticInnerClass;

import java.time.LocalDateTime;

/**
 * Representa el retiro de una compra que se realizará en la sucursal.
 */
public class InStore extends PurchaseWithdrawal {
    // Fecha de retiro.
    private final LocalDateTime withdrawalDate; // -> opcional.

    private InStore(Builder builder){
        super(builder);
        this.withdrawalDate = builder.withdrawalDate;
    }

    public static class Builder extends PurchaseWithdrawal.Builder<Builder>{
        private LocalDateTime withdrawalDate; //-> Este no es final, porque es opcional.

        // setter.
        public Builder withWithdrawalDate(LocalDateTime withdrawalDate){
            this.withdrawalDate = withdrawalDate;
            return this;
        }

        @Override
        public InStore build(){
            return new InStore(this);
        }

        @Override
        protected Builder self(){
            return this;
        }
    }
}
