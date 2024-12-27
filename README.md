# Management Kas Kelas

## Deskripsi

Aplikasi *Management Kas Kelas* adalah aplikasi berbasis desktop sederhana yang memungkinkan pengguna untuk mengelola data kas kelas, seperti menambahkan, mengedit, dan menghapus data dengan tampilan tabel. Data yang dikelola mencakup nama penyetor, jumlah dalam format Rupiah, dan tanggal transaksi.

## Fitur Utama

1. *Tambah Data:*
   - Inputkan nama dan jumlah kas.
   - Data otomatis ditambahkan ke tabel dengan tanggal saat ini.
   - Jumlah diformat dalam mata uang Rupiah.

2. *Edit Data:*
   - Pilih baris dalam tabel untuk mengedit.
   - Edit nama atau jumlah.
   - Tanggal transaksi tidak akan berubah.

3. *Hapus Data:*
   - Pilih baris dalam tabel untuk menghapus.

4. *Pilih Baris:*
   - Memungkinkan memilih baris dalam tabel untuk melihat atau mengedit data.

## Teknologi yang Digunakan

- *Java Swing* untuk antarmuka pengguna.
- *DefaultTableModel* untuk mengelola data dalam tabel.
- *NumberFormat* untuk format mata uang Rupiah.

## Cara Menggunakan

1. *Menjalankan Aplikasi:*
   - Jalankan kelas ManagementKas melalui IDE Anda atau kompilasi menggunakan javac, lalu jalankan dengan java.

2. *Menambahkan Data:*
   - Masukkan nama dan jumlah kas.
   - Klik tombol *Tambah*.

3. *Mengedit Data:*
   - Pilih baris dalam tabel.
   - Edit data pada field *Nama* dan/atau *Jumlah*.
   - Klik tombol *Edit*.

4. *Menghapus Data:*
   - Pilih baris dalam tabel.
   - Klik tombol *Hapus*.

## Format Jumlah

Jumlah kas akan otomatis diformat dalam mata uang Rupiah sesuai dengan locale Indonesia. Contoh:
- Input: 10000
- Tampil di tabel: Rp10.000,00

## Struktur Program

### Kelas dan Fungsi

- *ManagementKas*: Kelas utama yang mengatur seluruh logika aplikasi.
  - clearInputFields(): Membersihkan field input dan reset seleksi tabel.
  - *Listener* untuk tombol dan tabel:
    - Tambah data.
    - Edit data.
    - Hapus data.

### Komponen Antarmuka

1. *Panel Input:*
   - Field input untuk nama dan jumlah.
   - Tombol untuk menambah, mengedit, dan menghapus data.

2. *Tabel Data:*
   - Menampilkan data yang terdiri dari kolom:
     - Nama penyetor.
     - Jumlah kas (format Rupiah).
     - Tanggal transaksi.

## Prasyarat

- Java Development Kit (JDK) versi 8 atau lebih baru.

## Cara Kompilasi dan Menjalankan

1. Kompilasi:
   bash
   javac ManagementKas.java
   
2. Jalankan:
   bash
   java ManagementKas
   

## Pengembangan Lebih Lanjut

1. *Validasi Input:*
   - Pastikan jumlah hanya menerima angka positif.

2. *Penyimpanan Data:*
   - Simpan data ke file lokal (CSV atau database).

3. *Tampilan Lebih Menarik:*
   - Gunakan library seperti JavaFX untuk antarmuka yang lebih modern.
