package com.example.utsmobile.Alumni

import DatabaseHelper
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.utsmobile.R

class DetailAlumni : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_alumni)

        val dbHelper = DatabaseHelper(this)

        val nimEditText = findViewById<EditText>(R.id.editNim)
        val namaEditText = findViewById<EditText>(R.id.editNama)
        val tempatLahirEditText = findViewById<EditText>(R.id.editTempat)
        val tanggalLahirEditText = findViewById<EditText>(R.id.editTanggal)
        val alamatEditText = findViewById<EditText>(R.id.editAlamat)
        val agamaEditText = findViewById<EditText>(R.id.editAgama)
        val tlpHpEditText = findViewById<EditText>(R.id.editTelepon)
        val tahunMasukEditText = findViewById<EditText>(R.id.editMasuk)
        val pekerjaanEditText = findViewById<EditText>(R.id.editPekerjaan)
        val jabatanEditText = findViewById<EditText>(R.id.editJabatan)
        val btnUbah = findViewById<Button>(R.id.ubah)
        val btnHapus = findViewById<Button>(R.id.hapus)

        val id = intent.getStringExtra("id")
        val alumni = dbHelper.getAlumni(id!!)

        nimEditText.setText(alumni[DatabaseHelper.COLUMN_NIM])
        namaEditText.setText(alumni[DatabaseHelper.COLUMN_NAMA])
        tempatLahirEditText.setText(alumni[DatabaseHelper.COLUMN_TEMPAT_LAHIR])
        tanggalLahirEditText.setText(alumni[DatabaseHelper.COLUMN_TANGGAL_LAHIR])
        alamatEditText.setText(alumni[DatabaseHelper.COLUMN_ALAMAT])
        agamaEditText.setText(alumni[DatabaseHelper.COLUMN_AGAMA])
        tlpHpEditText.setText(alumni[DatabaseHelper.COLUMN_TLP_HP])
        tahunMasukEditText.setText(alumni[DatabaseHelper.COLUMN_TAHUN_MASUK])
        pekerjaanEditText.setText(alumni[DatabaseHelper.COLUMN_PEKERJAAN])
        jabatanEditText.setText(alumni[DatabaseHelper.COLUMN_JABATAN])

        btnUbah.setOnClickListener {
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

            val result = dbHelper.updateAlumni(id, nim, nama, tempatLahir, tanggalLahir, alamat, agama, tlpHp, tahunMasuk, pekerjaan, jabatan)
            if (result > 0) {
                Toast.makeText(this, "Data updated", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Error updating data", Toast.LENGTH_SHORT).show()
            }
        }

        btnHapus.setOnClickListener {
            val result = dbHelper.deleteAlumni(id)
            if (result > 0) {
                Toast.makeText(this, "Data deleted", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Error deleting data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}