package com.example.pam_remotedb_andini.navigation

interface DestinasiNavigasi {
    val route: String
    val titleRes: String
}

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail"
    override val titleRes = "Detail Mahasiswa"
}
