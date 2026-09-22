package ejemplos

fun main(args: Array<String>) {
    val c = Circle(name = "Usando constructor con parametro String")
}
class Circle(val radius: Double){
    constructor(name: String):this(3.0){
        println("in diameter constructor")
    }

    constructor(diameter:Int): this(diameter/2.0){
        println("Area: ${Math.PI + radius + radius}")
    }

    init{
        println("Hello world!")
    }
}