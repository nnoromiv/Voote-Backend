package com.example.voote

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VooteApplication

fun main(args: Array<String>) {
	runApplication<VooteApplication>(*args)
}
