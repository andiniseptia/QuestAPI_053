package com.example.pam_remotedb_andini.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pam_remotedb_andini.model.Mahasiswa
import com.example.pam_remotedb_andini.repository.MahasiswaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val insertUiEvent: InsertUiEvent) : DetailUiState()
    object Error : DetailUiState()
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: MahasiswaRepository
) : ViewModel() {
    private val _nim: String = checkNotNull(savedStateHandle["nim"])
    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState

    init {
        getMahasiswaDetail()
    }



    private fun getMahasiswaDetail() {
        viewModelScope.launch {
            try {
                val mahasiswa = repository.getMahasiswaById(_nim)
                _uiState.value = DetailUiState.Success(mahasiswa.toMahasiswaEvent())
            } catch (e: Exception) {
                _uiState.value = DetailUiState.Error
            }
        }
    }


}

fun Mahasiswa.toMahasiswaEvent(): InsertUiEvent {
    return InsertUiEvent(
        nim = nim,
        nama = nama,
        jenisKelamin = jenisKelamin,
        alamat = alamat,
        kelas = kelas,
        angkatan = angkatan
    )
}
