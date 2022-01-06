package com.yildiz.bowlinggame

import com.yildiz.bowlinggame.dto.PlayerDTO
import com.yildiz.bowlinggame.service.FrameService
import com.yildiz.bowlinggame.service.GameService
import com.yildiz.bowlinggame.service.PlayerService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import javax.transaction.Transactional

/*
    GameRunner extends CommandLineRunner and simulates a client application
    by providing a text interface through the console.
 */

@Component
@Transactional
class GameRunner @Autowired constructor(
    private val gameService: GameService,
    private val playerService: PlayerService,
    private val frameService: FrameService
): CommandLineRunner {

    val logger = LoggerFactory.getLogger(GameRunner::class.java)
    val maxPins = 10

    override fun run(vararg args: String?) {
        //welcome and get player info
        logger.info("Welcome to the bowling game. Please enter your given name in the console first:")
        val givenName = readLine()!!
        logger.info("next enter your surname:")
        val surname = readLine()!!
        logger.info("Your name is $givenName $surname. Start the game and tell us about your roll points. Good luck!")

        //save player
        val playerDTO = PlayerDTO(givenName, surname)
        val savedPlayer = playerService.createPlayer(playerDTO)
    }
}