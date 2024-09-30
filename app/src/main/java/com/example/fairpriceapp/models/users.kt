package com.example.fairpriceapp.models

data class Users (
    val id: String,            // Unique identifier for the user
    val username: String,      // Username of the user
    val email: String,         // Email address of the user
    val password: String        // User's password
)