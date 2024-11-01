package com.example.registrationapp

import java.io.Serializable

data class Details(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val password: String,
    val title: String
) : Serializable