package com.yildiz.bowlinggame.model

import com.yildiz.bowlinggame.dto.FrameDTO
import java.util.*
import javax.persistence.*

@Table(name = "frame")
@Entity
class Frame constructor(
    game: Game,
    firstRoll: Int,
    secondRoll: Int?,
    spare: Boolean?,
    strike: Boolean?,
    subtotal: Int?,
    round: Int?
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
    var subtotal: Int? = null
    var round: Int? = null

    init {
        this.game = game
        this.firstRoll = firstRoll
        this.secondRoll = secondRoll
        this.spare = spare
        this.strike = strike
        this.subtotal = subtotal
        this.round = round
    }
}
fun Frame.toFrameDTO() = FrameDTO(
    game = game,
    firstRoll = firstRoll!!,
    secondRoll = secondRoll,
    spare = spare,
    strike = strike,
    subtotal = subtotal,
    round = round
)
