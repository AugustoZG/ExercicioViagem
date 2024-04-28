package com.senac.boaviagemexercicio.components

import android.app.DatePickerDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.util.*
@Composable
fun DatePickerComponent(label: String, date: Date, onDateSelected: (Date) -> Unit) {
    val context = LocalContext.current
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    Button(onClick = {
        val calendar = Calendar.getInstance()
        calendar.time = date
        val datePicker = DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                calendar.set(year, month, dayOfMonth)
                onDateSelected(calendar.time)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePicker.show()
    }) {
        Text(text = "$label: ${dateFormat.format(date)}")
    }
}