var daftar_Makanan = mutableListOf("nasi goreng","bakmi basah", "gorengan")
var daftar_Harga = mutableListOf(100,150,200)
var jumlah_Pesanan2 = mutableListOf(0)
var makanan_Dipesan = mutableListOf("kosong")
var harga_Dipesan = mutableListOf(300)
var cek_Makanan_sudah_Ada = false
var persetujuan_Update_Makanan = 0
var total_Semua = 0
var pesanan_Pertama = 0
// simpan menu dan harga pada list, map, atau key -> value

fun main() {
    makanan_Dipesan.removeAt(0)
    harga_Dipesan.removeAt(0)
    jumlah_Pesanan2.removeAt(0)
    halaman_Utama()
//    lihat_menu()
//    tambah_Makanan()
//    lihat_menu()
//    penjualan()
//    println(daftar_Menu)
    /*  menerima input dengan menjadikannya integer
val a= readLine()!!
    https://stackoverflow.com/questions/41283393/reading-console-input-in-kotlin
     */
}
fun halaman_Utama () {
    println("=====Selamat Datang Di Warung SukaMaju======")
    println("1. Lihat Menu")
    println("2. Tambah Makanan ")
    println("3. Penjualan")
    println("4. Keluar")
    // menggunakan switch case, if else, when dll
    do {
        print("Silahkan memilih menu [ 1 - 4 ] :")
        var input_menu = readLine()!!.toInt()
        when (input_menu) {
            1 -> lihat_menu()
            2 -> tambah_Makanan()
            3 -> penjualan()
            4 -> keluar()
        }
    }while (input_menu > 4)
}

fun lihat_menu () {
    println("Menu".padEnd(30) + "Harga")
    println("====================================================")
    for (i in 0.. daftar_Makanan.size - 1)   {
        //      validasi kapital di setiap kata
        var kapital = daftar_Makanan[i].split(" ").toTypedArray()
        if (kapital.size > 1){
            for (j in 0..kapital.size){
                if (j < kapital.size){
                    print(kapital[j].capitalize() + " ")
                }else{
                    println("".padEnd(20) + "Rp. " + daftar_Harga[i])
                }
            }
        }else{
            println(daftar_Makanan[i].capitalize().padEnd(30) + "Rp. " + daftar_Harga[i])
        }
        //       selesai

    }
    print("Tekan enter untuk kembali ke menu utama...")
    var input = readLine()!!.toString()
    halaman_Utama()
}
fun tambah_Makanan () {
    var makanan_Update = false
    do {
//                ingin bertanya apakah makanan jika sudah ada pesanan menjadi 2 atau tidak
        println("Masukan nama makanan")
        var nama_makanan1 = readLine()!!.toString()
//                             logic pengecekan untuk nama makanan yg sama (case sensitive)
        var huruf_Kecil = nama_makanan1.toLowerCase()
        var cek_Huruf_Kecil = daftar_Makanan.map { it.lowercase() }
        for (i in 0..cek_Huruf_Kecil.size - 1) {
            if (huruf_Kecil.equals(cek_Huruf_Kecil[i])) {
                println("Makanan sudah ada. Apakah anda ingin memperbarui makanan yang sudah ada?")
                println("1. Iya\t2. Tidak")
                persetujuan_Update_Makanan = readLine()!!.toInt()
                if (persetujuan_Update_Makanan == 1) {
                    makanan_Update = true
                    println("Masukan harga")
                    var harga1 = readLine()!!.toInt()
//                        daftar_Harga.removeAt(i)
//                        daftar_Harga.add(i, harga1)
                    daftar_Harga.set(i,harga1)
                    halaman_Utama()
                }else if (persetujuan_Update_Makanan == 2){
                    halaman_Utama()
                }
            }
        }
        //  nama makanan beda tetapi harus menggunakan penghalang
        daftar_Makanan.add(nama_makanan1)
        println("Masukan harga")
        var harga1 = readLine()!!.toInt()
        daftar_Harga.add(harga1)
//            jumlah_Pesanan2.add(0)
        println("Apakah anda ingin menambah menu lagi ? [ 1 - 2 ]: ")
        println("1. Iya")
        println("2. Tidak")
        var pil_Tambah_Makan = readLine()!!.toInt()
    } while (pil_Tambah_Makan == 1)
    halaman_Utama()
}
fun penjualan () {
    do {
        println("No.".padEnd(5) +"Menu".padEnd(30) + "Harga")
        println("====================================================")
        //          bikin jumlah pesanan yg dibuat (Bisa 2 atau lebih dengan menu yg sama )
        for (i in 0.. daftar_Makanan.size - 1) {
            //      validasi kapital di setiap kata
            var kapital = daftar_Makanan[i].split(" ").toTypedArray()
            if (kapital.size > 1) {
                print("${i+1}".padEnd (4))
                for (j in 0..kapital.size) {
                    if (j < kapital.size) {
                        print(kapital[j].capitalize() + " ")
                    } else {
                        println("".padEnd(20) + "Rp. " + daftar_Harga[i])
                    }
                }
            } else {
                println("${i+1}".padEnd(4) + daftar_Makanan[i].capitalize().padEnd(30) + "Rp. " + daftar_Harga[i])
            }
        }
        //       selesai

        println("====================================================")

        print("Pilih makanan yang ingin dipesan : [1 - ${daftar_Makanan.size}]")
        var input = readLine()!!.toInt()
//    input_Pesanan = input
        //              logic pesanan dari user
        for (i in 0..daftar_Makanan.size - 1){
            //           inisialisasi
            if ( (i == input-1) ) {
                println("Menjalankan makanan yang belum pernah dipesan")
                makanan_Dipesan.add(daftar_Makanan[i])
                harga_Dipesan.add(daftar_Harga[i])
                jumlah_Pesanan2.add(i)
                pesanan_Pertama = 1
//            println(jumlah_Pesanan2)
            }
            // makanan sudah ada sebelumnya
            else if ((i == (input-1) ) && (jumlah_Pesanan2[i] >= 1)){

                // jika makanan yang dipesan sudah ada
                println("Menjalankan makanan yang dipesan sudah ada")
                jumlah_Pesanan2.set(i,jumlah_Pesanan2[i] + 1)
                println(jumlah_Pesanan2)
            }           // makanan belum pernah dipesan
//        else {
//            println("Menjalankan makanan belum pernah dipesan")
//            makanan_Dipesan.add(daftar_Makanan[i])
//            harga_Dipesan.add(daftar_Harga[i])
//            jumlah_Pesanan2.add(1)
//        }
        }
        println("Apakah anda ingin menambah pesanan ?")
        println("1. Ya\t\t 2. Tidak\t[1 - 2]")
        var input2 = readLine()!!.toInt()
    }while(input2 == 1)
    //                  STRUK PEMESANAN
    println("==================Struk Pesanan=====================")
    println("Menu".padEnd(30) + "Harga".padEnd(20) + "Jumlah")
    for (i in makanan_Dipesan.indices) {

        println(makanan_Dipesan[i].padEnd(30) + "Rp. " + harga_Dipesan[i] +"".padEnd(15) + jumlah_Pesanan2[i])
    }
    println("====================================================")
    for (i in makanan_Dipesan.indices){
        var total1 = harga_Dipesan[i] * jumlah_Pesanan2[i]
        total_Semua =+ total1
    }
    println("Jumlah Belanja : ".padEnd(30) + "Rp. " + total_Semua )
    print("Tekan enter untuk kembali ke menu utama...")
    var input = readLine()!!.toString()
    halaman_Utama()
}
fun keluar () {
    println("Terima kasih atas kunjungannya.")
}
