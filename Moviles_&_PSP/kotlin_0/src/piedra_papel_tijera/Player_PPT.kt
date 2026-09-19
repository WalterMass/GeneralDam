package piedra_papel_tijera

class Player_PPT (val name : String, var score : Int, private var move : PPT) {
    fun setMove(ppt: PPT){
        move = ppt
    }
    fun getMove(): PPT{
        return move
    }

    fun playerScore() : String{
        return "$name - $score pts"
    }


    override fun toString(): String {
        return "Jugador: $name ; Puntuacion: $score ; Movimiento: $move)"
    }
}