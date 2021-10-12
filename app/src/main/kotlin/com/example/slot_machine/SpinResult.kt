package com.example.slot_machine

import kotlin.math.min


class SpinResult(private val result: Map<Int, SlotMachine.Color>) {

    fun prize(allCashInMachine: Double): Double {
        return when {
            isAllEqual() -> allCashInMachine
            isAllDifferent() -> allCashInMachine / 2
            isTwoOrMoreInARow() -> min(allCashInMachine, SlotMachine.priceToPlay * 5)
            else -> 0.0
        }

    }

    private fun isTwoOrMoreInARow(): Boolean {
        for (index in 0 until result.size) {
            val current = result[index]
            val next = result[index + 1]
            if (current == next) return true
        }

        return false
    }

    private fun isAllDifferent(): Boolean {
        return result.map { it.value }.distinct().count() == result.size
    }

    private fun isAllEqual(): Boolean {
        return result.map { it.value }.distinct().count() == 1
    }

    override fun toString(): String {
        return "Spin result: ${result.values}"
    }
}