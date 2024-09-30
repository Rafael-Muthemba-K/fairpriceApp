package com.example.fairpriceapp.data

import com.example.fairpriceapp.models.Cereals

class CerealRepository {
    private val cereals = mutableListOf<Cereals>()

    fun getCereals(): List<Cereals> {
        return cereals
    }

    fun addCereal(cereal: Cereals) {
        cereals.add(cereal)
    }

    fun updateCereal(cereal: Cereals) {
        val index = cereals.indexOfFirst { it.id == cereal.id }
        if (index != -1) {
            cereals[index] = cereal
        }
    }

    fun deleteCereal(cerealId: String) {
        cereals.removeIf { it.id == cerealId }
    }
}
