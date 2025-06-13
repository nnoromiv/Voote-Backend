package com.example.voote.controller

import com.example.voote.dto.SignUpRequest
import com.example.voote.service.AuthService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val authService: AuthService
) {

    @GetMapping("/login")
    fun login(): String {
        return "Login successful"
    }

    @GetMapping("/signup")
    fun signup(@RequestBody request: SignUpRequest): Map<String, Any> {
        val response = authService.signup(request)

        return mapOf(
            "uid" to response.uid,
            "email" to response.email,
            "message" to "Signup successful"
        )
    }
}