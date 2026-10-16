# Analisis Pengujian Singly Linked List

## 1. Implementasi yang Dilakukan
Pada file `SinglyLinkedList.java`, terdapat lima method yang diimplementasikan sesuai instruksi tugas, yaitu:
1. **`get(int index)`** digunakan untuk mengambil data berdasarkan indeks, dengan indeks `head` dimulai dari 0.
2. **`indexOf(Object targetData)`** digunakan untuk mencari indeks kemunculan pertama suatu data. Jika data tidak ditemukan, method mengembalikan `-1`.
3. **`printReverse()`** digunakan untuk mencetak data dari `tail` ke `head` menggunakan rekursi.
4. **`remove(Object targetData)`** digunakan untuk menghapus kemunculan pertama data yang sesuai dengan target. Method mengembalikan `true` jika berhasil dan `false` jika data tidak ditemukan.
5. **`toArray()`** digunakan untuk mengubah seluruh data pada linked list menjadi array dengan urutan dari `head` ke `tail`.

## 2. Hasil dan Analisis Testing
Pada file `testSinglyLinkedList.java`, data 1 sampai 6 dimasukkan menggunakan `addFirst()`. Karena setiap data baru ditambahkan ke bagian depan, urutan linked list menjadi `[6, 5, 4, 3, 2, 1]`.
| Method | Hasil aktual | Analisis |
|---|---|---|
| `get(2)` | `4` | Sesuai. Indeks 2 berisi data 4. |
| `get(12)` | `null` | Implementasi mengembalikan `null` untuk indeks di luar rentang. Perilaku yang diharapkan perlu dikonfirmasi karena komentar test menyebutkan exception. |
| `indexOf(4)` | `2` | Sesuai. Data 4 berada pada indeks 2. |
| `indexOf(10)` | `-1` | Sesuai. Data 10 tidak ditemukan. |
| `printReverse()` | `1, 2, 3, 4, 5, 6` | Sesuai. Data tercetak dari `tail` ke `head`. |
| `remove(3)` | `true` | Sesuai. Data 3 berhasil dihapus. |
| `remove(8)` | `false` | Sesuai. Data 8 tidak ditemukan. |
| `toArray()` | Representasi objek array | Isi array belum terlihat pada output karena array dicetak langsung menggunakan `System.out.println()`. |

Untuk pengujian `toArray()`, setelah data 3 dihapus, urutan array yang diharapkan adalah `[6, 5, 4, 2, 1]`. Isi aktualnya masih perlu diperiksa menggunakan `Arrays.toString()`.

## 3. Kendala yang Ditemukan
Selain pengujian lima method utama, terdapat beberapa temuan pada kode `SinglyLinkedList.java` yang perlu diperhatikan.
1. **Komentar pada file test kurang sesuai dengan hasil yang seharusnya.** Contohnya, komentar `get(2)` menyebutkan nilai 3, sedangkan hasil yang benar adalah 4. Komentar `indexOf(4)` juga menyebutkan indeks 5, padahal hasilnya 2. Komentar `printReverse()` dan hasil yang diharapkan untuk `toArray()` juga tidak sesuai dengan urutan data setelah operasi dilakukan.
2. **Method `addAfter()` belum memperbarui `size` dan `tail`.** Penyisipan node dapat membuat ukuran list dan referensi node terakhir tidak konsisten.
3. **Method `deleteLast()` memiliki kesalahan penelusuran node.** Kode justru mencapai node terakhir yang lama, bukan node sebelum `tail`. Akibatnya, node terakhir tidak benar-benar terlepas dari struktur linked list meskipun `size` berkurang.
4. **Method `deleteAfter()` belum menangani seluruh kondisi dengan benar.** Method belum memvalidasi indeks dan belum memperbarui `tail` ketika node terakhir dihapus.
Temuan pada `addAfter()`, `deleteLast()`, dan `deleteAfter()` merupakan kendala pada method lama di luar lima method utama yang ditugaskan. Perbaikannya perlu didiskusikan dengan kelompok sebelum dilakukan.

## 4. Kesimpulan
Berdasarkan hasil pengujian awal, empat method utama, yaitu `get()` untuk indeks valid, `indexOf()`, `printReverse()`, dan `remove()`, telah menunjukkan hasil yang sesuai pada skenario yang diuji. Method `toArray()` masih perlu diverifikasi isi array-nya, sedangkan perilaku `get()` untuk indeks tidak valid perlu dikonfirmasi.
Selain itu, terdapat beberapa bug pada method lama yang dapat memengaruhi konsistensi linked list. Oleh karena itu, pengujian akhir perlu dilakukan kembali setelah kelompok menyelesaikan perbaikan dan memeriksa seluruh skenario yang relevan.