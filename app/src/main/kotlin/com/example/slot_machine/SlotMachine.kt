package com.example.slot_machine

import kotlin.random.Random


class SlotMachine(initialCash: Double) {

    private var cashInside = initialCash

    companion object {
        private const val SLOT_COUNT = 4
        const val priceToPlay = 1.0
    }

    enum class Color {
        BLACK, WHITE, GREEN, YELLOW,
    }

    private fun doSpin() = SpinResult(IntRange(1, SLOT_COUNT).associateWith { drawRandomColor() })

    private fun payPrize(result: SpinResult): Double {
        val amount = result.prize(cashInside)
        cashInside -= amount

        return amount
    }

    fun allowsPlayFor(coins: Double) = coins >= priceToPlay

    fun spin(): Double {
        val result = doSpin()
        println(result)
        val prize = payPrize(result)
        val message = (if (prize > 0) "Won $prize" else "Lost $priceToPlay").plus("\n")
        println(message)
        return prize
    }

    private fun drawRandomColor(): Color {
        val randomIndex = Random.nextInt(0, Color.values().size)
        return Color.values()[randomIndex]
    }

    fun insertCoin(): Double {
        cashInside += priceToPlay
        return priceToPlay
    }

    fun cashInside(): Double {
        return cashInside
    }

}
