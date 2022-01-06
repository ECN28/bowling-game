package com.yildiz.bowlinggame.service

import com.yildiz.bowlinggame.dto.GameDTO
import com.yildiz.bowlinggame.dto.toGame
import com.yildiz.bowlinggame.model.Frame
import com.yildiz.bowlinggame.model.Game
import com.yildiz.bowlinggame.model.Player
import com.yildiz.bowlinggame.repository.GameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class GameService @Autowired constructor(
    private val gameRepository: GameRepository
) {

    fun getGame(gameId: UUID): Game{
        return gameRepository.findById(gameId).get()
    }

    fun createGame(player: Player, frames: MutableList<Frame>, score: Int): Game{
        val gameDTO = GameDTO(player, frames, score)
        return gameRepository.save(gameDTO.toGame())
    }

    fun updateGame(gameId: UUID, player: Player? = null, frames: MutableList<Frame>? = null, score: Int? = null): Game {
        val game = gameRepository.findById(gameId).get()
        if(player != null){
            game.player = player
        }
        if(score != null){
            game.score = score
        }
        if(frames != null){
            game.frames = frames
        }
        return gameRepository.save(game)
    }

    fun deleteGame(gameId: UUID){
        gameRepository.deleteById(gameId)
    }

}