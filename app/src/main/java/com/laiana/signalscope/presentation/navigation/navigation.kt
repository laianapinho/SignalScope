package com.laiana.signalscope.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.laiana.signalscope.presentation.dashboard.DashboardScreen
import com.laiana.signalscope.presentation.history.HistoryScreen
import com.laiana.signalscope.presentation.maps.MapsScreen
import com.laiana.signalscope.presentation.settings.SettingsScreen
import com.laiana.signalscope.presentation.statistics.StatisticsScreen

// SignalScopeNavHost é o Composable responsável por configurar a navegação do app.
// Ele associa cada rota a uma tela específica.
@Composable
fun SignalScopeNavHost(
    // NavController controla a navegação entre as telas.
    navController: NavHostController = rememberNavController()
) {
    // NavHost é o container que mostra a tela correspondente à rota atual.
    NavHost(
        navController = navController,
        startDestination = Routes.DASHBOARD
    ) {
        // Tela principal do aplicativo.
        composable(Routes.DASHBOARD) {
            DashboardScreen()
        }

        // Tela de histórico de medições.
        composable(Routes.HISTORY) {
            HistoryScreen()
        }

        // Tela de mapa.
        composable(Routes.MAPS) {
            MapsScreen()
        }

        // Tela de estatísticas.
        composable(Routes.STATISTICS) {
            StatisticsScreen()
        }

        // Tela de configurações.
        composable(Routes.SETTINGS) {
            SettingsScreen()
        }
    }
}