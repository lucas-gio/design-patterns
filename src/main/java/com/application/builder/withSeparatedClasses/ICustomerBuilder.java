package com.application.builder.withSeparatedClasses;

// Notar que en este caso particular no es público, porque hay otro paquete con interfaz del mismo nombre que esta.
// Build es público.
interface ICustomerBuilder {
    Customer build();
}
