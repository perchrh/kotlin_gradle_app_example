package com.example.slot_machine

class App {

    fun simulate() {
        val player = Player(25.5, "Joe")
        println("${player.name} plays the slot machine, using their ¤${player.availableCash}\n")

        val machine = SlotMachine(170.0)
        player.playUntilBrokeOrDouble(machine)
        player.leave(machine)

        println("The machine was left with ¤${machine.cashInside()} inside")
    }

}

fun main() {
    val app = App()
    app.simulate()

}
