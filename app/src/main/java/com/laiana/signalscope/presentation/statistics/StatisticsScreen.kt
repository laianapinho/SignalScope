package com.laiana.signalscope.presentation.statistics

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// Essa é a nossa tela (Screen). Não é uma Activity, é só uma função
// Composable que representa "uma tela" dentro do fluxo do app.
// Você pode chamar ela de qualquer lugar, tipo dentro de um NavHost
// ou dentro de outro Composable.
@Composable
fun StatisticsScreen() {
    // Surface = fundo da tela, já respeitando o tema do app (cores, etc.)
    Surface(
        modifier = Modifier.fillMaxSize() // ocupa a tela inteira
    ) {
        // Box serve pra posicionar o conteúdo (nesse caso, centralizado)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // O título da tela
            Text(
                text = "Statistics",
                fontSize = 28.sp
            )
        }
    }
}

// Preview só pra ver essa tela isolada no Android Studio,
// sem precisar rodar o app inteiro
@Preview(showBackground = true)
@Composable
fun PreviewStatisticsScreen() {
    MaterialTheme {
        StatisticsScreen()
    }
}