package orders

class Order(
    val id: Int,
    val startPoint: String,
    val endPoint: String,
    val cargoVolume: Float = 0f,
    val cargoWeight: Float = 0f,
    val cargoType: Set<TypeOfCargo>,
    val passengerQuantity: Int = 0,
    var isOrderCompleted: Boolean = false
)