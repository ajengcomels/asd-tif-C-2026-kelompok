# Analisis Pengujian Linked List

## 1. Singly Linked List (SLL)

### Implementasi
Pada file `SinglyLinkedList.java`, terdapat lima method tambahan yang diimplementasikan, yaitu `get(int index)`, `indexOf(Object targetData)`, `printReverse()`, `remove(Object targetData)`, dan `toArray()`.

Method `get()` digunakan untuk mengambil data berdasarkan indeks, dengan indeks awal dimulai dari 0. Method `indexOf()` mencari indeks kemunculan pertama suatu data dan mengembalikan `-1` jika data tidak ditemukan. Method `printReverse()` mencetak data dari `tail` ke `head` menggunakan rekursi. Method `remove()` menghapus kemunculan pertama data yang sesuai dengan target, sedangkan `toArray()` mengubah seluruh data dalam linked list menjadi array dengan urutan dari `head` ke `tail`.

### Hasil dan Analisis Pengujian
Pengujian dilakukan dengan memasukkan data 1 sampai 6 menggunakan method `addFirst()`. Karena setiap data baru ditambahkan ke bagian depan, urutan akhir linked list menjadi `[6, 5, 4, 3, 2, 1]`.

| Method | Hasil aktual | Analisis |
|---|---|---|
| `get(2)` | `4` | Sesuai. Data pada indeks 2 adalah 4 karena indeks dimulai dari 0. |
| `get(12)` | `null` | Implementasi mengembalikan `null` ketika indeks berada di luar rentang. Perilaku ini merupakan hasil aktual dari kode yang digunakan. |
| `indexOf(4)` | `2` | Sesuai. Data 4 ditemukan pada indeks 2. |
| `indexOf(10)` | `-1` | Sesuai. Data 10 tidak ditemukan dalam linked list. |
| `printReverse()` | `1, 2, 3, 4, 5, 6` | Sesuai. Data dicetak dalam urutan terbalik, dari `tail` ke `head`. |
| `remove(3)` | `true` | Sesuai. Data 3 ditemukan dan berhasil dihapus. |
| `remove(8)` | `false` | Sesuai. Data 8 tidak ditemukan sehingga tidak ada node yang dihapus. |
| `toArray()` | Representasi objek array | Output awal belum memperlihatkan isi array secara langsung. |

Pada method `toArray()`, hasil yang diharapkan setelah `remove(3)` adalah `[6, 5, 4, 2, 1]`. Output awal berupa `[Ljava.lang.Object;@...` merupakan representasi objek array yang ditampilkan Java, bukan pesan error. Oleh karena itu, isi array perlu diperiksa menggunakan `Arrays.toString()` agar urutan datanya terlihat secara langsung.

Secara umum, hasil pengujian SLL menunjukkan bahwa method `get()` untuk indeks valid, `indexOf()`, `printReverse()`, dan `remove()` telah memberikan hasil yang sesuai dengan fungsi yang diharapkan pada skenario yang diuji. Isi array pada SLL masih perlu diverifikasi secara langsung melalui tampilan elemen array.


## 2. Doubly Linked List (DLL)

### Implementasi
Pada file `DoublyLinkedList.java`, lima method tambahan diimplementasikan dengan memanfaatkan pointer `next` dan `prev`.

Method `get()` mengambil data berdasarkan indeks dengan menelusuri node dari `head` atau `tail`, sesuai posisi indeks. Method `indexOf()` mencari kemunculan pertama data. Method `printReverse()` menelusuri node dari `tail` ke `head` menggunakan pointer `prev`. Method `remove()` menghapus node pertama yang sesuai dengan target dan menyesuaikan hubungan antarnode, sedangkan `toArray()` menyalin data dari `head` sampai `tail` ke dalam array.

### Hasil dan Analisis Pengujian
Pengujian DLL menggunakan urutan operasi yang sama seperti SLL. Data 1 sampai 6 dimasukkan melalui `addFirst()`, sehingga urutan akhirnya menjadi `[6, 5, 4, 3, 2, 1]`.

| Method | Hasil aktual | Analisis |
|---|---|---|
| `get(2)` | `4` | Sesuai. Data pada indeks 2 adalah 4. |
| `get(12)` | `null` | Implementasi mengembalikan `null` untuk indeks di luar rentang. |
| `indexOf(4)` | `2` | Sesuai. Data 4 ditemukan pada indeks 2. |
| `indexOf(10)` | `-1` | Sesuai. Data 10 tidak ditemukan. |
| `printReverse()` | `1, 2, 3, 4, 5, 6` | Sesuai. Penelusuran menggunakan pointer `prev` menghasilkan urutan dari `tail` ke `head`. |
| `remove(3)` | `true` | Sesuai. Data 3 berhasil dihapus. |
| `remove(8)` | `false` | Sesuai. Data 8 tidak ditemukan. |
| `toArray()` | `[6, 5, 4, 2, 1]` | Sesuai. Array berisi seluruh data yang tersisa setelah penghapusan data 3. |

Hasil pengujian menunjukkan bahwa kelima method DLL telah memberikan hasil yang sesuai pada skenario yang diuji. Method `toArray()` juga telah menampilkan isi array secara langsung, sehingga urutan datanya dapat diperiksa dan dinyatakan sesuai dengan hasil yang diharapkan.

## 3. Catatan Pengujian
Terdapat beberapa komentar pada file test bawaan yang tidak sesuai dengan hasil aktual. Contohnya, komentar pada `get(2)` menyebutkan nilai 3 dan komentar pada `indexOf(4)` menyebutkan indeks 5. Namun, karena data dimasukkan menggunakan `addFirst()`, urutan list yang terbentuk adalah `[6, 5, 4, 3, 2, 1]`. Oleh sebab itu, hasil yang benar untuk kedua pemanggilan tersebut adalah 4 dan 2.

Pada pemanggilan `get(12)`, kedua implementasi saat ini menghasilkan `null` karena indeks berada di luar rentang. Deskripsi tugas tidak menetapkan secara eksplisit perilaku yang harus diterapkan untuk indeks tidak valid, sehingga hasil tersebut dicatat sebagai perilaku aktual implementasi dan bukan langsung dinilai sebagai kesalahan.

Untuk SLL, isi array setelah penghapusan data 3 masih perlu diverifikasi melalui tampilan elemen array. Sementara itu, hasil `toArray()` pada DLL telah menampilkan `[6, 5, 4, 2, 1]` dan sesuai dengan urutan data yang tersisa.

## 4. Kesimpulan
Berdasarkan hasil pengujian yang telah dilakukan, kelima method pada SLL dan DLL menunjukkan hasil yang sesuai dengan fungsi yang diharapkan untuk skenario normal yang diuji. Pengujian `get()` pada indeks valid, `indexOf()`, `printReverse()`, dan `remove()` memperlihatkan perilaku yang sesuai pada kedua implementasi. Method `toArray()` pada DLL juga telah terverifikasi melalui tampilan isi array.

Perbedaan antara output aktual dan komentar pada file test tidak selalu menunjukkan kesalahan implementasi. Urutan data yang dihasilkan oleh `addFirst()` dan cara Java menampilkan objek array perlu diperhitungkan ketika menganalisis hasil pengujian.

Pemeriksaan lanjutan dapat dilakukan pada kondisi lain, seperti linked list kosong, data duplikat, dan penghapusan node pertama maupun terakhir, agar konsistensi struktur serta hasil setiap method dapat dipastikan.
