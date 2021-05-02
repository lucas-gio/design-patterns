package com.application.prototype.entities;

public class JetType{
    private String name;

    private JetType(String name){
        this.name = name;
    }

    /**
     * Retorna una nueva instancia con el nombre tomao por parámetro, o '-' como nombre por defecto.
     * @param name El nombre.
     * @return El valor tomado por parámetro o "-" en caso contrario.
     */
    public static JetType create(String name){
        return new JetType(name != null ? name : "-");
    }

    public Object clone(){
        return JetType.create(name);
    }
}
