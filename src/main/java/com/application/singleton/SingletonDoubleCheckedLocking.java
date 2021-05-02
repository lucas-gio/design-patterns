package com.application.singleton.singletonClasses;

import java.util.Date;

class SingletonDoubleCheckedLocking extends SingletonBase{
    private static volatile Date instance;
    private SingletonDoubleCheckedLocking() {}

    public static Date getInstance(){
        if (instance == null) {
            synchronized (SingletonDoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new Date();
                }
            }
        }

        return instance;
    }
}
