package com.yildiz.bowlinggame.dto

import com.yildiz.bowlinggame.model.Frame
import com.yildiz.bowlinggame.model.Game

data class FrameDTO(
    var game: Game,
    var firstRoll: Int,
    var secondRoll: Int?,
    var spare: Boolean?,
    var strike: Boolean?,
)

fun FrameDTO.toFrame() = Frame(
    game = game,
    firstRoll = firstRoll,
    secondRoll = secondRoll,
    spare = spare,
    strike = strike,
)