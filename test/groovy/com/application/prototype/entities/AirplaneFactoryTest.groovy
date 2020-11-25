package com.application.prototype.entities

import com.application.prototype.factories.AirplaneFactory
import com.application.prototype.factories.IAirplaneFactory
import spock.lang.Specification

import java.awt.Color

class AirplaneFactoryTest extends Specification{

    void "Test that all objects are valid clones"() {
        final String PHENOM100 = "PHENOM100"
        final String CITATION1 = "CITATION1"

        given: "An factory of Airplanes who have two prototypes for clone"
        Jet phenom100Prototype = Jet.create(
                PHENOM100,
                "Phenom 100",
                JetType.create("VLJ"),
                7,
                Color.WHITE
        )

        Jet citation1Prototype = Jet.create(
                CITATION1,
                "Citation I",
                JetType.create("LJ"),
                5,
                Color.WHITE
        )

        IAirplaneFactory airplaneFactory = AirplaneFactory.from([PHENOM100: phenom100Prototype, CITATION1: citation1Prototype])

        when: "5 phenoms 100 and 5 citationI is created"
        List<Jet> phenom100List = []
        List<Jet> citationIList = []

        5.times{
            phenom100List.add((Jet) airplaneFactory.create(PHENOM100))
            citationIList.add((Jet) airplaneFactory.create(CITATION1))
        }

        then: "Every jet in the list has the same value than original prototypical object. Also, the JetType is another object (deep clonation)"
        phenom100List.code.every{ it == phenom100Prototype.code}
        phenom100List.name.every{ it == phenom100Prototype.name}
        phenom100List.type.name.every{ it == phenom100Prototype.type.name}
        phenom100List.type.hashCode().every{ it != phenom100Prototype.type.hashCode()}
        phenom100List.numberOfPassanger.every{ it == phenom100Prototype.numberOfPassanger}
        phenom100List.baseColor.every{ it == phenom100Prototype.baseColor}

        citationIList.code.every{ it == citation1Prototype.code}
        citationIList.name.every{ it == citation1Prototype.name}
        citationIList.type.name.every{ it == citation1Prototype.type.name}
        citationIList.type.hashCode().every{ it != citation1Prototype.type.hashCode()}
        citationIList.numberOfPassanger.every{ it == citation1Prototype.numberOfPassanger}
        citationIList.baseColor.every{ it == citation1Prototype.baseColor}

        and: "Every objects in the list are different instances"
        phenom100List.hashCode().every{ int jetHashCode -> phenom100Prototype.hashCode()}
        citationIList.hashCode().every{ int jetHashCode -> citation1Prototype.hashCode()}
    }
}
