package park

import core.*
import interfaces.Truck
import orders.TypeOfCargo
import orders.Order
import vehicles.*
import java.lang.Thread.sleep

class CarPark {
    private val truckList = mutableListOf(
        TiltTruck(
            year = 2005,
            brand = "DAF",
            model = "Challenger",
            fuelType = DIESEL,
            fuelConsumption = 12.2f,
            purpose = setOf(TypeOfCargo.INDUSTRIAL, TypeOfCargo.PERISHABLES),
            bodyCapacity = 90f,
            loadCapacity = 30f,
            isSealedBody = false
        ),
        Refrigerator(
            year = 2006,
            brand = "Iveco",
            model = "Expeditor",
            fuelType = DIESEL,
            fuelConsumption = 11.2f,
            purpose = setOf(TypeOfCargo.PERISHABLES),
            bodyCapacity = 80f,
            loadCapacity = 15f,
            isSealedBody = false
        ),
        Tank(
            year = 2007,
            brand = "Renault",
            model = "Tanker",
            fuelType = DIESEL,
            fuelConsumption = 14.7f,
            purpose = setOf(TypeOfCargo.LIQUID),
            bodyCapacity = 50f,
            loadCapacity = 16f,
            isSealedBody = false
        )
    )

    private val busList = mutableListOf(
        Bus(
            year = 2008,
            brand = "WV",
            model = "Multivan",
            fuelType = DIESEL,
            fuelConsumption = 8f,
            purpose = setOf(TypeOfCargo.PASSENGERS),
            seatingCapacity = 10,
            isDisinfected = true
        ),
        Bus(
            year = 2009,
            brand = "Mercedes",
            model = "Sprinter",
            fuelType = DIESEL,
            fuelConsumption = 9f,
            purpose = setOf(TypeOfCargo.PASSENGERS),
            seatingCapacity = 15,
            isDisinfected = true
        )
    )

    private val combiVanList = mutableListOf(
        CombiVan(
            year = 2010,
            brand = "WV",
            model = "Crafter",
            fuelType = GASOLINE,
            fuelConsumption = 14f,
            purpose = setOf(TypeOfCargo.PASSENGERS, TypeOfCargo.INDUSTRIAL),
            seatingCapacity = 8,
            bodyCapacity = VAN_MAX_VOLUME,
            loadCapacity = VAN_MAX_TONS,
            isDisinfected = true
        )
    )

    fun searchVehicle(orderList: List<Order>) {
        orderList.forEach { order ->
            var isSearchingTruckSuccessful: Boolean
            when {
                (order.cargoType == setOf(TypeOfCargo.INDUSTRIAL, TypeOfCargo.PERISHABLES)) -> {
                    truckList.filter { it.purpose == setOf(TypeOfCargo.INDUSTRIAL, TypeOfCargo.PERISHABLES) }.forEach { truck ->
                        isSearchingTruckSuccessful = if (truck.isTruckFound(order)) {
                            delivery(truck, order)
                            true
                        } else false
                        if (!isSearchingTruckSuccessful) vehicleIsNotFound(order)
                    }
                }
                (order.cargoType == setOf(TypeOfCargo.INDUSTRIAL)) -> {
                    truckList.filter { it.purpose == setOf(TypeOfCargo.INDUSTRIAL) }.forEach { truck ->
                        isSearchingTruckSuccessful = if (truck.isTruckFound(order)) {
                            delivery(truck, order)
                            true
                        } else false
                        if (!isSearchingTruckSuccessful) vehicleIsNotFound(order)
                    }
                }
                (order.cargoType == setOf(TypeOfCargo.LIQUID)) -> {
                    truckList.filter { it.purpose == setOf(TypeOfCargo.LIQUID) }.forEach { truck ->
                        isSearchingTruckSuccessful = if (truck.isTruckFound(order)) {
                            delivery(truck, order)
                            true
                        } else false
                        if (!isSearchingTruckSuccessful) vehicleIsNotFound(order)
                    }
                }
                (order.cargoType == setOf(TypeOfCargo.PERISHABLES)) -> {
                    truckList.filter { it.purpose == setOf(TypeOfCargo.PERISHABLES) }.forEach { truck ->
                        isSearchingTruckSuccessful = if (truck.isTruckFound(order)) {
                            delivery(truck, order)
                            true
                        } else false
                        if (!isSearchingTruckSuccessful) vehicleIsNotFound(order)
                    }
                }
                (order.cargoType == setOf(TypeOfCargo.PASSENGERS, TypeOfCargo.INDUSTRIAL)) -> {
                    var isSearchingCombiVanSuccessful: Boolean
                    combiVanList.filter { it.purpose == setOf(TypeOfCargo.PASSENGERS, TypeOfCargo.INDUSTRIAL) }.forEach { combiVan ->
                        isSearchingCombiVanSuccessful = if (combiVan.isBusFounded(order)) {
                            tripAndDelivery(combiVan, order)
                            true
                        } else false
                        if (!isSearchingCombiVanSuccessful) vehicleIsNotFound(order)
                    }
                }
                else -> {
                    var isSearchingBusSuccessful = false
                    busList.forEach { bus ->
                        isSearchingBusSuccessful = if (bus.isBusFounded(order)) {
                            trip(bus, order)
                            true
                        } else false
                    }
                    if (!isSearchingBusSuccessful) vehicleIsNotFound(order)
                }
            }
        }
    }

