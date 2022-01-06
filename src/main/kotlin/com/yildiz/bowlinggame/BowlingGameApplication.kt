package com.yildiz.bowlinggame

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BowlingGameApplication

fun main(args: Array<String>) {
	runApplication<BowlingGameApplication>(*args)
}
