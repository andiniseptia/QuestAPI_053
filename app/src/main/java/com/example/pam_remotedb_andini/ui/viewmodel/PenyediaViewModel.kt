package com.example.pam_remotedb_andini.ui.viewmodel

import android.text.Editable.Factory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pam_remotedb_andini.MahasiswaApplications
import com.example.pam_remotedb_andini.repository.MahasiswaContainer

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                mahasiswaApplications().container.mahasiswaRepository
            )
        }
        initializer {
            InsertViewModel(
                mahasiswaApplications().container.mahasiswaRepository
            )
        }
        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                mahasiswaApplications().container.mahasiswaRepository,
            )
        }
        initializer {
            UpdateViewModel(
                savedStateHandle = createSavedStateHandle(),
                repository = mahasiswaApplications().container.mahasiswaRepository,
            )
        }
    }
}

fun CreationExtras.mahasiswaApplications(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)