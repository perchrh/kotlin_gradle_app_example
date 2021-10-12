package com.example.slot_machine

import com.example.slot_machine.SlotMachine.Color
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SpinResultTest {

    @Test
    fun `jackpot prize is all cash in the machine`() {
        val winnings = SpinResult(mapOf(1 to Color.BLACK, 2 to Color.BLACK, 3 to Color.BLACK, 4 to Color.BLACK))
        val cashInMachine = 100.0
        val prize = winnings.prize(cashInMachine)
        assertEquals(prize, cashInMachine)
    }

    @Test
    fun `all different colors pays half of all cash in the machine`() {
        val winnings = SpinResult(mapOf(1 to Color.BLACK, 2 to Color.WHITE, 3 to Color.GREEN, 4 to Color.YELLOW))
        val cashInMachine = 100.0
        val prize = winnings.prize(cashInMachine)
        assertEquals(prize, cashInMachine/2)
    }

    @Test
    fun `two in a row pays a prize`() {
        val winnings = SpinResult(mapOf(1 to Color.BLACK, 2 to Color.BLACK, 3 to Color.GREEN, 4 to Color.YELLOW))
        val cashInMachine = 100.0
        val prize = winnings.prize(cashInMachine)
        assertEquals(prize, SlotMachine.priceToPlay * 5)
    }

    @Test
    fun `more than two in a row pays a prize`() {
        val winnings = SpinResult(mapOf(1 to Color.BLACK, 2 to Color.BLACK, 3 to Color.BLACK, 4 to Color.YELLOW))
        val cashInMachine = 100.0
        val prize = winnings.prize(cashInMachine)
        assertEquals(prize, SlotMachine.priceToPlay * 5)
    }

}