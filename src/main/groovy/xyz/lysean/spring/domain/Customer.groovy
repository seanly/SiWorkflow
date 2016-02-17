package xyz.lysean.spring.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    String firstName
    String lastName

    Customer() {

    }

    Customer(String firstName, String lastName) {
        this.firstName = firstName
        this.lastName = lastName
    }

    String toString() {
        String.format("Customer[id=%d, firstName=%s, lastName=%s]", id, firstName, lastName)
    }

}