package com.laiana.signalscope.domain.repository
import com.laiana.signalscope.domain.model.SignalMeasurement

//interface define um contrato: Qualquer classe que quiser ser um SignalRepository precisa ter essa função
//no caso a função getCurrentMeasurement
interface SignalRepository {
    fun getCurrentMeasurement(): SignalMeasurement
}