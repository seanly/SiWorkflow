package xyz.lysean.spring.repository

import org.springframework.data.repository.CrudRepository
import xyz.lysean.spring.domain.Customer

interface CustomerRepository extends CrudRepository<Customer, Long> {

}