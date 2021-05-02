package com.application.builder.withStaticInnerClass;

// Notar que en este caso particular no es público, porque hay otro paquete con interfaz del mismo nombre que esta.
// Build es público.
public interface ICustomerBuilder {
    Customer build();
}
