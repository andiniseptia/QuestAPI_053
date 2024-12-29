package com.example.pam_remotedb_andini.repository

import com.example.pam_remotedb_andini.model.Mahasiswa
import com.example.pam_remotedb_andini.service_api.MahasiswaService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val mahasiswaRepository: MahasiswaRepository
}
