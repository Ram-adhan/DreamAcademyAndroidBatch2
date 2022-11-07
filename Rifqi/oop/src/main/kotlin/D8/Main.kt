fun main(args: Array<String>) {
    val makanan = Food("Ayam Goreng")
    makanan.updatePrice(1000)
    makanan.price = 100000
    println(makanan.toString())

    val makanan2 = Food("Pizza", 12000)
    println(makanan2.toString())
}