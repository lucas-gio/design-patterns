package com.application.builder.withStaticInnerClass

import com.application.builder.relatedEntities.*
import spock.lang.Specification

class CustomerTest extends Specification {

	def "Se verifica que el builder de clientes genera nuevas instancias"(){
		List<Integer> customerHashCodeList = []
		when: "Se crean 5.000 instancias"
		5000.times{
			customerHashCodeList << new Customer.Builder("1", "a", "b", CustomerType.GOLD).build().hashCode()
		}

		then: "Son todas distintas"
		customerHashCodeList.unique().size() == 5000
	}

	def "Se verifica que el builder de clientes genera correctamente los clientes"(){
		when: "Se crea un cliente con datos requeridos sólamente"
		Customer customer = new Customer.Builder("1", "Julio", "César", CustomerType.GOLD)
							.build()

		then: "No hubo excepción"
		notThrown(Exception)

		and: "Tiene los datos esperados"
		customer.code == "1"
		customer.name == "Julio"
		customer.lastName == "César"
		customer.birthDate == null
		customer.type == CustomerType.GOLD
		customer.registrationDate == null
		customer.loyaltyCards == null
		customer.frequency == null
		customer.lastPurchaseDate == null
		customer.preferredItems == null
		customer.city == null
		customer.state == null
		customer.country == null
		customer.isActive == Boolean.TRUE

		when: "Se crea otro cliente con algunos datos no especificados"
		customer = new Customer.Builder("2", "Marco", "Aurelio", CustomerType.VIP)
							.withBirthDate(new Date().clearTime())
							.withRegistrationDate(new Date().clearTime())
							.withIsActive(false)
							.build()

		then: "No hubo excepción"
		notThrown(Exception)

		and: "Tiene los datos esperados"
		customer.code == "2"
		customer.name == "Marco"
		customer.lastName == "Aurelio"
		customer.birthDate == new Date().clearTime()
		customer.type == CustomerType.VIP
		customer.registrationDate == new Date().clearTime()
		customer.loyaltyCards == null
		customer.frequency == null
		customer.lastPurchaseDate == null
		customer.preferredItems == null
		customer.city == null
		customer.state == null
		customer.country == null
		customer.isActive == Boolean.FALSE

		when: "Se crea otro cliente con todos los atributos"
		customer = new Customer.Builder("3", "Nerón", "Nerón", CustomerType.SILVER)
				.withBirthDate(new Date().clearTime())
				.withRegistrationDate(new Date().clearTime())
				.withLoyaltyCards([
						new Card([code:"1111", status: CardStatus.ENABLED]),
						new Card([code:"2222", status:CardStatus.IS_NOT_LONGER_VALID])
				])
				.withFrequency(CustomerFrequency.FREQUENT)
				.withLastPurchaseDate(new Date().clearTime())
				.withPreferredItems([
						new Item([code:"1234"]),
						new Item([code:"2345"]),
						new Item([code:"3456"])
				])
				.withCity(new City([code:"dol"]))
				.withState(new State([code:"bsas"]))
				.withCountry(new Country([code:"ar"]))
				.withIsActive(true)
				.build()

		then: "No hubo excepción"
		notThrown(Exception)

		and: "Tiene los datos esperados"
		customer.code == "3"
		customer.name == "Nerón"
		customer.lastName == "Nerón"
		customer.birthDate == new Date().clearTime()
		customer.type == CustomerType.SILVER
		customer.registrationDate == new Date().clearTime()
		customer.loyaltyCards
		customer.loyaltyCards.size() == 2
		customer.loyaltyCards.code == ["1111","2222"]
		customer.frequency == CustomerFrequency.FREQUENT
		customer.lastPurchaseDate == new Date().clearTime()
		customer.preferredItems
		customer.preferredItems.size() == 3
		customer.preferredItems.code == ["1234", "2345", "3456"]
		customer.city.code == "dol"
		customer.state.code == "bsas"
		customer.country.code == "ar"
		customer.isActive == Boolean.TRUE
	}
}
