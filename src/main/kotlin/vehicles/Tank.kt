package vehicles

import core.*
import interfaces.Truck
import interfaces.Vehicle
import orders.TypeOfCargo
import orders.TypeOfCargo.*

class Tank(
    // Common properties
    override val year: Int,
    override val brand: String,
    override val model: String,
    override val fuelType: String,
    override val fuelConsumption: Float,
    override var isRepaired: Boolean = true,
    override var isFueledUp: Boolean = true,
    // Specific properties
    override var bodyCapacity: Float = TANK_MAX_VOLUME,
    override var loadCapacity: Float = TANK_MAX_TONS,
    override val purpose: Set<TypeOfCargo> = setOf(LIQUID),
    override var isSealedBody: Boolean = false,
): Vehicle, Truck