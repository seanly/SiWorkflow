package xyz.lysean.spring.repository

import org.springframework.data.repository.CrudRepository
import xyz.lysean.spring.domain.Room

interface RoomRepository extends CrudRepository<Room, Long> {
}
