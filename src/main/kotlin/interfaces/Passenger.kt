package interfaces

import orders.Order
import orders.TypeOfCargo

interface Passenger: Vehicle {
    val purpose: Set<TypeOfCargo>
    var seatingCapacity: Int
    var isDisinfected: Boolean

    fun disinfected(isDisinfected: Boolean) {
        this.isDisinfected = isDisinfected
        if (isDisinfected) println("Interior of the bus is disinfected.")
        else println("Interior is dirty.")
    }

    fun isBusFounded(order: Order): Boolean {
        return if (seatingCapacity >= order.passengerQuantity) {
            println("We have found bus for all passengers. Order id is ${order.id}.")
            true
        } else false
    }

    fun boardingPassengers(order: Order) {
        seatingCapacity -= order.passengerQuantity
        println("All passengers have been boarded.")
    }

    fun  disembarkingPassengers(order: Order) {
        seatingCapacity += order.passengerQuantity
        order.isOrderCompleted = true
        println("All passengers have been disembarked.")
    }

    fun checkFreeSeats() {
        println("There are(is) free $seatingCapacity number of seats.")
    }
}