    private fun delivery(truck: Truck, order: Order) {
        println("${truck.brand} ${truck.model} is preparing...")
        println("Order with id ${order.id} from ${order.startPoint} to ${order.endPoint} is preparing for delivering....")
        truck.repair(true)
        sleep(2000)
        truck.refuel(true)
        sleep(2000)
        truck.checkFreeVolume()
        sleep(2000)
        truck.loadOrder(order)
        sleep(2000)
        truck.checkFreeVolume()
        sleep(2000)
        truck.sealBody(true)
        println("${truck.brand} ${truck.model} on the way...")
        sleep(5000)
        truck.sealBody(false)
        sleep(2000)
        truck.unloadOrder(order)
        sleep(2000)
        truck.checkFreeVolume()
        sleep(2000)
        truck.repair(false)
        sleep(2000)
        truck.refuel(false)
        sleep(2000)
        println()
    }

    private fun trip(bus: Bus, order: Order) {
        println("${bus.brand} ${bus.model} is preparing...")
        println("Order with id ${order.id} from ${order.startPoint} to ${order.endPoint} is preparing for delivering....")
        bus.repair(true)
        sleep(2000)
        bus.refuel(true)
        sleep(2000)
        bus.disinfected(true)
        println("Order with id ${order.id} from ${order.startPoint} to ${order.endPoint} is preparing for delivering....")
        sleep(2000)
        bus.checkFreeSeats()
        sleep(2000)
        bus.boardingPassengers(order)
        sleep(2000)
        bus.checkFreeSeats()
        sleep(2000)
        println("${bus.brand} ${bus.model} on the way...")
        sleep(5000)
        bus.disembarkingPassengers(order)
        sleep(2000)
        bus.checkFreeSeats()
        sleep(2000)
        bus.repair(false)
        sleep(2000)
        bus.refuel(false)
        sleep(2000)
        println()
    }

    private fun tripAndDelivery(van: CombiVan, order: Order) {
        println("${van.brand} ${van.model} is preparing...")
        println("Order with id ${order.id} from ${order.startPoint} to ${order.endPoint} is preparing for delivering....")
        van.repair(true)
        sleep(2000)
        van.refuel(true)
        sleep(2000)
        van.disinfected(true)
        sleep(2000)
        van.checkFreeSeats()
        sleep(2000)
        van.loadOrder(order)
        sleep(2000)
        van.sealBody(true)
        sleep(2000)
        van.checkFreeSeats()
        sleep(2000)
        van.checkFreeVolume()
        sleep(2000)
        println("${van.brand} ${van.model} on the way...")
        sleep(5000)
        van.sealBody(false)
        sleep(2000)
        van.unloadOrder(order)
        sleep(2000)
        van.checkFreeSeats()
        sleep(2000)
        van.checkFreeVolume()
        sleep(2000)
        van.repair(false)
        sleep(2000)
        van.refuel(false)
        sleep(2000)
        println()
    }

    private fun vehicleIsNotFound(order: Order) {
        println("Sorry. We haven't found vehicle for your order.\n" +
                "Order id is ${order.id}," +
                " number of passengers is ${order.passengerQuantity}," +
                " weight is ${order.cargoWeight} tons," +
                " volume is ${order.cargoVolume} cubic meter.\n"
        )
    }
}