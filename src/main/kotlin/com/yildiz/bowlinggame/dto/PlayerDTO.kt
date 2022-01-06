package com.yildiz.bowlinggame.dto

import com.yildiz.bowlinggame.model.Player

data class PlayerDTO (
    var givenName: String,
    var surname: String
)

fun PlayerDTO.toPlayer() = Player(
    givenName = givenName,
    surname = surname
)