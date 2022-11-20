package vehicles

import core.*
import interfaces.Passenger
import interfaces.Vehicle
import orders.TypeOfCargo

class Bus(
    // Common properties
    override val year: Int,
    override val brand: String,
    override val model: String,
    override val fuelType: String,
    override val fuelConsumption: Float,
    override var isRepaired: Boolean = true,
    override var isFueledUp: Boolean = true,
    // Specific properties
    override var seatingCapacity: Int = BUS_MIN_SEATING_CAPACITY,
    override val purpose: Set<TypeOfCargo> = setOf(TypeOfCargo.PASSENGERS),
    override var isDisinfected: Boolean = true
): Vehicle, Passenger