package task

import java.util.*


fun main(args: Array<String>) {

    pilihan()
}

fun pilihan(){

    val a = "Y"
    if (a == "Y" || a == "y") {
        println("")
        println("_________________________________________")
        println("|          Pilihan            |         |")
        println("|_____________________________|_________|")
        println("| 1. List Makanan.kt             |         |")
        println("| 2. Tambah Produk            |         |")
        println("| 3. D8.Keluar                   |         |")
        println("|_____________________________|_________|")
    }

    val input = Scanner(System.`in`)
    print("Masukkan Pilihan : ")
    val input_item = input.nextInt()
    println("________________________________________________")
    if (input_item == 1) {
        listMakanan()
    }else if (input_item == 2){
        tambahProduk()
        return tambahProduk()
    }else if (input_item == 3){
        keluar()
        return keluar()
    }

}

fun listMakanan(){

    val input = Scanner(System.`in`)
    var harga = 0
    val harga_item = intArrayOf(20000, 35000, 59000, 63000, 120000, 180000, 5000, 2000)
    var menu: String? = null
    var total: Int
    val diskon: Double
    val bayar: Double
    val pembayaran: Int
    var a = "Y"
    while (a == "Y" || a == "y") {
        println("")
        println("|_______________________________________________|")
        println("|                       MENU                    |")
        println("|                   Burjo ku                    |")
        println("|_______________________________________________|")
        println("|          Nama               |     Harga       |")
        println("|_____________________________|_________________|")
        println("| 1. Mie Tante                |   Rp 20000      |")
        println("| 2. Mie Telur                |   Rp 35000      |")
        println("| 3. Nasi Omlet               |   Rp 59000      |")
        println("| 4. Nasi Orak Arik           |   Rp 63000      |")
        println("| 5. Magelangan               |   Rp 120000     |")
        println("| 6. Nasi Ayam Goreng         |   Rp 180000     |")
        println("| 7. Es teh Manis             |   Rp 5000       |")
        println("| 8. Teh Tawar                |   Rp 2000       |")
        println("|_____________________________|_________________|")
        println("|ketik 9 untuk kembali                          |")
        println("")
        println("________________________________________________")
        print("Masukkan Nomor Item : ")
        val input_item = input.nextInt()
        if (input_item == 9){
            pilihan()
        }
        print("Masukkan banyaknya Item : ")
        val jumlah = input.nextInt()
        println("________________________________________________")

        if (input_item == 1) {
            menu = " Mie Tante "
            harga = harga + harga_item[0] * jumlah
            total = harga_item[0] * jumlah
            println("D8.Menu Pesanan Anda : $menu    x$jumlah   |  Rp. $total")
        } else if (input_item == 2) {
            menu = "Mie Telur "
            harga = harga + harga_item[1] * jumlah
            total = harga_item[1] * jumlah
            println("D8.Menu Pesanan Anda : $menu    x$jumlah   |  Rp. $total")
        } else if (input_item == 3) {
            menu = " Nasi Omlet "
            harga = harga + harga_item[2] * jumlah
            total = harga_item[2] * jumlah
            println("D8.Menu Pesanan Anda : $menu    x$jumlah   |  Rp. $total")
        } else if (input_item == 4) {
            menu = " Nasi Orak Arik "
            harga = harga + harga_item[3] * jumlah
            total = harga_item[3] * jumlah
            println("D8.Menu Pesanan Anda : $menu    x$jumlah   |  Rp. $total")
        } else if (input_item == 5) {
            menu = " Magelangan "
            harga = harga + harga_item[4] * jumlah
            total = harga_item[4] * jumlah
            println("D8.Menu Pesanan Anda : $menu    x$jumlah   |  Rp. $total")
        } else if (input_item == 6) {
            menu = " Nasi Ayam Goreng "
            harga = harga + harga_item[5] * jumlah
            total = harga_item[5] * jumlah
            println("D8.Menu Pesanan Anda : $menu    x$jumlah   |  Rp. $total")
        } else if (input_item == 7) {
            menu = " Es teh Manis "
            harga = harga + harga_item[6] * jumlah
            total = harga_item[6] * jumlah
            println("D8.Menu Pesanan Anda : $menu    x$jumlah   |  Rp. $total")
        } else if (input_item == 8) {
            menu = " Teh Tawar "
            harga = harga + harga_item[7] * jumlah
            total = harga_item[7] * jumlah
            println("D8.Menu Pesanan Anda : $menu    x$jumlah   |  Rp. $total")
        }else {
            println("D8.Menu yang anda pilih belum tersedia.")
        }
        println("Apakah anda mau memesan lagi? Y/T")
        a = input.next()
    }
    diskon = if (harga >= 500000) {
        harga * 0.5
    } else if (harga >= 200000) {
        harga * 0.35
    } else if (harga >= 50000) {
        harga * 0.1
    } else {
        0.0
    }
    bayar = harga - diskon
    println("________________________________________________")
    println(" Pembayaran sebesar           :  Rp.$harga")
    println(" Anda mendapat diskon sebesar :  Rp.$diskon")
    println(" Total yang harus anda bayar  :  Rp.$bayar")
    println("________________________________________________")
    print(" Jumlah uang yang diberikan   :  RP.")
    pembayaran = input.nextInt()
    val kembalian = pembayaran - bayar
    println(" Kembalian Anda Sebesar       :  Rp.$kembalian")
    println("________________________________________________")
    println("           Terimakasih atas kunjungannya.       ")
    println("________________________________________________")
}

fun tambahProduk(){
    val toHome = Scanner(System.`in`)
    val s = Scanner(System.`in`)
    println("Enter the length of the array:")
    val length = s.nextInt()
    val myArray = IntArray(length)
    println("Enter the elements of the array:")
    for (i in 0 until length) {
        myArray[i] = s.nextInt()
    }
    println(Arrays.toString(myArray))

    println("ketik 9 untuk kembali")
    val inputtoHome = toHome.nextInt()
    if (inputtoHome == 9){
        pilihan()
    }
}

fun keluar(){

    println("Apakah sudah yakin ingin keluar? Y/T")
    val keluartoHome = Scanner(System.`in`)
    val exit = keluartoHome.next()
    if (exit == "T"){ pilihan() }
    if (exit == "Y"){ exit }

}