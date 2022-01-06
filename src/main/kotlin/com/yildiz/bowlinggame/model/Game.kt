package com.yildiz.bowlinggame.model

import java.util.*
import javax.persistence.*

@Table(name = "game")
@Entity
class Game constructor(
    player: Player,
    frames: MutableList<Frame>,
    score: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: UUID? = null
    @OneToOne(cascade = [CascadeType.ALL])
    var player: Player? = null
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "game")
    var frames: MutableList<Frame> = mutableListOf()
    var score: Int? = null
    init {
        this.player = player
        this.frames = frames
        this.score = score
    }
}