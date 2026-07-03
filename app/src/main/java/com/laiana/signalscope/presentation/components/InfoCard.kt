package com.laiana.signalscope.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// InfoCard é um componente reutilizável: um "cartão" genérico
// que recebe título e descrição como parâmetros.
// Assim você pode usar esse mesmo Composable em várias telas do app,
// só mudando o texto que passa pra ele.
@Composable
fun InfoCard(
    title: String,        // Texto que aparece como título do card
    description: String,  // Texto que aparece como descrição/conteúdo do card

    // modifier com valor padrão (Modifier vazio).
    // Isso permite que quem chamar o InfoCard personalize o layout de fora
    // (ex: adicionar padding extra, clique, etc.) sem precisar mexer aqui dentro.
    modifier: Modifier = Modifier
) {
    // Card é o container visual: fundo, cantos arredondados e sombra
    Card(
        // Usamos o "modifier" recebido por parâmetro (não um novo Modifier),
        // e adicionamos fillMaxWidth() pra ocupar toda a largura disponível
        modifier = modifier.fillMaxWidth(),

        // Define a elevação (sombra) do card, dando efeito de profundidade
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        // Column organiza o conteúdo interno do card verticalmente
        // (título em cima, descrição embaixo)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp) // espaçamento interno entre o conteúdo e as bordas do card
        ) {
            // Título do card
            Text(
                text = title,
                // Usa o estilo de tipografia do tema (Material3) em vez de
                // definir fontSize manualmente — mantém consistência visual no app
                style = MaterialTheme.typography.titleMedium
            )

            // Espaço vazio entre o título e a descrição
            Spacer(modifier = Modifier.height(8.dp))

            // Descrição/conteúdo do card
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

// Preview permite visualizar o InfoCard isoladamente no Android Studio,
// já com valores de exemplo, sem precisar rodar o app inteiro
@Preview(showBackground = true)
@Composable
fun PreviewInfoCard() {
    MaterialTheme {
        InfoCard(
            title = "Status da rede",
            description = "Aguardando primeira medição"
        )
    }
}