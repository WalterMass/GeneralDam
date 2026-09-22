
package piedra_papel_tijera

import java.util.Scanner


class Match {
    companion object{
        val sc = Scanner(System.`in`)
    }

    private lateinit var results: Array<String>

    fun execute(){
        val playerPPT1 = Player_PPT("Player1", 0, PPT.EMPTY)
        val playerPPT2 = Player_PPT("CPU", 0, PPT.EMPTY)

        val notPlayed = "${playerPPT1.name} -- : ${playerPPT2.name} --"

        val rounds : Int = getRounds()
        results = Array(rounds) {notPlayed}

        val winner : Player_PPT? = play(playerPPT1, playerPPT2)

        if (winner == null){
            println("TOTAL DRAW! ${playerPPT1.playerScore()} : ${playerPPT2.playerScore()}")
        }else println("${winner.name} WINS! - ${winner.playerScore()}")

        showResults()
    }

    private fun play(playerPPT1 : Player_PPT, playerPPT2: Player_PPT): Player_PPT? {
        for (i in results.indices){
            playerPPT2.setMove(cpuRandomMove())
            println("CPU has: ${playerPPT2.getMove()}")
            playerPPT1.setMove(getMove())
            judgeResult(playerPPT1, playerPPT2, i)
        }

        return if (playerPPT1.score == playerPPT2.score){
            null
        } else{
            if (playerPPT1.score > playerPPT2.score){
                playerPPT1
            }else playerPPT2
        }
    }

    fun judgeResult(playerPPT1 : Player_PPT, playerPPT2 : Player_PPT, index: Int) {

        if (playerPPT1.getMove() == playerPPT2.getMove()){
            val draw = "${playerPPT1.playerScore()} : ${playerPPT2.playerScore()} - DRAW"
            results[index] = "Round_${index}: DRAW \n$draw"
            println(draw)
        } else if ( (playerPPT1.getMove() == PPT.ROCK && playerPPT2.getMove() == PPT.SCISSORS)
            || (playerPPT1.getMove() == PPT.PAPER && playerPPT2.getMove() == PPT.ROCK)
            || (playerPPT1.getMove() == PPT.SCISSORS && playerPPT2.getMove() == PPT.PAPER) )
        {
            playerPPT1.score++
            val mensajeVictoria1 = "${playerPPT1.playerScore()} : ${playerPPT2.playerScore()} - POINT FOR ${playerPPT1.name}"
            results[index] = "Round_${index}: ${playerPPT1.name} \n$mensajeVictoria1"
            println(mensajeVictoria1)
        }else if ((playerPPT2.getMove() == PPT.ROCK && playerPPT1.getMove() == PPT.SCISSORS)
            || (playerPPT2.getMove() == PPT.PAPER && playerPPT1.getMove() == PPT.ROCK)
            || (playerPPT2.getMove() == PPT.SCISSORS && playerPPT1.getMove() == PPT.PAPER)){
            playerPPT2.score++
            val mensajeVictoria2 = "${playerPPT1.playerScore()} : ${playerPPT2.playerScore()} - POINT FOR ${playerPPT2.name}"
            results[index] = "Round_${index}: ${playerPPT2.name}$mensajeVictoria2"
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
        println("\n\nMATCH RESULTS\n========================================================================")
        for (result in results){
            println(result)
        }
    }
}
