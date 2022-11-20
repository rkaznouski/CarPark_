package vehicles

import core.*
import interfaces.CargoPassenger
import orders.TypeOfCargo

class CombiVan(
    // Common properties
    override val year: Int,
    override val brand: String,
    override val model: String,
    override val fuelType: String,
    override val fuelConsumption: Float,
    override var isRepaired: Boolean = true,
    override var isFueledUp: Boolean = true,
    // Specific properties
    override var seatingCapacity: Int = VAN_MAX_SEATING_CAPACITY,
    override var bodyCapacity: Float = VAN_MAX_VOLUME,
    override var loadCapacity: Float = VAN_MAX_TONS,
    override val purpose: Set<TypeOfCargo> = setOf(TypeOfCargo.PASSENGERS, TypeOfCargo.INDUSTRIAL),
    override var isDisinfected: Boolean = true,
    override var isSealedBody: Boolean = false,
): CargoPassenger