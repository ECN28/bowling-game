package com.yildiz.bowlinggame.service

import com.yildiz.bowlinggame.dto.PlayerDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PlayerServiceTest {

    @Autowired
    lateinit var playerService: PlayerService

    @Test
    fun createValidPlayer(){
        val player = PlayerDTO(
            "Amelie",
            "Bruns"
        )
        val savedPlayer = playerService.createPlayer(player)
        Assertions.assertEquals(player.givenName, savedPlayer.givenName)
        Assertions.assertEquals(player.surname, savedPlayer.surname)
        Assertions.assertTrue(savedPlayer.id != null)
    }

    @Test
    fun updatePlayer(){
        val player = PlayerDTO(
            "Amelie",
            "Bruns"
        )
        val savedPlayer = playerService.createPlayer(player)
        Assertions.assertEquals(player.givenName, savedPlayer.givenName)
        Assertions.assertEquals(player.surname, savedPlayer.surname)
        Assertions.assertTrue(savedPlayer.id != null)

        //update saved player
        val updatePlayerDTO = PlayerDTO(
            "Thomas",
            "Schulz"
        )
        val updatedPlayer = playerService.updatePlayer(savedPlayer.id!!, updatePlayerDTO)
        Assertions.assertEquals(updatePlayerDTO.surname, updatedPlayer.surname)
        Assertions.assertEquals(updatePlayerDTO.givenName, updatedPlayer.givenName)
    }
}