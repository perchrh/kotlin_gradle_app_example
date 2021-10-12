package com.example.slot_machine

class Player(var availableCash: Double, val name: String) {

    private val initialCash = availableCash

    fun playUntilBrokeOrDouble(machine: SlotMachine) {
        while (canAffordToPlayMore(machine) && !hasDoubledTheirMoney()) {
            val payToPlay = machine.insertCoin()
            availableCash -= payToPlay
            val winnings = machine.spin()
            availableCash += winnings
        }
    }

    private fun canAffordToPlayMore(machine: SlotMachine) = machine.allowsPlayFor(availableCash)

    private fun hasDoubledTheirMoney() = availableCash >= 2 * initialCash

    fun leave(machine: SlotMachine) {
        if (hasDoubledTheirMoney()) ConsolePrinter.printInGreen("$name doubled their money or more, at $availableCash. Nice!")
        if (!canAffordToPlayMore(machine)) ConsolePrinter.printInRed("$name cannot afford to play anymore :(")
    }

}

object ConsolePrinter {
    val RESET = "\u001b[0m"
    val TEXT_RED = "\u001B[31m"
    val TEXT_GREEN = "\u001B[32m"

    fun printInRed(message: String) = println("$TEXT_RED$message$RESET")
    fun printInGreen(message: String) = println("$TEXT_GREEN$message$RESET")

}