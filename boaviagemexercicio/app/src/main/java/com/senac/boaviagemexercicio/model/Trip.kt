package com.senac.boaviagemexercicio.model

import java.util.Date
data class Trip(
    var destination: String,
    var type: TripType,
    var startDate: Date,
    var endDate: Date,
    var value: Double
)
enum class TripType {
    LAZER, NEGOCIOS
}