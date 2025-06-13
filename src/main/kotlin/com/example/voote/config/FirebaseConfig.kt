package com.example.voote.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream
import javax.annotation.PostConstruct

@Configuration
class FirebaseConfig() {

    @PostConstruct
    fun initialize() {
        val inputStream = javaClass.classLoader.getResourceAsStream("firebase-admin-sdk.json")

        val serviceAccount = FileInputStream("src/main/resources/firebase-admin-sdk.json")

        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build()

        if(FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options)
        }
    }
}