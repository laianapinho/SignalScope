package com.laiana.signalscope.core.network

import android.content.Context
import android.telephony.TelephonyManager
import android.annotation.SuppressLint
class NetworkMonitor(
    private val context: Context
)

{
    private val telephonyManager =
        context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    fun getOperatorName(): String {
        val operatorName = telephonyManager.networkOperatorName

        return if (operatorName.isNullOrBlank()) {
            "Operadora desconhecida"
        } else {
            operatorName
        }
    }
    @SuppressLint("MissingPermission")
    fun getNetworkType(): String {
        return when (telephonyManager.dataNetworkType) {
            TelephonyManager.NETWORK_TYPE_GPRS,
            TelephonyManager.NETWORK_TYPE_EDGE,
            TelephonyManager.NETWORK_TYPE_CDMA,
            TelephonyManager.NETWORK_TYPE_1xRTT,
            TelephonyManager.NETWORK_TYPE_IDEN -> "2G"

            TelephonyManager.NETWORK_TYPE_UMTS,
            TelephonyManager.NETWORK_TYPE_EVDO_0,
            TelephonyManager.NETWORK_TYPE_EVDO_A,
            TelephonyManager.NETWORK_TYPE_HSDPA,
            TelephonyManager.NETWORK_TYPE_HSUPA,
            TelephonyManager.NETWORK_TYPE_HSPA,
            TelephonyManager.NETWORK_TYPE_EVDO_B,
            TelephonyManager.NETWORK_TYPE_EHRPD,
            TelephonyManager.NETWORK_TYPE_HSPAP -> "3G"

            TelephonyManager.NETWORK_TYPE_LTE -> "4G"

            TelephonyManager.NETWORK_TYPE_NR -> "5G"

            else -> "Tipo de rede desconhecido"
        }
    }
}