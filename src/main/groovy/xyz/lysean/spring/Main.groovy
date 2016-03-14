package xyz.lysean.spring

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.lysean.spring.domain.Customer
import xyz.lysean.spring.domain.Room
import xyz.lysean.spring.repository.CustomerRepository
import xyz.lysean.spring.repository.RoomRepository


@Configuration
@EnableAutoConfiguration
@ComponentScan(['xyz.lysean.spring'])
@RestController
class Main {

    static final Logger log = LoggerFactory.getLogger(Main.class)

    static void main(String...args) {
        SpringApplication.run(Main.class, args)
    }

    @RequestMapping("/")
    String index() {
        "hello, groovy"
    }
    /*
    @Bean
    CommandLineRunner demo(CustomerRepository customerRepository) {
        {args ->
            customerRepository.save(new Customer("Jack", "Bauer"))
            customerRepository.save(new Customer("Sean", "Ly"))

            // fetch all customer
            log.info("Customers found with findAll(): ")
            log.info("---------------------------------")
            for(Customer customer: customerRepository.findAll()) {
                log.info(customer.toString())
            }
            log.info("")

            // fetch an individual customer by ID
            Customer customer = customerRepository.findOne(1L)
            log.info("customer found with findOne(1L")
            log.info("----------------------")
            log.info(customer.toString())
            log.info("")

        }
    }

    */

    @Bean
    CommandLineRunner room(RoomRepository roomRepository) {
        {args ->
            roomRepository.save(new Room("v801", false, "801", 1L, "isongktv"))
            roomRepository.save(new Room("v802", false, "802", 1L, "isongktv"))

            // fetch all customer
            log.info("Room found with findAll(): ")
            log.info("---------------------------------")
            for(Room room: roomRepository.findAll()) {
                log.info(room.toString())
            }
            log.info("")
        }
    }
}