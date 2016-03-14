package xyz.lysean.spring.domain

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "xg_room_type")
class RoomType extends AbstractEntity{

    final String kid
    String name
    Boolean enable
    int priority

    protected RoomType() {

    }

    RoomType(String kid, String name, Boolean enable, int priority) {
        this.kid = kid
        this.name = name
        this.enable = enable
        this.priority = priority
    }

    String toString() {
        String.format("RoomType[kid=%s, id=%d, name=%s, enable=%s, priority=%d]",
                kid, id, name, enable.toString(), priority)
    }

}
