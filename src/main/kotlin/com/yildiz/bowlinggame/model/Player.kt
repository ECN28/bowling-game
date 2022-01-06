package com.yildiz.bowlinggame.model

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