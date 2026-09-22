package bingo_game

class Cardboard (val code: String, val player: String, val numbers: ArrayList<Int>){

    companion object{
        var cardboardIndex = 0
    }

    fun checkBall(num : Int): Boolean{
        if (numbers.contains(num)){
            numbers.remove(num)
            return true
        }else return false
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cardboard

        if (code != other.code) return false
        if (player != other.player) return false
        if (numbers != other.numbers) return false

        return true
    }

    override fun hashCode(): Int {
        var result = code.hashCode()
        result = 31 * result + player.hashCode()
        result = 31 * result + numbers.hashCode()
        return result
    }


    override fun toString(): String {
        val numString = numbers.joinToString( ", ")
        return "Cardboard: $code - player: $player - numbers[$numString]"
    }


}