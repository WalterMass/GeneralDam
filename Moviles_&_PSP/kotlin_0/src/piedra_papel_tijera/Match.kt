package piedra_papel_tijera

import java.util.Scanner

class Match {
    companion object{
        val sc = Scanner(System.`in`)
    }

    private lateinit var results: Array<String>

    fun execute(){
        val player1 = Player("Player1", 0, PPT.EMPTY)
        val player2 = Player("CPU", 0, PPT.EMPTY)

        val notPlayed : String = "${player1.name} -- : ${player2.name} --"

        val rounds : Int = getRounds()
        results = Array(rounds) {notPlayed}

        val winner : Player? = play(player1, player2)

        if (winner == null){
            println("TOTAL DRAW! ${player1.playerScore()} : ${player2.playerScore()}")
        }else println("${winner.name} WINS! - ${winner.playerScore()}")

        showResults()
    }

    private fun play(player1 : Player, player2: Player): Player? {
        for (i in 0 until results.size){
            player2.setMove(cpuRandomMove())
            println("CPU has: ${player2.getMove()}")
            player1.setMove(getMove())
            judgeResult(player1, player2, i)
        }

        if (player1.score == player2.score){
            return null
        } else{
            if (player1.score > player2.score){
                return player1
            }else return player2
        }
    }

    fun judgeResult(player1 : Player, player2 : Player, index: Int) {

        if (player1.getMove() == player2.getMove()){
            val draw = "${player1.playerScore()} : ${player2.playerScore()} - DRAW"
            results[index] = "Round_${index}: DRAW \n$draw"
            println(draw)
        } else if ( (player1.getMove() == PPT.ROCK && player2.getMove() == PPT.SCISSORS)
            || (player1.getMove() == PPT.PAPER && player2.getMove() == PPT.ROCK)
            || (player1.getMove() == PPT.SCISSORS && player2.getMove() == PPT.PAPER) )
        {
            player1.score++
            val mensajeVictoria1 = "${player1.playerScore()} : ${player2.playerScore()} - POINT FOR ${player1.name}"
            results[index] = "Round_${index}: ${player1.name} \n$mensajeVictoria1"
            println(mensajeVictoria1)
        }else if ((player2.getMove() == PPT.ROCK && player1.getMove() == PPT.SCISSORS)
            || (player2.getMove() == PPT.PAPER && player1.getMove() == PPT.ROCK)
            || (player2.getMove() == PPT.SCISSORS && player1.getMove() == PPT.PAPER)){
            player2.score++
            val mensajeVictoria2 = "${player1.playerScore()} : ${player2.playerScore()} - POINT FOR ${player2.name}"
            results[index] = "Round_${index}: ${player2.name}$mensajeVictoria2"
            println(mensajeVictoria2)

        }
    }

    private fun getRounds(): Int {
        while (true){
            try {
                println("How many rounds do you want to play?")
                val rounds = sc.nextLine().trim()
                if (rounds.toInt() <= 0){
                    throw NumberFormatException("you used characters different from 0-9 digits")
                }

                return rounds.toInt()

            }catch (e: NumberFormatException){
                println(e)
            }
        }
    }

    fun getMove(): PPT {
        println("YOUR TURN!")

        while (true) {
            try {
                println("Rock -> R, Paper -> P, Scissors -> S")
                val move = sc.nextLine().trim().uppercase()

                return when (move) {
                    "R" -> PPT.ROCK
                    "P" -> PPT.PAPER
                    "S" -> PPT.SCISSORS
                    else -> throw NotContemplatedOptionException("Not a valid option between [R, P, S]")
                }

            } catch (e: NotContemplatedOptionException) {
                println(e.message)
            }
        }
    }

    private fun cpuRandomMove(): PPT{
        val rand = (1..3).random()
        return when(rand){
            1 -> PPT.ROCK
            2 -> PPT.PAPER
            3 -> PPT.SCISSORS
            else -> PPT.ROCK
        }
    }

    fun showResults(){
        println("\n\nMATCH RESULTS\n\n")
        for (result in results){
            println(result)
        }
    }
}