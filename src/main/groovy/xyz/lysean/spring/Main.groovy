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
import xyz.lysean.spring.domain.RoomType
import xyz.lysean.spring.repository.CustomerRepository
import xyz.lysean.spring.repository.RoomRepository
import xyz.lysean.spring.repository.RoomTypeRepository

import javax.annotation.Resource


@Configuration
@EnableAutoConfiguration
@ComponentScan(['xyz.lysean.spring'])
@RestController
class Main {

    static final Logger log = LoggerFactory.getLogger(Main.class)

    static void main(String...args) {
        SpringApplication.run(Main.class, args)
    }

    @Resource
    RoomRepository roomRepository

    @RequestMapping("/")
    List<Room> index() {
        //"hello, groovy"
        roomRepository.findAll()
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
    CommandLineRunner demo(RoomRepository roomRepository, RoomTypeRepository roomTypeRepository) {
        {args ->

            roomRepository.deleteAll()
            roomTypeRepository.deleteAll()

            roomTypeRepository.save(new RoomType("seanly", "大包", true, 10))
            roomTypeRepository.save(new RoomType("seanly", "中包", true, 20))

            roomRepository.save(new Room("seanly", "901", true, roomTypeRepository.findByName("大包")))
            roomRepository.save(new Room("seanly", "801", false, roomTypeRepository.findByName("中包")))


            log.info("Room List: ")
            log.info("=================================")
            for (Room room: roomRepository.findAll()) {
                log.info(room.toString())
            }

        }
    }


}