package com.example.fairpriceapp.models

data class Orders (
    val id: String,            // Unique identifier for the order
    val cerealId: String,      // ID of the cereal being ordered
    val quantity: Int,         // Quantity of the cereal ordered
    val totalPrice: Double,     // Total price of the order
    val orderDate: Long        // Timestamp for the order date
)
