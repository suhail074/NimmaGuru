package com.example.nimmaguru.repository

import com.google.firebase.firestore.FirebaseFirestore

class ProfileRepository {

    private val firestore = FirebaseFirestore.getInstance()

    fun saveProfile(
        name: String,
        skill: String,
        location: String,
        role: String,
        imageUri: String?,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {

        val profile = hashMapOf(
            "name" to name,
            "skill" to skill,
            "location" to location,
            "role" to role,
            "imageUrl" to imageUri
        )

        firestore
            .collection("users")
            .add(profile)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it)
            }
    }
}