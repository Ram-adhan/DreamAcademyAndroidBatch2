import java.util.Scanner

var listMakan = mutableListOf("Nasi", "Sate", "Wagyu")
var listHarga = mutableListOf(30000, 20000, 500000)
var reqMakan = mutableListOf<String>()
var totalMakan = mutableMapOf<String, Int>()
var ammount = 0
var sum = 0
var price = 0
var total = 0

fun main(){
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
            nambahMenu()
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

fun jualMenu(){
    println("""
        **********************************
        ----- PENGEN MAKAN APA KAU?? -----
        **********************************
    """.trimIndent())

    print("""
        Makanan yang dipilih: 
    """.trimIndent())

    val input: String? = readLine()?.toLowerCase()
    if (input != null) {
        reqMakan.add(kapitalis(input))
    }
    if (input?.let { kapitalis(it) } in reqMakan){
        ammount ++
    }
//    else{
//        ammount = 0
//    }

    for(indx in reqMakan.indices){
        if (reqMakan[indx] in listMakan){
            listHarga.get(listMakan.indexOf(reqMakan[indx]))
        }else {
            println("Makanan Tidak ada")
            jualMenu()
        }
        sum = listHarga.get(listMakan.indexOf(reqMakan[indx]))
    }
    total += sum

    println("""
        Mau makan lagi? (Y/N)
        """.trimIndent())

    val input1: String? = readLine()?.toUpperCase()
    if (input1 == "Y") {
        jualMenu()
    } else if (input1 == "N") (
            showBill()
            )
    else {
        println(
            """
            Input Tidak Valid
            """.trimIndent()
        )
    }

}

fun keluarProgram(){
    println("""
       ***********************************
       ----- BELI DOANG MAKAN KAGAK ------
    """.trimIndent())
}

fun showBill(){
    val strukMakan = reqMakan.distinct()
    fun panggilPesan(): String{
        for(indx in strukMakan.indices){
            price = listHarga.get(listMakan.indexOf(strukMakan[indx])) * ammount
            println("""
                    ${strukMakan[indx].padEnd(20).capitalize()} ${ammount.toString().padEnd(9)} Rp.$price
                """.trimIndent())
        }
        return(" ")
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

fun kapitalis(str: String): String {
    return str.trim().split("\\s+".toRegex())
        .map{ it.capitalize() }
        .joinToString (" ")
}
fun String.kapital(): String = trim().split(" ").map{it.capitalize()}.joinToString(" ")