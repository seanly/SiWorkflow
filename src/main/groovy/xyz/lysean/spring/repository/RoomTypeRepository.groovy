package xyz.lysean.spring.repository

import org.springframework.data.repository.CrudRepository
import xyz.lysean.spring.domain.RoomType

interface RoomTypeRepository extends CrudRepository<RoomType, Long> {

    RoomType findByName(String name)

}
