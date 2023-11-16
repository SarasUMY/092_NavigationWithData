package com.example.activity5

import androidx.lifecycle.ViewModel
import com.example.activity5.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import androidx.lifecycle.viewmodel.compose.viewModel

private const val HARGA_PER_CUP = 5000
class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setJumlah(jmlEsTea:Int){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                jumlah = jmlEsTea,
                harga = hitungHarga(jumlah = jmlEsTea)) }
    }

    fun setRasa(rasaPilihan: String) {
        _stateUI.update { stateStateIni ->
            stateStateIni.copy(rasa = rasaPilihan)
        }
    }

    fun setContact(list: MutableList<String>) {
        _stateUI.update {
                stateSaatIni -> stateSaatIni.copy(
            nama = list[0],
            alamat = list[1],
            tlp = list[2]
        )
        }
    }

    fun resetOrder() {
        _stateUI.value = OrderUIState()
    }

    private fun hitungHarga(
        jumlah: Int = _stateUI.value.jumlah,
    ): String {
        val kalkulasiHarga = jumlah * HARGA_PER_CUP

        return NumberFormat.getNumberInstance().format(kalkulasiHarga)
    }

}