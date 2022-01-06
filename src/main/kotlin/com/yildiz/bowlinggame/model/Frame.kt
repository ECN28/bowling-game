package com.yildiz.bowlinggame.model

import java.util.*
import javax.persistence.*

@Table(name = "frame")
@Entity
class Frame constructor(
    game: Game,
    firstRoll: Int,
    secondRoll: Int?,
    spare: Boolean?,
    strike: Boolean?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: UUID? = null
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    var game: Game

    var firstRoll: Int? = null
    var secondRoll: Int? = null
    var spare: Boolean? = null
    var strike: Boolean? = null

    init {
        this.game = game
        this.firstRoll = firstRoll
        this.secondRoll = secondRoll
        this.spare = spare
        this.strike = strike
    }
}