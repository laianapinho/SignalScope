package com.laiana.signalscope.domain.model

data class SignalMeasurement (
    val id: Long,
    val timestamp: Long,
    val operatorName: String,
    val networkType: String,
    val signalDbm: Int?,
    val signalLevel: String,
    val latitude: Double?,
    val longitude: Double?
)