package com.example.pam_remotedb_andini.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pam_remotedb_andini.customwidget.CostumeTopAppBar
import com.example.pam_remotedb_andini.navigation.DestinasiNavigasi
import com.example.pam_remotedb_andini.ui.viewmodel.InsertUiEvent
import com.example.pam_remotedb_andini.ui.viewmodel.InsertUiState
import com.example.pam_remotedb_andini.ui.viewmodel.InsertViewModel
import com.example.pam_remotedb_andini.ui.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch

object DestinasiEntry : DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = "Entry Mhs"
}

