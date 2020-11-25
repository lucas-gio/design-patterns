package com.application.prototype.entities;

import java.awt.*;

/**
 * Representa un Jet.
 */
public class Jet implements Airplane {
    private String code;
    private String name;
    private JetType type;
    private int numberOfPassanger;
    private Color baseColor;

    private Jet(){}

    @Override public Object clone() {
        return create(code, name, (JetType) type.clone(), numberOfPassanger, baseColor);
    }

    /**
     * Método fábrica estático que retorna una nueva instancia.
     */
    public static Jet create(String code, String name, JetType type, int numberOfPassanger, Color baseColor){
        Jet jet = new Jet();
        jet.code = code;
        jet.name = name;
        jet.type = type;
        jet.numberOfPassanger = numberOfPassanger;
        jet.baseColor = baseColor;
        return jet;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JetType getType() {
        return type;
    }

    public void setType(JetType type) {
        this.type = type;
    }

    public int getNumberOfPassanger() {
        return numberOfPassanger;
    }

    public void setNumberOfPassanger(int numberOfPassanger) {
        this.numberOfPassanger = numberOfPassanger;
    }

    public Color getBaseColor() {
        return baseColor;
    }

    public void setBaseColor(Color baseColor) {
        this.baseColor = baseColor;
    }
}
