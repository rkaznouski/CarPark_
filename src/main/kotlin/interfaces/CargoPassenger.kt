package interfaces

import orders.Order

interface CargoPassenger: Vehicle, Passenger, Truck {

    override fun isBusFounded(order: Order): Boolean {
        return if (
            seatingCapacity >= order.passengerQuantity &&
            loadCapacity >= order.cargoWeight &&
            bodyCapacity >= order.cargoVolume
        ) {
            println("We have found bus for all passengers and luggage. Order id is ${order.id}.")
            true
        } else false
    }

    override fun loadOrder(order: Order) {
        seatingCapacity -= order.passengerQuantity
        bodyCapacity -= order.cargoVolume
        loadCapacity -= order.cargoWeight
        println("All passengers and luggage have been loaded.")
    }

    override fun unloadOrder(order: Order) {
        seatingCapacity += order.passengerQuantity
        bodyCapacity += order.cargoVolume
        loadCapacity += order.cargoWeight
        order.isOrderCompleted = true
        println("All passengers and luggage have been unloaded.")
    }

    override fun checkFreeVolume() {
        println("Free $seatingCapacity are(is) available.")
        println("Free volume is $bodyCapacity")
        println("Free load is $loadCapacity")
    }
}