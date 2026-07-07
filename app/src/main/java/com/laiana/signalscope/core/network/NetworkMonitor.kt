package com.laiana.signalscope.core.network

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.telephony.TelephonyManager
import androidx.core.content.ContextCompat

/**
 * Classe responsável por extrair informações do hardware de telefonia.
 * Ela encapsula a lógica de acesso ao TelephonyManager e trata erros de permissão.
 */
class NetworkMonitor(
    private val context: Context
) {

    // Inicializa o serviço do sistema responsável por informações de telefonia
    private val telephonyManager =
        context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

    /**
     * Retorna o nome da operadora.
     * Observação: Em algumas versões do Android, o acesso a essa propriedade
     * pode lançar SecurityException se não houver permissão.
     */
    fun getOperatorName(): String {
        return try {
            val operatorName = telephonyManager.networkOperatorName

            // Trata casos onde o nome pode vir vazio ou nulo
            if (operatorName.isNullOrBlank()) {
                "Operadora desconhecida"
            } else {
                operatorName
            }
        } catch (exception: SecurityException) {
            "Permissão necessária"
        }
    }

    /**
     * Mapeia as constantes internas do Android (ex: NETWORK_TYPE_LTE)
     * para categorias simplificadas (2G, 3G, 4G, 5G).
     */
    fun getNetworkType(): String {
        // Verifica manualmente se a permissão foi concedida antes de tentar acessar
        val hasPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_PHONE_STATE
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasPermission) {
            return "Permissão necessária"
        }

        return try {
            // Analisa o tipo de rede de dados atual
            when (telephonyManager.dataNetworkType) {
                // Categorias 2G
                TelephonyManager.NETWORK_TYPE_GPRS,
                TelephonyManager.NETWORK_TYPE_EDGE,
                TelephonyManager.NETWORK_TYPE_CDMA,
                TelephonyManager.NETWORK_TYPE_1xRTT,
                TelephonyManager.NETWORK_TYPE_IDEN -> "2G"

                // Categorias 3G
                TelephonyManager.NETWORK_TYPE_UMTS,
                TelephonyManager.NETWORK_TYPE_EVDO_0,
                TelephonyManager.NETWORK_TYPE_EVDO_A,
                TelephonyManager.NETWORK_TYPE_HSDPA,
                TelephonyManager.NETWORK_TYPE_HSUPA,
                TelephonyManager.NETWORK_TYPE_HSPA,
                TelephonyManager.NETWORK_TYPE_EVDO_B,
                TelephonyManager.NETWORK_TYPE_EHRPD,
                TelephonyManager.NETWORK_TYPE_HSPAP -> "3G"

                // Categoria 4G
                TelephonyManager.NETWORK_TYPE_LTE -> "4G"

                // Categoria 5G
                TelephonyManager.NETWORK_TYPE_NR -> "5G"

                else -> "Tipo de rede desconhecido"
            }
        } catch (exception: SecurityException) {
            // Fallback de segurança caso a verificação de permissão falhe
            "Permissão necessária"
        }
    }
}