package com.yildiz.bowlinggame.service

import com.yildiz.bowlinggame.dto.FrameDTO
import com.yildiz.bowlinggame.dto.toFrame
import com.yildiz.bowlinggame.model.Frame
import com.yildiz.bowlinggame.model.Game
import com.yildiz.bowlinggame.repository.FrameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class FrameService @Autowired constructor(
    private val frameRepository: FrameRepository
) {

    fun createFrame(game: Game, frameDTO: FrameDTO): Frame {
        return frameRepository.save(frameDTO.toFrame())
    }

    fun updateFrame(frameId: UUID, firstRoll: Int, secondRoll: Int? = null): Frame {
        var frame = frameRepository.findById(frameId).get()
        frame.firstRoll = firstRoll
        if(secondRoll != null){
            frame.secondRoll = secondRoll
        }
        return frameRepository.save(frame)
    }

    fun deleteFrame(frameId: UUID){
        frameRepository.deleteById(frameId)
    }
}