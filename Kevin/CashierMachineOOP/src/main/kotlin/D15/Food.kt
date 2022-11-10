package D15

class Food(val name: String) {
    constructor(name: String, price: Int): this(name){
        this.price = price
    }

    var price: Int = 0
        set(value){
            println("Harga lama: $field")
            field = value
            println("harga baru: $field")
        }
        get(){
            println("Harga Sekarang: $field")
            return  field
        }

    fun updatePrice(price: Int){
        this.price = price
    }

    override fun toString(): String {
        return "nama makanan: ${this.name} harga: $price "
    }
}