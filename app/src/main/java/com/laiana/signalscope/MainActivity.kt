package com.laiana.signalscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.laiana.signalscope.presentation.navigation.SignalScopeNavHost
import com.laiana.signalscope.ui.theme.SignalScopeTheme
import dagger.hilt.android.AndroidEntryPoint

// @AndroidEntryPoint marca essa Activity como um "ponto de entrada" do Hilt.
// Isso permite que você use injeção de dependência (@Inject) dentro dela
// e nos Composables/ViewModels que ela chama (via hiltViewModel(), por exemplo).
// Sem essa anotação, o Hilt não consegue injetar nada nessa classe.
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // onCreate é chamado quando a Activity é criada pela primeira vez.
    // É aqui que configuramos o conteúdo inicial da tela.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // enableEdgeToEdge() faz o conteúdo do app ocupar a tela toda,
        // "por baixo" da barra de status e da barra de navegação do sistema,
        // em vez de deixar essas áreas com um espaço reservado/cor sólida.
        // Deixa o app com visual mais moderno (edge-to-edge = "de ponta a ponta").
        enableEdgeToEdge()

        // setContent define o conteúdo da tela usando Jetpack Compose.
        setContent {
            // SignalScopeTheme é o tema customizado do seu app
            // (cores, tipografia, formas específicas do SignalScope),
            // em vez do MaterialTheme genérico/padrão.
            SignalScopeTheme {
                // SignalScopeNavHost é o Composable que contém o NavHost
                // com todas as rotas/telas do app (Dashboard, History, Maps, etc).
                // É ele quem decide qual tela mostrar primeiro e gerencia a navegação.
                SignalScopeNavHost()
            }
        }
    }
}