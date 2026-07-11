package com.laiana.signalscope.presentation.dashboard

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.laiana.signalscope.core.network.NetworkMonitor
import com.laiana.signalscope.presentation.components.InfoCard

@Composable
fun DashboardScreen() {
    val context = LocalContext.current

    val networkMonitor = remember {
        NetworkMonitor(context)
    }

    var hasPhonePermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_PHONE_STATE
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasPhonePermission = isGranted

        val message = if (isGranted) {
            "Permissão concedida!"
        } else {
            "Permissão negada."
        }

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    val operatorName = networkMonitor.getOperatorName()

    val networkType = if (hasPhonePermission) {
        networkMonitor.getNetworkType()
    } else {
        "Permissão necessária"
    }

    val permissionStatus = if (hasPhonePermission) {
        "Concedida"
    } else {
        "Necessária"
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DashboardHeader(
                title = "SignalScope",
                subtitle = "Qualidade da rede móvel"
            )

            Spacer(modifier = Modifier.height(24.dp))

            NetworkInfoSection(
                operatorName = operatorName,
                networkType = networkType,
                permissionStatus = permissionStatus
            )

            PermissionRequestButton(
                hasPhonePermission = hasPhonePermission,
                onClick = {
                    permissionLauncher.launch(Manifest.permission.READ_PHONE_STATE)
                }
            )
        }
    }
}

@Composable
fun DashboardHeader(
    title: String,
    subtitle: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium
    )

    Text(
        text = subtitle,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun NetworkInfoSection(
    operatorName: String,
    networkType: String,
    permissionStatus: String
) {
    InfoCard(
        title = "Status da rede",
        description = "Monitoramento iniciado"
    )

    Spacer(modifier = Modifier.height(16.dp))

    InfoCard(
        title = "Operadora",
        description = operatorName
    )

    Spacer(modifier = Modifier.height(16.dp))

    InfoCard(
        title = "Tipo de rede",
        description = networkType
    )

    Spacer(modifier = Modifier.height(16.dp))

    InfoCard(
        title = "Permissão",
        description = permissionStatus
    )

    Spacer(modifier = Modifier.height(16.dp))

    InfoCard(
        title = "Última atualização",
        description = "Atualizado ao abrir o app"
    )
}

@Composable
fun PermissionRequestButton(
    hasPhonePermission: Boolean,
    onClick: () -> Unit
) {
    if (!hasPhonePermission) {
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onClick
        ) {
            Text("Permitir leitura da rede")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDashboardScreen() {
    MaterialTheme {
        DashboardScreen()
    }
}