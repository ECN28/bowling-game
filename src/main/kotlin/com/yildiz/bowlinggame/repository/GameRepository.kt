package com.yildiz.bowlinggame.repository

import com.yildiz.bowlinggame.model.Game
import org.springframework.data.repository.CrudRepository
import java.util.*

interface GameRepository: CrudRepository<Game, UUID> {
}