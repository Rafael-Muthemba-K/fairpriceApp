package com.example.fairpriceapp.data

import com.example.fairpriceapp.models.Orders

class OrderRepository {
    private val orders = mutableListOf<Orders>()

    fun getOrders(): List<Orders> {
        return orders
    }

    fun addOrder(order: Orders) {
        orders.add(order)
    }

    fun deleteOrder(orderId: String) {
        orders.removeIf { it.id == orderId }
    }
}
