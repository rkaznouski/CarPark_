package interfaces

interface Vehicle {
    val year: Int
    val brand: String
    val model: String
    val fuelType: String
    val fuelConsumption: Float
    var isRepaired: Boolean
    var isFueledUp: Boolean

    fun repair(isRepaired: Boolean) {
        this.isRepaired = isRepaired
        if (isRepaired) println("Vehicle is repaired.")
        else println("Vehicle is faulty.")
    }

    fun refuel(isFueledUp: Boolean) {
        this.isFueledUp = isFueledUp
        if (isFueledUp) println("Vehicle is fueled up.")
        else println("Vehicle is un fueled up.")
    }
}