import orders.TypeOfCargo
import orders.Order
import park.CarPark

fun main() {
    val carPark = CarPark()
    val orderList = mutableListOf<Order>()

    orderList.add(
        Order(
            id = (0.. 100).random(),
            startPoint = "Minsk",
            endPoint = "Brest",
            cargoVolume = 50.4f,
            cargoWeight = 15f,
            cargoType = setOf(TypeOfCargo.INDUSTRIAL, TypeOfCargo.PERISHABLES)
        )
    )
    orderList.add(
        Order(
            id = (0.. 100).random(),
            startPoint = "Minsk",
            endPoint = "Brest",
            cargoVolume = 110f,
            cargoWeight = 15f,
            cargoType = setOf(TypeOfCargo.INDUSTRIAL)
        )
    )
    orderList.add(
        Order(
            id = (0.. 100).random(),
            startPoint = "Minsk",
            endPoint = "Grodno",
            cargoVolume = 35.6F,
            cargoWeight = 12f,
            cargoType = setOf(TypeOfCargo.LIQUID)
        )
    )
    orderList.add(
        Order(
            id = (0..100).random(),
            startPoint = "Minsk",
            endPoint = "Vitebsk",
            cargoVolume = 25.7f,
            cargoWeight = 11.4f,
            cargoType = setOf(TypeOfCargo.PERISHABLES)
        )
    )
    orderList.add(
        Order(
            id = (0.. 100).random(),
            startPoint = "Minsk",
            endPoint = "Gomel",
            cargoType = setOf(TypeOfCargo.PASSENGERS),
            passengerQuantity = 75
        )
    )
    orderList.add(
        Order(
            id = (0.. 100).random(),
            startPoint = "Minsk",
            endPoint = "Mogilev",
            cargoType = setOf(TypeOfCargo.PASSENGERS),
            passengerQuantity = 14
        )
    )
    orderList.add(
        Order(
            id = (0 .. 100).random(),
            startPoint = "Minsk",
            endPoint = "Warsaw",
            cargoType = setOf(TypeOfCargo.PASSENGERS, TypeOfCargo.INDUSTRIAL),
            passengerQuantity = 8,
            cargoWeight = 0.9f,
            cargoVolume = 3.9f
        )
    )
    carPark.searchVehicle(orderList)
}

