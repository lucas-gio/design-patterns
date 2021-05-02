package com.application.prototype.factories;

import com.application.prototype.entities.Airplane;

public interface IAirplaneFactory {
    /**
     * Crea un nuevo avión.
     * @param name El tipo de avión a crear.
     */
    Airplane create(String name);
}
