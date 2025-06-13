package com.example.voote.service

import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Service

@Service
class UserService {

    private val firestore = FirestoreClient.getFirestore()

    fun saveUserProfile(uid: String, email: String, firstName: String, lastName: String, phoneNumber: String) {
        val userDoc = mapOf<String, Any>(
            "uid" to uid,
            "email" to email,
            "firstName" to firstName,
            "lastName" to lastName,
            "phoneNumber" to phoneNumber,
            "isVerified" to false,
            "role" to "user",
            "createdAt" to System.currentTimeMillis()
        )

        firestore.collection("users")
            .document(uid)
            .set(userDoc)
    }

    fun updateUserVerificationStatus(uid: String, isVerified: Boolean) {
        val update = mapOf<String, Any>("isVerified" to isVerified)

        firestore.collection("users")
            .document(uid)
            .update(update)
    }
}