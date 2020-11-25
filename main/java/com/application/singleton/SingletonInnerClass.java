/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.singleton.singletonClasses;

import java.util.Date;

public class SingletonInnerClass extends SingletonBase{
    private SingletonInnerClass() {}

    private static class LazyHolder {
        static final Date INSTANCE = new Date();
    }

    public static Date getInstance() {
        return LazyHolder.INSTANCE;
    }
}
