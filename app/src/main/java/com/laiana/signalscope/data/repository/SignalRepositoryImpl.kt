package com.laiana.signalscope.data.repository

import com.laiana.signalscope.core.network.NetworkMonitor
import com.laiana.signalscope.domain.model.SignalMeasurement
import com.laiana.signalscope.domain.repository.SignalRepository

class SignalRepositoryImpl(
    //A classe recebe um Network monitor para conseguir buscar os dados da rede
    private val networkMonitor: NetworkMonitor
    //Significa que essa classe segue o contrato da interface SignalRepository.
) : SignalRepository {
    //Significa que estamos implementando a função obrigatória da interface.
    override fun getCurrentMeasurement(): SignalMeasurement {
        //Passasse os valores diretamente no construtor da data class SignalMeasurement
        return SignalMeasurement(
            id = 0L,
            timestamp = System.currentTimeMillis(),
            operatorName = networkMonitor.getOperatorName(),
            networkType = networkMonitor.getNetworkType(),
            signalDbm = null,
            signalLevel = "Desconhecido",
            latitude = null,
            longitude = null
        )
    }
}