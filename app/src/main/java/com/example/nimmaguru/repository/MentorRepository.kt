package com.example.nimmaguru.repository

import com.example.nimmaguru.model.Mentor
import com.google.firebase.firestore.FirebaseFirestore

class MentorRepository {

    private val db = FirebaseFirestore.getInstance()

    fun addMentor(mentor: Mentor) {

        db.collection("mentors")
            .add(mentor)
    }

    fun getMentors(
        onResult: (List<Mentor>) -> Unit
    ) {

        db.collection("mentors")
            .get()
            .addOnSuccessListener { result ->

                val mentorList = mutableListOf<Mentor>()

                for (document in result) {

                    val mentor =
                        document.toObject(Mentor::class.java)

                    mentorList.add(mentor)
                }

                onResult(mentorList)
            }
    }
}