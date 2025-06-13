package com.example.voote.service

import com.example.voote.dto.SignUpRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userService: UserService
) {

    fun signup(request: SignUpRequest): UserRecord {
        val createRequest = UserRecord.CreateRequest()
            .setEmail(request.email)
            .setPhoneNumber(request.phoneNumber)
            .setDisplayName("${request.firstName} ${request.lastName}")
            .setPassword(request.password)

        val userRecord = FirebaseAuth.getInstance().createUser(createRequest)

        userService.saveUserProfile(
            uid = userRecord.uid,
            email = userRecord.email,
            firstName = request.firstName,
            lastName = request.lastName,
            phoneNumber = request.phoneNumber,
        )

        return userRecord
    }
}