package com.yildiz.bowlinggame.repository

import com.yildiz.bowlinggame.model.Frame
import org.springframework.data.repository.CrudRepository
import java.util.*

interface FrameRepository: CrudRepository<Frame, UUID> {
}