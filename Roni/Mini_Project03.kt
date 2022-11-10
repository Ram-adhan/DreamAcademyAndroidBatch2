var daftar_Makanan = mutableListOf("nasi gorEng","baKmi bASAH", "goreNgan")
var daftar_Harga = mutableListOf(100,150,200)
var jumlah_Pesanan2 = mutableListOf(0)
var makanan_Dipesan = mutableListOf("kosong")
var harga_Dipesan = mutableListOf(300)
var makanan_Beda = false
var persetujuan_Update_Makanan = 0
var total_Semua = 0
var user_memesan = 0
// simpan menu dan harga pada list, map, atau key -> value

fun main() {
    makanan_Dipesan.removeAt(0)
    harga_Dipesan.removeAt(0)
    jumlah_Pesanan2.removeAt(0)
    halaman_Utama()
}
fun halaman_Utama () {
    println("=====Selamat Datang Di Warung SukaMaju======")
    println("1. Lihat Menu")
    println("2. Tambah Makanan.kt ")
    println("3. Penjualan")
    println("4. Keluar")
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
    println("Menu\t\t\t\t" + "Harga")
    println("====================================================")
    for (i in 0.. daftar_Makanan.size - 1)   {
        //      validasi kapital di setiap kata
        var kata_kecil = daftar_Makanan[i].lowercase()
        var kapital = kata_kecil.split(" ").toTypedArray()
        if (kapital.size > 1){
            for (j in 0..kapital.size){
                if (j < kapital.size){
                    print(kapital[j].capitalize() + " ")
                }else{
                    println("\t\t" + "Rp. " + daftar_Harga[i])
                }
            }
        }else{
            println(kata_kecil.capitalize() + "\t\t\tRp. " + daftar_Harga[i])
        }
        //       selesai

    }
    print("Tekan enter untuk kembali ke menu utama...")
    var input = readLine()!!.toString()
    halaman_Utama()
}
fun tambah_Makanan () {
    do {
        println("Masukan nama makanan")
        var nama_makanan1 = readLine()!!.toString()
//                             logic pengecekan untuk nama makanan yg sama (case sensitive)
        var huruf_Kecil = nama_makanan1.lowercase()
        var cek_Huruf_Kecil = daftar_Makanan.map { it.lowercase() }
        for (i in 0..cek_Huruf_Kecil.size - 1) {
            if (huruf_Kecil.equals(cek_Huruf_Kecil[i])) {
                println("Makanan.kt sudah ada. Apakah anda ingin memperbarui makanan yang sudah ada?")
                println("1. Iya\t2. Tidak")
                persetujuan_Update_Makanan = readLine()!!.toInt()
                if (persetujuan_Update_Makanan == 1) {
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
        daftar_Makanan.add(nama_makanan1)
        println("Masukan harga")
        var harga1 = readLine()!!.toInt()
        daftar_Harga.add(harga1)
        println("Apakah anda ingin menambah menu lagi ? [ 1 - 2 ]: ")
        println("1. Iya")
        println("2. Tidak")
        var pil_Tambah_Makan = readLine()!!.toInt()
    } while (pil_Tambah_Makan == 1)
    halaman_Utama()
}
fun penjualan () {
    do {
        println("No.".padEnd(3) +"\tMenu\t\t" + "Harga")
        println("====================================================")
        for (i in 0.. daftar_Makanan.size - 1) {
            //      validasi kapital di setiap kata
            var kata_Kecil2 = daftar_Makanan[i].lowercase()
            var kapital = kata_Kecil2.split(" ").toTypedArray()
            if (kapital.size > 1) {
                print("${i+1}".padEnd (4))
                for (j in 0..kapital.size) {
                    if (j < kapital.size) {
                        print(kapital[j].capitalize() + " ")
                    } else {
                        println("\t\t" + "Rp. " + daftar_Harga[i])
                    }
                }
            } else {
                println("${i+1}".padEnd(4) + kata_Kecil2.capitalize() + "\t\t\tRp. " + daftar_Harga[i])
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
            if ( (i == input-1) && (user_memesan == 0)) {
//            pesanan pertama
                makanan_Dipesan.add(daftar_Makanan[i])
                harga_Dipesan.add(daftar_Harga[i])
                jumlah_Pesanan2.add(1)
                user_memesan = 1
            }else if ( (i == input-1 ) && (user_memesan >= 1) ){
                for (j in 0..makanan_Dipesan.size - 1){
                    // pesanan dengan makanan yang sama
//                    println("pesanan dengan makanan yang sama")
                    if (daftar_Harga[i] == harga_Dipesan[j]) {
                        jumlah_Pesanan2.set(j,jumlah_Pesanan2[j] + 1)
                        makanan_Beda = false
                        break
                    }
                    makanan_Beda = true
                }
                // pesanan dengan makanan yang beda
                if (makanan_Beda == true){
//                print("pesanan dengan makanan yang beda")
                    makanan_Dipesan.add(daftar_Makanan[i])
                    harga_Dipesan.add(daftar_Harga[i])
                    jumlah_Pesanan2.add(1)
                }
            }
        }
        println("Apakah anda ingin menambah pesanan ?")
        println("1. Ya\t\t 2. Tidak\t[1 - 2]")
        var input2 = readLine()!!.toInt()
    }while(input2 == 1)
    //                  STRUK PESANAN
    println("==================Struk Pesanan=====================")
    println("Menu\t\t\t" + "Harga\t\t\t" + "Jumlah\t" + "Sub total")
    for (i in makanan_Dipesan.indices) {
        var kata_Kecil = makanan_Dipesan[i].lowercase()
        var kapital = kata_Kecil.split(" ").toTypedArray()
        if (kapital.size > 1){
            for (j in 0.. kapital.size - 1){
                print(kapital[j].capitalize() + " ")
            }
        }else {
            print(kata_Kecil.capitalize()+ "\t\t\t")
        }
        var subtotal = harga_Dipesan[i] * jumlah_Pesanan2[i]
        println("\tRp." + harga_Dipesan[i] +"\t\t\t" + jumlah_Pesanan2[i] + "\t\t" + subtotal)
    }
    println("====================================================")
    total_Semua = 0
    for (i in makanan_Dipesan.indices){
        var total1 = harga_Dipesan[i] * jumlah_Pesanan2[i]
        total_Semua = total_Semua + total1
    }
    println("Jumlah Belanja : ".padEnd(30) + "Rp. " + total_Semua )
    print("Tekan enter untuk kembali ke menu utama...")
    var input = readLine()!!.toString()
    halaman_Utama()
}
fun keluar () {
    println("Terima kasih atas kunjungannya.")
}


