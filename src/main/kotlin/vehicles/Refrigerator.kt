package vehicles

import core.*
import interfaces.Truck
import orders.TypeOfCargo
import orders.TypeOfCargo.*

class Refrigerator(
    // Common properties
    override val year: Int,
    override val brand: String,
    override val model: String,
    override val fuelType: String,
    override val fuelConsumption: Float,
    override var isRepaired: Boolean = true,
    override var isFueledUp: Boolean = true,
    // Specific properties
    override var bodyCapacity: Float = REFRIGERATOR_MAX_VOLUME,
    override var loadCapacity: Float = REFRIGERATOR_MAX_TONS,
    override val purpose: Set<TypeOfCargo> = setOf(PERISHABLES),
    override var isSealedBody: Boolean = false,
): Truck