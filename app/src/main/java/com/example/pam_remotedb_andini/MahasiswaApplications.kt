package com.example.pam_remotedb_andini

import android.app.Application
import com.example.pam_remotedb_andini.repository.AppContainer
import com.example.pam_remotedb_andini.repository.MahasiswaContainer

class MahasiswaApplications: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container=MahasiswaContainer()
    }
}