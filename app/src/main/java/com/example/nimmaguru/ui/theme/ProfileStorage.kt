package com.example.nimmaguru.ui.theme

import android.content.Context

object ProfileStorage {

    // ================= STUDENT =================

    private const val STUDENT_PREF = "student_profile"

    fun saveStudentName(context: Context, value: String) {
        context.getSharedPreferences(STUDENT_PREF, Context.MODE_PRIVATE)
            .edit()
            .putString("student_name", value)
            .apply()
    }

    fun getStudentName(context: Context): String {
        return context.getSharedPreferences(STUDENT_PREF, Context.MODE_PRIVATE)
            .getString("student_name", "Student Name") ?: "Student Name"
    }

    fun saveStudentLocation(context: Context, value: String) {
        context.getSharedPreferences(STUDENT_PREF, Context.MODE_PRIVATE)
            .edit()
            .putString("student_location", value)
            .apply()
    }

    fun getStudentLocation(context: Context): String {
        return context.getSharedPreferences(STUDENT_PREF, Context.MODE_PRIVATE)
            .getString("student_location", "Student Location") ?: "Student Location00" +
        " "
    }

    fun saveStudentImage(context: Context, value: String) {
        context.getSharedPreferences(STUDENT_PREF, Context.MODE_PRIVATE)
            .edit()
            .putString("student_image", value)
            .apply()
    }

    fun getStudentImage(context: Context): String {
        return context.getSharedPreferences(STUDENT_PREF, Context.MODE_PRIVATE)
            .getString("student_image", "") ?: ""
    }

    // ================= MENTOR =================

    private const val MENTOR_PREF = "mentor_profile"

    fun saveMentorName(context: Context, value: String) {
        context.getSharedPreferences(MENTOR_PREF, Context.MODE_PRIVATE)
            .edit()
            .putString("mentor_name", value)
            .apply()
    }

    fun getMentorName(context: Context): String {
        return context.getSharedPreferences(MENTOR_PREF, Context.MODE_PRIVATE)
            .getString("mentor_name", "Name") ?: "Name"
    }

    fun saveMentorLocation(context: Context, value: String) {
        context.getSharedPreferences(MENTOR_PREF, Context.MODE_PRIVATE)
            .edit()
            .putString("mentor_location", value)
            .apply()
    }

    fun getMentorLocation(context: Context): String {
        return context.getSharedPreferences(MENTOR_PREF, Context.MODE_PRIVATE)
            .getString("mentor_location", "Guru Location") ?: "Guru Location"
    }

    fun saveMentorSkill(context: Context, value: String) {
        context.getSharedPreferences(MENTOR_PREF, Context.MODE_PRIVATE)
            .edit()
            .putString("mentor_skill", value)
            .apply()
    }

    fun getMentorSkill(context: Context): String {
        return context.getSharedPreferences(MENTOR_PREF, Context.MODE_PRIVATE)
            .getString("mentor_skill", "Choose Skill") ?: "Choose Skill"
    }

    fun saveMentorTime(context: Context, value: String) {
        context.getSharedPreferences(MENTOR_PREF, Context.MODE_PRIVATE)
            .edit()
            .putString("mentor_time", value)
            .apply()
    }

    fun getMentorTime(context: Context): String {
        return context.getSharedPreferences(MENTOR_PREF, Context.MODE_PRIVATE)
            .getString("mentor_time", "8 PM - 10 PM") ?: "8 PM - 10 PM"
    }

    fun saveMentorBio(context: Context, value: String) {
        context.getSharedPreferences(MENTOR_PREF, Context.MODE_PRIVATE)
            .edit()
            .putString("mentor_bio", value)
            .apply()
    }

    fun getMentorBio(context: Context): String {
        return context.getSharedPreferences(MENTOR_PREF, Context.MODE_PRIVATE)
            .getString("mentor_bio", "Update Bio") ?: "Update Bio"
    }

    fun saveMentorImage(context: Context, value: String) {
        context.getSharedPreferences(MENTOR_PREF, Context.MODE_PRIVATE)
            .edit()
            .putString("mentor_image", value)
            .apply()
    }

    fun getMentorImage(context: Context): String {
        return context.getSharedPreferences(MENTOR_PREF, Context.MODE_PRIVATE)
            .getString("mentor_image", "") ?: ""
    }
}