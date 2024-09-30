package com.example.fairpriceapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fairpriceapp.models.Orders

class OrderViewModel : ViewModel() {
    private val _orders = MutableLiveData<List<Orders>>()
    val orders: LiveData<List<Orders>> get() = _orders

    private val orderList = mutableListOf<Orders>()

    fun fetchOrders() {
        _orders.value = orderList // Simulating fetching data
    }

    fun createOrder(order: Orders) {
        orderList.add(order)
        _orders.value = orderList
    }

    fun deleteOrder(orderId: String) {
        orderList.removeIf { it.id == orderId }
        _orders.value = orderList
    }
}

