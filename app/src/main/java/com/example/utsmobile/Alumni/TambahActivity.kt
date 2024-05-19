package com.example.utsmobile.Alumni

import DatabaseHelper
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.utsmobile.R
import java.util.Calendar

class TambahActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        val dbHelper = DatabaseHelper(this)

        val nimEditText = findViewById<EditText>(R.id.nimTXT)
        val namaEditText = findViewById<EditText>(R.id.namaTXT)
        val tempatLahirEditText = findViewById<EditText>(R.id.tempatTXT)
        val tanggalLahirEditText = findViewById<EditText>(R.id.tanggalTXT)
        val alamatEditText = findViewById<EditText>(R.id.alamatTXT)
        val agamaEditText = findViewById<EditText>(R.id.agamaTXT)
        val tlpHpEditText = findViewById<EditText>(R.id.teleponTXT)
        val tahunMasukEditText = findViewById<EditText>(R.id.thnMasukTXT)
        val pekerjaanEditText = findViewById<EditText>(R.id.pekerjaanTXT)
        val jabatanEditText = findViewById<EditText>(R.id.jabatanTXT)

        // Set up DatePickerDialog for tanggal_lahir
        tanggalLahirEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    tanggalLahirEditText.setText(selectedDate)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        val btnSimpan = findViewById<Button>(R.id.simpan)
        btnSimpan.setOnClickListener {
            val nim = nimEditText.text.toString()
            val nama = namaEditText.text.toString()
            val tempatLahir = tempatLahirEditText.text.toString()
            val tanggalLahir = tanggalLahirEditText.text.toString()
            val alamat = alamatEditText.text.toString()
            val agama = agamaEditText.text.toString()
            val tlpHp = tlpHpEditText.text.toString()
            val tahunMasuk = tahunMasukEditText.text.toString()
            val pekerjaan = pekerjaanEditText.text.toString()
            val jabatan = jabatanEditText.text.toString()

            val result = dbHelper.addAlumni(nim, nama, tempatLahir, tanggalLahir, alamat, agama, tlpHp, tahunMasuk, pekerjaan, jabatan)
            if (result > 0) {
                Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Error saving data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}