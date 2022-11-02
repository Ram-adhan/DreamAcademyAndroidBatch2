import java.util.Scanner

var listMakan = mutableListOf("Nasi", "Sate", "Wagyu")
var listHarga = mutableListOf(30000, 20000, 500000)
var reqMakan = mutableListOf<String>()
var sum = 0

fun main(){
    mainMenu()
}

fun mainMenu(){
    println("""
        **********************************
        -------------MAIN MENU------------
        **********************************
        1. Tampilkan Menu
        2. Tambahkan Menu
        3. Penjualan Makanan
        4. Keluar Program
        **********************************
        ----------------------------------
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
                ${listMakan[indx].padEnd(18)} Rp.${listHarga[indx]}
            """.trimIndent())
        }
    return ("")
    }

    println("""
        **********************************
        -----------MENU MAKANAN-----------
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
    val input: String? = readLine()
    val tambahanMenu = input
    listMakan += "${tambahanMenu}"

    print("""
        **********************************
        Masukkan harga: 
    """.trimIndent())
    val read = Scanner(System.`in`)
    val harga = read.nextInt()
    listHarga.add(harga)


    println("""
        MAKANAN BERHASIL DITAMBAHKAN
        
        0. Main Menu
        1. Tampilkan Menu
        2. Tambah makanan lagi
        3. Penjualan makanan
        
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
        ------PENGEN MAKAN APA KAU??------
        **********************************
    """.trimIndent())

    print("""
        Makanan yang dipilih: 
    """.trimIndent())

    val input: String? = readLine()
    val tambahanMenu = input?.split(" ")
    reqMakan += "${tambahanMenu}"

//    val input: String? = readLine()
//    val reqMakan: List<String>? = input?.split(",")
//    orderMenu += "${reqMakan}"
//    println(orderMenu)

    fun showBill(){
        fun panggilPesan(): String{
            if (reqMakan != null) {
                for(indx in reqMakan.indices){
                    println("""
                        ${reqMakan[indx].padEnd(18)} Rp.${listHarga.get(listMakan.indexOf(reqMakan[indx]))}
                    """.trimIndent())
                }
            }
            return(" ")
        }

        println("""
            **********************************
            --------STRUK MAKANAN KAU---------
            **********************************
            Nama Makanan     |    Harga
                
        """.trimIndent())

        println("""
            ${panggilPesan()}
        """.trimIndent())

        println("""
            ----------------------------------
            Total Harga: $sum
        """.trimIndent())

        mainMenu()

    }

    if(reqMakan != null){
        for(indx in reqMakan.indices){
            when (reqMakan[indx]){
                in listMakan -> listHarga.get(listMakan.indexOf(reqMakan[indx]))
                else -> println("Makanan Tidak ada BLOK")
            }
            sum += listHarga.get(listMakan.indexOf(reqMakan[indx]))
        }
    }
    println("""
        Mau makan lagi? (Y/N)
        """.trimIndent())

    val input1: String? = readLine()
    val req = input1
    if(req == "Y"){
        jualMenu()
    }
    else if(req == "N")(
            showBill()
            )
    else{
        println("""
            Input Tidak Valid
            """.trimIndent())
    }

}

fun keluarProgram(){
    println("""
        BELI DOANG MAKAN KAGAK
    """.trimIndent())
}