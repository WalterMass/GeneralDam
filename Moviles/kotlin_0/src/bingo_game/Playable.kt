package bingo_game

interface Playable<T : Player> {
    fun execute(){}
    fun play(players: ArrayList<T>){

    }
    fun showResults(players: ArrayList<T>){

    }
}