/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.singleton.singletonClasses

import spock.lang.Specification

import java.util.List

class SingletonTest extends Specification {

    private static Callable<String> getInstance(SingletonBase theClass) {
        return ()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                Log("Finaliza la tarea " + numeroTarea);
                return "resultado de la tarea " + numeroTarea;
            } catch (InterruptedException e) {
                Log("sleep ha sido interrumpido en tarea " + numeroTarea);
                return null;
            }
        };
    }

    def "Se verifica que se obtenga siempre la misma instancia para SingletonClassic"(){
        given:"Una instancia inicial"
        Date instance = SingletonClassic.getInstance()
        List<Date> singletonList = []

        when: "Se obtienen 1000000 instancias más"
        1000000.times{
            singletonList.add(SingletonClassic.getInstance())
        }

        then: "Son las mismas que la obtenida originalmente"
        singletonList.every{ Date newerInstance->
            newerInstance.getTime() == instance.getTime()
        }
    }

    def "Se verifica que se obtenga siempre la misma instancia para SingletonEagerInstance"(){
        given:"Una instancia inicial"
        Date instance = SingletonEagerInstance.getInstance()
        List<Date> singletonList = []

        when: "Se obtienen 1000000 instancias más"
        1000000.times{
            singletonList.add(SingletonEagerInstance.getInstance())
        }

        then: "Son las mismas que la obtenida originalmente"
        singletonList.every{ Date newerInstance->
            newerInstance.getTime() == instance.getTime()
        }
    }

    def "Se verifica que se obtenga siempre la misma instancia para SingletonEnum"(){
        given:"Una instancia inicial"
        SingletonEnum.INSTANCE.setDate(new Date())
        Date instance = SingletonEnum.INSTANCE.getDate()
        List<Date> singletonList = []

        when: "Se obtienen 1000000 instancias más"
        1000000.times{
            singletonList.add(SingletonEnum.INSTANCE.getDate())
        }

        then: "Son las mismas que la obtenida originalmente"
        singletonList.every{ Date newerInstance->
            newerInstance.getTime() == instance.getTime()
        }
    }

    def "Se verifica que se obtenga siempre la misma instancia para SingletonSynchronized"(){
        given:"Una instancia inicial"
        Date instance = SingletonSynchronized.getInstance()
        List<Date> singletonList = []

        when: "Se obtienen 1000000 instancias más"
        1000000.times{
            singletonList.add(SingletonSynchronized.getInstance())
        }

        then: "Son las mismas que la obtenida originalmente"
        singletonList.every{ Date newerInstance->
            newerInstance.getTime() == instance.getTime()
        }
    }

    def "Se verifica que se obtenga siempre la misma instancia para SingletonInnerClass"(){
        given:"Una instancia inicial"
        Date instance = SingletonInnerClass.getInstance()
        List<Date> singletonList = []

        when: "Se obtienen 1000000 instancias más"
        1000000.times{
            singletonList.add(SingletonInnerClass.getInstance())
        }

        then: "Son las mismas que la obtenida originalmente"
        singletonList.every{ Date newerInstance->
            newerInstance.getTime() == instance.getTime()
        }
    }

    def "Se verifica que se obtenga siempre la misma instancia para SingletonDoubleCheckedLocking"(){
        given:"Una instancia inicial"
        Date instance = SingletonDoubleCheckedLocking.getInstance()
        List<Date> singletonList = []

        when: "Se obtienen 1000000 instancias más"
        1000000.times{
            singletonList.add(SingletonDoubleCheckedLocking.getInstance())
        }

        then: "Son las mismas que la obtenida originalmente"
        singletonList.every{ Date newerInstance->
            newerInstance.getTime() == instance.getTime()
        }
    }
}