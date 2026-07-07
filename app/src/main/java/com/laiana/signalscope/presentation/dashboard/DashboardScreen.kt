package com.laiana.signalscope.presentation.dashboard

// Importações necessárias para permissões, UI e estados do Compose
import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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

    // Instancia o monitor de rede.
    val networkMonitor = remember {
        NetworkMonitor(context)
    }

    // Estado local para rastrear se a permissão foi concedida.
    // Usamos 'mutableStateOf' para que a tela seja redesenhada (recomposta)
    // automaticamente quando o valor mudar.
    var hasPhonePermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_PHONE_STATE
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    // 'rememberLauncherForActivityResult' registra um contrato para solicitar permissão.
    // O callback dentro dele lida com a resposta do usuário (se aceitou ou negou).
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasPhonePermission = isGranted // Atualiza o estado da tela

        // Feedback simples para o usuário
        val message = if (isGranted) "Permissão concedida!" else "Permissão negada."
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    // Busca o nome da operadora (geralmente não exige permissão de runtime)
    val operatorName = networkMonitor.getOperatorName()

    // Lógica condicional: só tenta ler o tipo de rede se tiver a permissão.
    // Caso contrário, exibe um aviso na tela.
    val networkType = if (hasPhonePermission) {
        networkMonitor.getNetworkType()
    } else {
        "Permissão necessária"
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            InfoCard(title = "Status da rede", description = "Monitoramento iniciado")
            Spacer(modifier = Modifier.height(16.dp))

            InfoCard(title = "Operadora", description = operatorName)
            Spacer(modifier = Modifier.height(16.dp))

            InfoCard(title = "Tipo de rede", description = networkType)

            // Exibe o botão apenas se o usuário ainda não tiver concedido a permissão.
            if (!hasPhonePermission) {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        // Dispara a solicitação do sistema para o usuário
                        permissionLauncher.launch(Manifest.permission.READ_PHONE_STATE)
                    }
                ) {
                    Text("Permitir leitura da rede")
                }
            }
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