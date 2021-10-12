package com.example.slot_machine

class App {

    fun simulate() {
        val player = Player(25.5, "Joe")
        println("${player.name} plays the slot machine, using their ¤${player.availableCash}")
        val machine = SlotMachine(170.0)

        println("The machine starts with ¤${machine.cashInside()} inside")
        println()

        player.playUntilBrokeOrDouble(machine)
        player.leave(machine)

        println("The machine was left with ¤${machine.cashInside()} inside")
    }

}

fun main() {
    val app = App()
    app.simulate()

}
