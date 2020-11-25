/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.singleton.singletonClasses;

import java.util.Date;

public class SingletonClassic extends SingletonBase{
    private static Date instance;
    private SingletonClassic(){}

    public static Date getInstance(){
        if(instance == null){
            instance = new Date();
        }
        
        return instance;
    }
}
