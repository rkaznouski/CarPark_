package interfaces

import orders.TypeOfCargo
import orders.Order

interface Truck: Vehicle {
    val purpose: Set<TypeOfCargo>
    var bodyCapacity: Float
    var loadCapacity: Float
    var isSealedBody: Boolean

    fun sealBody(isSealedBody: Boolean) {
        this.isSealedBody = isSealedBody
        if (isSealedBody) println("Body is sealed. Ready for transportation.")
        else println("Body is unsealed. Ready for unloading.")
    }

    fun isTruckFound(order: Order): Boolean {
        return if (bodyCapacity >= order.cargoVolume && loadCapacity >= order.cargoWeight) {
            println("We have found vehicle for your order. Order id is ${order.id}.")
            true
        } else false
    }

    fun loadOrder(order: Order) {
        bodyCapacity -= order.cargoVolume
        loadCapacity -= order.cargoWeight
        println("Order have been loaded.")
    }

    fun unloadOrder(order: Order) {
        bodyCapacity += order.cargoVolume
        loadCapacity += order.cargoWeight
        order.isOrderCompleted = true
        println("Order have been unloaded.")
    }

    fun checkFreeVolume() {
        println("Free volume is $bodyCapacity")
        println("Free load is $loadCapacity")
    }
}