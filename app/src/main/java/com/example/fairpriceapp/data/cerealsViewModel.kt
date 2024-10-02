package com.example.fairpriceapp.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fairpriceapp.models.Cereals

class CerealsViewModel : ViewModel() {
    // LiveData for observing the list of cereals
    private val _cereals = MutableLiveData<List<Cereals>>()
    val cereals: MutableLiveData<List<Cereals>> get() = _cereals

    // Mutable list to hold the cereal items
    private val cerealList = mutableListOf<Cereals>()

    init {
        // Initial dummy data
        initializeDummyData()
    }

    // Method to initialize the dummy data
    private fun initializeDummyData() {
        cerealList.add(Cereals("1", "Maize", "Maize grains", 100.00f, ""))
        cerealList.add(Cereals("2", "Lentils", "Lentils grains", 120.00f, ""))
        _cereals.value = cerealList // Set initial value of _cereals
    }

    // Fetches the current list of cereals
    fun fetchCereals() {
        _cereals.value = cerealList // Simulating fetching data from a data source
    }

    // Adds a new cereal item
    fun addCereal(cereal: Cereals) {
        cerealList.add(cereal)
        _cereals.value = cerealList // Update LiveData
    }

    // Updates an existing cereal item
    fun updateCereal(cereal: Cereals) {
        val index = cerealList.indexOfFirst { it.id == cereal.id }
        if (index != -1) {
            cerealList[index] = cereal
            _cereals.value = cerealList // Update LiveData
        }
    }

    // Deletes a cereal item by ID
    fun deleteCereal(cerealId: String) {
        cerealList.removeIf { it.id == cerealId }
        _cereals.value = cerealList // Update LiveData
    }
}
