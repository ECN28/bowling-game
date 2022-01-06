package com.yildiz.bowlinggame.model

import com.yildiz.bowlinggame.dto.PlayerDTO
import java.util.*
import javax.persistence.*

@Table(name = "player")
@Entity
class Player constructor(
    givenName: String,
    surname: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: UUID? = null
    var givenName: String? = null
    var surname: String? = null
    init {
        this.givenName = givenName
        this.surname = surname
    }
}

fun Player.toPlayerDTO() = PlayerDTO(
    givenName = givenName!!,
    surname = surname!!
)