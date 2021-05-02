package com.application.prototype.factories;

import com.application.prototype.entities.Airplane;

import java.util.HashMap;
import java.util.Map;

/**
 * Permite crear aviones basados en prototipos.
 */
public class AirplaneFactory implements IAirplaneFactory{
    private Map<String, Airplane> prototypes;

    /**
     * Constructor privado, se utiliza su método fábrica estático.
     */
    private AirplaneFactory(){}

    /**
     * Método fábrica destinado a la creación de una nueva instancia con los prototipos tomados por parámetro.
     */
    public static AirplaneFactory from(Map<String, Airplane> airplanes) {
        AirplaneFactory factory = new AirplaneFactory();
        factory.prototypes = new HashMap<>();
        factory.prototypes.putAll(airplanes);
        return factory;
    }

    /**
     * Retorna una nueva instancia de una aeronave, basada en su prototipo.
     */
    @Override public Airplane create(String code) {
        Airplane airplane = prototypes.get(code);

        if(airplane != null){
            airplane = (Airplane) airplane.clone();
        }

        return airplane;
    }
}
