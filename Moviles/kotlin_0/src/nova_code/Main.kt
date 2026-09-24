package nova_code

fun main(){
    val heroAcademy = HeroAcademy()
//    heroAcademy.exe()

//    val numeros =  listOf(1,2,3,4,5)
//    val cuadrados = numeros.map {
//        it * it
//    }
//
//    val mapa = mapOf("Ana" to 15, "Pedro" to 20)
//    mapa.map { println("${it.value} : ${it.key}") }
//    mapa.map { println("${it.component1()} : ${it.component2()}") }
    val resultado = operarLista(listOf(1,2,3)){it*10}

}
fun operarLista(lista: List<Int>, op: (Int) -> Int):
        List<Int> {
    return lista.map { op(it) }
}