```markdown
# Test Automation API for OpenWeatherMap

Proyek ini adalah test automation API yang dirancang untuk menguji endpoint dari **OpenWeatherMap API**, khususnya untuk mendapatkan **5 Days Weather Forecast** dan **Current Air Pollution**. Proyek ini menggunakan **Katalon Studio** sebagai alat untuk membuat dan menjalankan test case.

## Daftar Isi
- [Fitur yang Diuji](#fitur-yang-diuji)
- [Prasyarat](#prasyarat)
- [Cara Mendapatkan API Key](#cara-mendapatkan-api-key)
- [Instalasi](#instalasi)
- [Menjalankan Test](#menjalankan-test)
- [Struktur Proyek](#struktur-proyek)
- [Laporan Test](#laporan-test)
- [Kontribusi](#kontribusi)

## Fitur yang Diuji
Proyek ini mencakup test case untuk beberapa skenario berikut:
1. **5 Days Weather Forecast** - Menguji endpoint untuk mendapatkan prediksi cuaca 5 hari ke depan.
2. **Current Air Pollution** - Menguji endpoint untuk mendapatkan data polusi udara saat ini.

## Prasyarat
Sebelum memulai, pastikan Anda telah menginstal:
- [Katalon Studio](https://katalon.com/download) (versi terbaru disarankan).
- Java JDK (versi yang kompatibel dengan Katalon Studio).
- API Key dari OpenWeatherMap (lihat cara mendapatkan API Key di bawah).

## Cara Mendapatkan API Key
1. Buka [OpenWeatherMap](https://openweathermap.org/api) dan buat akun jika Anda belum memiliki akun.
2. Setelah login, navigasikan ke halaman [API Keys](https://home.openweathermap.org/api_keys).
3. Klik tombol **Generate** untuk membuat API Key baru.
4. Salin API Key yang dihasilkan dan simpan di tempat yang aman. API Key ini akan digunakan untuk mengakses API OpenWeatherMap.

## Instalasi
1. Clone repositori ini ke lokal mesin Anda:
   ```bash
   git clone https://github.com/username/repo-name.git
   ```
2. Buka Katalon Studio.
3. Pilih **File** > **Open Project** dan arahkan ke folder proyek yang telah di-clone.
4. Buka file `Data Files/testdata.xlsx` dan masukkan API Key Anda di kolom yang disediakan.

## Menjalankan Test
1. Buka Katalon Studio dan pastikan proyek sudah terbuka.
2. Navigasikan ke **Test Cases** di panel **Test Explorer**.
3. Pilih test case yang ingin dijalankan, misalnya:
   - `Get5DaysForecastTest`
   - `GetCurrentAirPollutionTest`
4. Klik tombol **Run** untuk menjalankan test case.
5. Anda juga dapat menjalankan seluruh test suite dengan memilih **Test Suites** dan menjalankan suite yang tersedia.

## Struktur Proyek
Berikut adalah struktur dasar proyek:
```
/project-name
│
├── /Test Cases
│   ├── Get5DaysForecastTest
│   └── GetCurrentAirPollutionTest
│
├── /Test Suites
│   ├── AllTestsSuite
│
├── /Object Repository
│   ├── WeatherForecastPage
│   ├── AirPollutionPage
│
│
└── /Reports
    ├── HTML Reports
    └── JUnit Reports
```

## Laporan Test
Setelah menjalankan test, laporan akan otomatis di-generate dan disimpan di folder `/Reports`. Anda dapat melihat laporan dalam format HTML atau JUnit untuk analisis lebih lanjut.

## Kontribusi
Jika Anda ingin berkontribusi pada proyek ini, silakan ikuti langkah-langkah berikut:
1. Fork repositori ini.
2. Buat branch baru (`git checkout -b fitur-baru`).
3. Commit perubahan Anda (`git commit -m 'Menambahkan fitur baru'`).
4. Push ke branch (`git push origin fitur-baru`).
5. Buat Pull Request.

### Penjelasan:
1. **Fitur yang Diuji**: Menjelaskan skenario test yang diimplementasikan.
2. **Prasyarat**: Daftar software yang diperlukan sebelum menjalankan proyek.
3. **Cara Mendapatkan API Key**: Panduan langkah demi langkah untuk mendapatkan API Key dari OpenWeatherMap.
4. **Instalasi**: Langkah-langkah untuk mengatur proyek di mesin lokal.
5. **Menjalankan Test**: Cara menjalankan test case atau test suite.
6. **Struktur Proyek**: Gambaran struktur folder proyek.
7. **Laporan Test**: Informasi tentang laporan yang dihasilkan setelah test dijalankan.
8. **Kontribusi**: Panduan untuk berkontribusi pada proyek.
9. **Lisensi**: Informasi lisensi proyek.

### Catatan:
- Pastikan Anda menyimpan API Key dengan aman dan tidak membagikannya secara publik.
