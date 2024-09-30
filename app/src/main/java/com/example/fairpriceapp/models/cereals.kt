package com.example.fairpriceapp.models

data class Cereals(
    val id: String,          // Unique identifier for the cereal
    val name: String,        // Name of the cereal
    val description: String, // Description of the cereal
    val price: Int,       // Price of the cereal
    val imageUrl: String     // URL for the cereal's image
)