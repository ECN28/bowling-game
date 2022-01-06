package com.yildiz.bowlinggame.repository

import com.yildiz.bowlinggame.model.Player
import org.springframework.data.repository.CrudRepository
import java.util.*

interface PlayerRepository: CrudRepository<Player, UUID> {
}