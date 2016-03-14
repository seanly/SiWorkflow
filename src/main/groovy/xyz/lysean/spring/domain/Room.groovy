package xyz.lysean.spring.domain

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table


@Entity
@Table(name = "xg_room")
class Room extends AbstractEntity {

    final String kid
    String name
    Boolean enable

    @ManyToOne
    @JoinColumn(name="room_type_id")
    RoomType roomType

    Room() {

    }

    Room(String kid, String name, Boolean enable, RoomType roomType) {
        this.name = name
        this.kid = kid
        this.enable = enable
        this.roomType = roomType
    }

    String toString() {
        String.format("Room[kid=%s, id=%d, name=%s, enable=%s, room_type_id=%d, room_type_name=%s]",
                kid, id, name, enable.toString(), roomType.id, roomType.name)
    }

}