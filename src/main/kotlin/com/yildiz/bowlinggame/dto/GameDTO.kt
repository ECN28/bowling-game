package com.yildiz.bowlinggame.dto

import com.yildiz.bowlinggame.model.Frame
import com.yildiz.bowlinggame.model.Game
import com.yildiz.bowlinggame.model.Player

data class GameDTO (
    var player: Player,
    var frames: MutableList<Frame>,
    var score: Int
)

fun GameDTO.toGame() = Game(
    player = player,
    frames = frames,
    score = score
)