package com.yildiz.bowlinggame.service

import com.yildiz.bowlinggame.dto.PlayerDTO
import com.yildiz.bowlinggame.dto.toPlayer
import com.yildiz.bowlinggame.model.Player
import com.yildiz.bowlinggame.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class PlayerService @Autowired constructor(
    private val playerRepository: PlayerRepository
) {

    fun createPlayer(playerDTO: PlayerDTO): Player {
        return playerRepository.save(playerDTO.toPlayer())
    }

    fun updatePlayer(playerId: UUID, playerDTO: PlayerDTO): Player {
        var player = playerRepository.findById(playerId).get()
        player.surname = playerDTO.surname
        player.givenName = playerDTO.givenName
        return playerRepository.save(player)
    }

    fun deletePlayer(playerId: UUID){
        playerRepository.deleteById(playerId)
    }

}