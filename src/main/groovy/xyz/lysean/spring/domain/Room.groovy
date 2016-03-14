package xyz.lysean.spring.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "xg_room")
class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    String name
    Boolean enable
    String keyCode
    long typeId
    String kid

    Room() {

    }

    Room(String name, Boolean enable, String keyCode, long typeId, String kid) {
        this.name = name
        this.enable = enable
        this.keyCode = keyCode
        this.typeId = typeId
        this.kid = kid
    }

    String toString() {
        String.format("Room[id=%d, name=%s, enable=%s, type_code=%s, type_id=%d, kid=%s]",
                id, name, enable.toString(), keyCode, typeId, kid)
    }

}