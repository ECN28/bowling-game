package com.yildiz.bowlinggame

import com.yildiz.bowlinggame.dto.FrameDTO
import com.yildiz.bowlinggame.dto.PlayerDTO
import com.yildiz.bowlinggame.exception.RollNegativeInputException
import com.yildiz.bowlinggame.exception.RollToHighException
import com.yildiz.bowlinggame.model.Frame
import com.yildiz.bowlinggame.service.FrameService
import com.yildiz.bowlinggame.service.GameService
import com.yildiz.bowlinggame.service.PlayerService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.lang.NumberFormatException
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
        logger.info("Your name is $givenName $surname. Bowling Game started good Luck.")
        //save player
        val playerDTO = PlayerDTO(givenName, surname)
        val savedPlayer = playerService.createPlayer(playerDTO)
        //setup game and define necessary variables
        val frames: MutableList<Frame> = mutableListOf()
        val createdGame = gameService.createGame(savedPlayer, frames, 0)
        var strike = false
        var spare = false
        //simulate 10 rounds
        for(i in 1..10){
            logger.info("Round[$i] - Please enter your first roll score:")
            var roundOngoing = true
            var frame: FrameDTO
            var firstRoll: String?
            var sum1: Int
            var sum2: Int
            // while round is ongoing we fetch the scores of the rolls from the player
            while(roundOngoing){
                try{
                    firstRoll = readLine()
                    val firstPoints: Int = Integer.valueOf(firstRoll)
                    validateFirstRollPoints(firstPoints)
                    logger.info("First Roll points: $firstPoints")
                    //initialize frame
                    frame = FrameDTO(createdGame, firstPoints, null, null, null, null, i)
                }catch (ex: NumberFormatException){
                    logger.info("Please type a numeric value!")
                }catch (ex: RollToHighException){
                    logger.info(ex.message)
                }catch (ex: RollNegativeInputException){
                    logger.info(ex.message)
                }
            }
        }
    }

    fun validateFirstRollPoints(points: Int){
        if(points > maxPins){
            throw RollToHighException()
        }else if(points < 0){
            throw RollNegativeInputException()
        }
    }

    fun validateSecondRollPoints(point: Int, secondPoint: Int){
        val points = point + secondPoint
        if(points > maxPins){
            throw RollToHighException()
        }
    }

}