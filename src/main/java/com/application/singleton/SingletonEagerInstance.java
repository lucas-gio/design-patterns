package com.application.singleton.singletonClasses;

import java.util.Date;

public class SingletonEagerInstance extends SingletonBase{
    private static Date instance = new Date();
    private SingletonEagerInstance() {}

    public static Date getInstance(){
        return instance;
    }
}