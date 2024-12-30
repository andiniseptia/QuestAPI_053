package com.example.pam_remotedb_andini.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam_remotedb_andini.ui.view.DestinasiEntry
import com.example.pam_remotedb_andini.ui.view.DestinasiHome
import com.example.pam_remotedb_andini.ui.view.DetailView
import com.example.pam_remotedb_andini.ui.view.EntryBody
import com.example.pam_remotedb_andini.ui.view.EntryMhsScreen
import com.example.pam_remotedb_andini.ui.view.HomeScreen
import com.example.pam_roomlocaldb_andini.ui.view.mahasiswa.UpdateView

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = { nim ->
                    navController.navigate("${DestinasiDetail.route}/$nim")
                    println(
                        "PengelolaHalaman: nim = $nim"
                    )
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntryMhsScreen(navigateBack = {
                navController.navigate(DestinasiHome.route) {
                    popUpTo(DestinasiHome.route) {
                        inclusive = true
                    }
                }
            })
        }

        composable(
            "${DestinasiDetail.route}/{nim}"
        ) {
            navBackStackEntry ->
            val nim = navBackStackEntry.arguments?.getString("nim")
            nim?.let {
                DetailView(nim = it, onBack = { navController.popBackStack() }, onEditClick = { nim ->
                    navController.navigate("${DestinasiUpdate.route}/$nim")
                })
            }
        }


    }
}