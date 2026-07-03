package com.laiana.signalscope.presentation.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laiana.signalscope.presentation.components.InfoCard

@Composable
fun DashboardScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        // Column organiza os itens em uma coluna (de cima pra baixo).
        // É diferente do Box, que só empilha itens uns por cima dos outros.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // espaçamento nas bordas da tela

            // horizontalAlignment centraliza os itens no eixo horizontal
            horizontalAlignment = Alignment.CenterHorizontally,

            // verticalArrangement organiza o espaçamento no eixo vertical
            // Center = centraliza tudo verticalmente na tela
            verticalArrangement = Arrangement.Center
        ) {
            InfoCard(
                title = "Status da rede",
                description = "Aguardando primeira medição"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoCard(
                title = "Operadora",
                description = "Não identificada"
            )
        }
    }
}
// Preview só pra ver essa tela isolada no Android Studio,
@Preview(showBackground = true)
@Composable
fun PreviewDashboardScreen() {
    MaterialTheme {
        DashboardScreen()
    }
}