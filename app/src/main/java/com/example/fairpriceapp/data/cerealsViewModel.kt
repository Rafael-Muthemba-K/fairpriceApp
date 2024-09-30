package com.example.fairpriceapp.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fairpriceapp.models.Cereals

class CerealsViewModel : ViewModel() {
    private val _cereals = MutableLiveData<List<Cereals>>() // Change to List<Cereals>
    val cereals: MutableLiveData<List<Cereals>> get() = _cereals

    private val cerealList = mutableListOf<Cereals>()

    init {
        // Initial dummy data
        cerealList.add(Cereals("1", "Maize", "Maize grains", 100, ""))
        cerealList.add(Cereals("2", "Lentils", "Lentils grains", 120, ""))
        _cereals.value = cerealList // Set initial value of _cereals
    }

    fun fetchCereals() {
        _cereals.value = cerealList // Simulating fetching data
    }

    fun addCereal(cereal: Cereals) {
        cerealList.add(cereal)
        _cereals.value = cerealList
    }

    fun updateCereal(cereal: Cereals) {
        val index = cerealList.indexOfFirst { it.id == cereal.id }
        if (index != -1) {
            cerealList[index] = cereal
            _cereals.value = cerealList
        }
    }

    fun deleteCereal(cerealId: String) {
        cerealList.removeIf { it.id == cerealId }
        _cereals.value = cerealList
    }
}
