/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.singleton.singletonClasses;

import java.util.Date;

public class SingletonSynchronized extends SingletonBase{
    private static Date instance;
    private SingletonSynchronized() {}

    public static synchronized Date getInstance(){
        if (instance == null) {
            instance = new Date();
        }

        return instance;
    }
}