package com.example.voote.dto

data class SignUpRequest(
    val email: String,
    val password: String,
    val phoneNumber: String,
    val firstName: String,
    val lastName: String,
)


