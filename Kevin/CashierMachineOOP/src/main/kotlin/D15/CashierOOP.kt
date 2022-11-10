import java.util.NoSuchElementException
import java.util.Scanner

var listMakan = mutableListOf("Nasi", "Sate", "Wagyu")
var listHarga = mutableListOf(30000, 20000, 500000)
var totalMakan = mutableMapOf<String, Int>()

fun cashier(){
    mainMenu()
}

fun mainMenu(){
    println("""
        **********************************
        ------------ MAIN MENU -----------
        **********************************
        1. Tampilkan Menu
        2. Tambahkan Menu
        3. Penjualan Makanan
        4. Keluar Program
        **********************************
        ------- Pilih Angka (1-4) --------
        **********************************
    """.trimIndent())

    print("""
        Masukkan angka: 
    """.trimIndent())
    val userIn: Int = Integer.valueOf(readLine())
    when (userIn){
        1 -> tampilMenu()
        2 -> nambahMenu()
        3 -> jualMenu()
        4 -> keluarProgram()
    }
}

fun tampilMenu(){
    fun panggilMenu(): String{
        for(indx in listMakan.indices){
            println("""
                ${listMakan[indx].padEnd(18).capitalize()} Rp.${listHarga[indx]}
            """.trimIndent())
        }
        return ("")
    }

    println("""
        **********************************
        ---------- MENU MAKANAN ----------
        **********************************
        Nama Makanan    |     Harga  
        
    """.trimIndent())
    println("""
        ${panggilMenu()}
    """.trimIndent())
    println("""
        **********************************
        ----------------------------------
        **********************************
    """.trimIndent())

    println("""
        
    """.trimIndent())

    mainMenu()
}

fun nambahMenu(){
    print("""
        **********************************
        Masukkan makanan: 
    """.trimIndent())
    val input: String? = readLine()?.toLowerCase()
    if (input != null) {
        if (input.let { kapitalis(it) } in listMakan){
            println("""
                Makanan Sudah Ada
            """.trimIndent())
            println("Apakah ingin mengupdate harga? (y/n)")
            val input = readLine()?.lowercase()
            if (input == "y"){
                updateHarga(input)
                mainMenu()
            }else{
                nambahMenu()
            }
        } else{
            listMakan.add(kapitalis(input))
        }
    }


    print("""
        **********************************
        Masukkan harga: 
    """.trimIndent())
    val read = Scanner(System.`in`)
    val harga = read.nextInt()
    listHarga.add(harga)


    println("""
        **********************************
           MAKANAN BERHASIL DITAMBAHKAN
        **********************************
        
        0. Main Menu
        1. Tampilkan Menu
        2. Tambah makanan lagi
        3. Penjualan makanan
        
        ----------------------------------
        Masukkan angka: 
    """.trimIndent())
    val userIn: Int = Integer.valueOf(readLine())
    when (userIn){
        0 -> mainMenu()
        1 -> tampilMenu()
        2 -> nambahMenu()
        3 -> jualMenu()
    }
}

fun updateHarga(namaMakanan: String){
    do {
        print("Masukkan harga terbaru: ")
        try {
            val price = readLine()?.toInt() ?: throw NumberFormatException()
            val indexMakanan = listMakan.indexOf(namaMakanan)
            println(listHarga[indexMakanan])
            listHarga[indexMakanan] = price
            break
        } catch (e: NumberFormatException) {
            println("""
                            yang anda masukkan bukan angka
                            silahkan masukkan ulang
                        """.trimIndent())
        }
    } while (true)
}

fun jualMenu(){

    var exit = false
    for (indx in listMakan.indices){
        totalMakan[listMakan.get(indx)] = 0
    }
    while(exit != true){
        println("""
        **********************************
        ----- PENGEN MAKAN APA KAU?? -----
        **********************************
    """.trimIndent())

        print("""
        Makanan yang dipilih: 
    """.trimIndent())

        val makanan: String = readLine()?.lowercase()?.kapital() ?: ""
        val indexMakanan = listMakan.indexOf(makanan)
        if(indexMakanan >= 0) {
            if (makanan in totalMakan.keys){
                totalMakan[makanan] = (totalMakan.getValue(makanan) ?: 0) + 1
            }else {
                totalMakan[makanan] = 1
            }
        } else{
            println("Makanan tidak ada")
        }

        println("Ingin tambah lagi? (Y/N)")
        exit = readLine()?.let{
            it.kapital() == "N"
        } ?: true
    }
    while (exit == true){
        printBill()
    }

}

fun printBill(){
    var subTotal = 0
    var total = 0
    fun panggilPesan(): String{
        for (makanan in totalMakan.keys){
            val indexMakanan = listMakan.indexOf(makanan)
            val harga = listHarga[indexMakanan]
            subTotal = harga * try{
                totalMakan.getValue(makanan)
            } catch(e: NoSuchElementException){
                0
            }
            total += subTotal

            if(totalMakan.getValue(makanan) > 0){
                println("""
                    ${makanan.kapital().padEnd(20)} ${totalMakan.getValue(makanan).toString().padEnd(9)} Rp.$subTotal
                """.trimIndent())
            }
        }
        return " "
    }

    println("""
            *****************************************
            ----------- INGPO MAKANAN KAU -----------
            *****************************************
            Nama Makanan    |   Total   |     Harga
                
        """.trimIndent())

    println("""
            ${panggilPesan()}
        """.trimIndent())

    println("""
            -----------------------------------------
            Total Harga: Rp.$total
        """.trimIndent())

    mainMenu()
}

fun keluarProgram(){
    println("""
       ***********************************
       ----- BELI DOANG MAKAN KAGAK ------
    """.trimIndent())
}

fun kapitalis(str: String): String {
    return str.trim().split("\\s+".toRegex())
        .map{ it.capitalize() }
        .joinToString (" ")
}

fun String.kapital(): String = trim().split(" ").map{it.capitalize()}.joinToString(" ")
