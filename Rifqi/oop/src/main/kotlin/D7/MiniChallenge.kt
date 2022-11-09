//import java.util.*
//
//var listMkn = mutableListOf("Mie Tante", "Mie Telur", "Nasi Omlet", "Nasi Orak Arik", "Es teh Manis", "Teh Tawar")
//var Harga = mutableListOf(20000, 35000, 59000, 63000, 5000, 2000 )
//var reqMkn = mutableListOf<String>()
//var totalMkn = mutableMapOf<String, Int>()
//var ammount = 0
//var price = 0
//var total = 0
//var input = ""
//var harga = 0
//
//fun main(){
//    mm()
//}
//
//fun mm(){
//    do{
//        println("""
//         ---------------------------------
//        |            MAIN MENU           |
//         ---------------------------------
//        | 1. Tampilkan D8.Menu              |
//        | 2. Tambahkan D8.Menu              |
//        | 3. Pemesanan Makanan           |
//        | 4. D8.Keluar Program              |
//         ---------------------------------
//        |        Pilih Angka (1-4)       |
//         ---------------------------------
//        """.trimIndent())
//
//
//        print("Masukkan Pilihan Anda : ")
//        val input = readLine()!!.toInt()
//        println("======================================")
//        println()
//        if (input == 1) {
//            tampilkanMenu()
//        }else if (input == 2){
//            tambahkanMenu()
//        }else if (input== 3){
//            pesan()
//        }
//        else if (input==4){
//            logout()
//        }
//
//        println()
//        print("Apakah anda ingin mengulang program ? y/n : ")
//        val pilih = readLine()!!.toString()
//
//    }while (pilih =="Y" || pilih == "y")
//}
//
//
//fun tampilkanMenu(){
//    println("-- Menampilkan D8.Menu Makanan --")
//    println()
//    fun listMenu() : String {
//        for(a in listMkn.indices) {
//            println("|  ${listMkn[a].padEnd(16).capitalize()} | Rp.${Harga[a]}   |")
//        }
//        return ("")
//    }
//
//    print("""
//         ---------------------------------
//        |            LIST MENU           |
//         ---------------------------------
//        | Nama Makanan    |     Harga    |
//         ---------------------------------
//
//    """.trimIndent())
//    listMenu()
//    println(" ---------------------------------")
//
//}
//
//fun tambahkanMenu(){
//    println("-- Menambahkan Makanan --")
//    println()
//
//    print("Masukan menu yang ingin ditambahkan : ")
//    val input: String? = readLine()?.toLowerCase()
//    if (input != null) {
//        if (input.let { kapitalis(it) } in listMkn){
//            println("""
//                Makanan Sudah Ada
//            """.trimIndent())
//            tambahkanMenu()
//        } else{
//            listMkn.add(kapitalis(input))
//        }
//    }
//    print("Masukan D8.getHarga : ")
//    val read = Scanner(System.`in`)
//    val harga = read.nextInt()
//    Harga.add(harga)
//
//    println("**************************************")
//    println()
//    println("         D8.Menu yang baru")
//    tampilkanMenu()
//}
//
//fun pesan() {
//    println("-- Pemesanan Makanan --")
//    println()
//    println("NOTE : 1. Jika sebelumnya anda sudah menambahkan menu, menu tersebut belum dapat dipesan (menu yang paling bawah)")
//    println("       2. Namun jika anda belum pernah menambahkan menu, maka semua menu yang ada tersedia")
//    println()
//
//    print("Apakah anda ingin melihat menu sebelum memesan ? y/n : ")
//    val lihat = readLine()!!.toString()
//    if (lihat == "Y" || lihat == "y") {
//        tampilkanMenu()
//    }
//    print("Inputkan jumlah menu yang akan anda pesan : ")
//    var jmlpsn = readLine()!!.toInt()
//    println("NOTE :  Pastikan anda menuliskan menu dengan benar")
//    println()
//
//    var x = 0
//    while (x < jmlpsn) {
//        println("Pesanan ke-${x + 1}")
//        print("Inputkan menu yang ingin dipesan : ")
//        val mkn = readLine()!!.toString()
//        if (mkn != null) {
//            reqMkn.add(kapitalis(mkn))
//        }
//        if (mkn?.let { kapitalis(it) } in reqMkn) {
//            ammount++
//        }
//        print("Ingin memesan berapa ? : ")
//        val jml = readLine()!!.toInt()
//        println("-->")
//
//        var biaya: (Int, Int) -> Int = { jml: Int, harga: Int ->
//            jml * harga
//        }
//        var bayar = biaya(jml, price)
//
//        if (mkn == "Mie tante" || mkn == "mie tante") {
//            println("D8.Menu : Mie Tante")
//            println("  -- Rp. 20.000")
//            println("  -- $jml porsi")
//            println()
//            price = 20000
//            bayar = jml * price
//        } else if (mkn == "Mie telur" || mkn == "mie telur") {
//            println("D8.Menu : Mie Telur")
//            println("  -- Rp. 35.000")
//            println("  -- $jml porsi")
//            println()
//            price = 35000
//            bayar = jml * price
//        } else if (mkn == "Nasi omelet" || mkn == "nasi omelet") {
//            println("D8.Menu : Nasi Omelet")
//            println("  -- Rp. 59.000")
//            println("  -- $jml porsi")
//            println()
//            price = 59000
//            bayar = jml * price
//        } else if (mkn == "Nasi orak arik" || mkn == "nasi orak arik") {
//            println("D8.Menu : Nasi Orak Arik")
//            println("  -- Rp. 63.000")
//            println("  -- $jml porsi")
//            println()
//            price = 63000
//            bayar = jml * price
//        } else if (mkn == "Es teh manis" || mkn == "es teh manis") {
//            println("D8.Menu : Es Teh Manis")
//            println("  -- Rp. 5.000")
//            println("  -- $jml porsi")
//            println()
//            price = 5000
//            bayar = jml * price
//        } else if (mkn == "Teh tawar" || mkn == "teh tawar") {
//            println("D8.Menu : Teh Tawar")
//            println("  -- Rp. 2.000")
//            println("  -- $jml porsi")
//            println()
//            price = 2000
//            bayar = jml * price
//        } else {
//            println("D8.Menu yang anda inputkan tidak tersedia")
//            price = 0
//        }
//        x++;
//        D8.total = D8.total + bayar
//    }
//    println()
//    println("Total bayar = Rp. ${D8.total}")
//    println("---------------------------------")
//    print("Jumlah uang yang diberikan = Rp. ")
//    val uang = readLine()!!.toInt()
//    val kembalian = uang - D8.total
//    println("Kembalian Anda Sebesar = Rp.$kembalian")
//
//}
//
//fun logout(){
//    println("""
//         ----- TERIMAKASIH -------
//       -- Silakan Datang Kembali --
//    """.trimIndent())
//}
//
//fun kapitalis(str: String): String {
//    return str.trim().split("\\s+".toRegex())
//        .map { it.capitalize() }
//        .joinToString(" ")
//}
