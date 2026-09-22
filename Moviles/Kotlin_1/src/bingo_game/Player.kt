package bingo_game

open class Player (val id:String, var userName : String, var score : Int){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Player

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }



}