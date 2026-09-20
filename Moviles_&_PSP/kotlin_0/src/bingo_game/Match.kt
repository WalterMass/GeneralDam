package bingo_game

import java.util.InputMismatchException
import java.util.Scanner
import java.io.File

class Match : Playable<Player_Bingo> {
    companion object{
        const val DRUM_SIZE = 20
        const val CARDBOARD_SIZE = 4
        val sc = Scanner(System.`in`)
        var number_of_players : Int = 0
    }

    override fun execute(){
        val players = ArrayList<Player_Bingo>()
        signInPlayers(players)
        play(players)
    }

    override fun play(players: ArrayList<Player_Bingo>) {

        for (i in players.indices){
            println("${players.get(i)} \n")
        }

        val drum = ArrayList<Int>()
        fillDrum(drum)

        val winners = Array<Boolean>(number_of_players) {false}

        var finish = false
        while(!drum.isEmpty() && !finish){
            val ballRemoved = drum.removeLast()
            println(ballRemoved)

            checkDrum(ballRemoved, players, winners)

            finish = checkWinners(winners, players)

            if (!finish){
                println("Press ENTER for the next round")
                sc.nextLine()
            }
        }

        showResults(players)

    }

    override fun showResults(players: ArrayList<Player_Bingo>) {
        //todo needs to be reviewed
        val rankingAddedPlayers : ArrayList<Player_Bingo> = players
            .filterTo(ArrayList()){ it.score > 0 }
            .apply { sortByDescending { it.score }}

        val ranking : MutableMap<Int, Player_Bingo> = rankingAddedPlayers.associateBy {
            it.score
        } as MutableMap<Int, Player_Bingo>

        pullWinningPlayers(ranking)
        saveWinningPlayers(ranking)
        println("\n\nRANKINGS\n")
        ranking.forEach {
            println("${it.value.id} ${it.value.userName} ${it.key}")
        }


    }

    fun pullWinningPlayers(ranking: MutableMap<Int, Player_Bingo>): Map <Int, Player_Bingo>{
        val directory = File("src/files_bingo")
        val file = File (directory, "players.txt")

        if (!file.exists()){
            println("The file players.txt does not exist: ${directory.absolutePath}")
            return ranking
        }

        file.useLines { lines ->
            lines.forEach { line ->
                if (line.isNotBlank()){
                    val atributs = line.split("|").map { it.trim() }

                    if (atributs.size >= 3) {
                        val id = atributs[0]
                        val userName = atributs[1]
                        val key : Int = Integer.parseInt(atributs[2])

                        val p = Player_Bingo(id, userName, key)
                        ranking[key] = p
                    }

                }
            }

        }

        return ranking

    }

    fun saveWinningPlayers(addedWinners: MutableMap<Int, Player_Bingo>){
        val directory = File("src/files_bingo")
        val file = File(directory, "players.txt")

        try {
            if (!directory.exists()){
                val created  = directory.mkdir()
                if (created){
                    println("files_bingo directory created successfully")
                }
            }

            file.bufferedWriter().use { writer ->
                addedWinners.forEach { (key, player) ->
                    writer.write("${player.id} | ${player.userName} | $key")
                    writer.newLine()
                }
            }
            println("Data saved successfully: ${directory.absolutePath}")

        }catch(e: Exception){
            println("Something went wrong while saving players.txt")
        }
    }

    fun checkWinners(winners: Array<Boolean>, players: ArrayList<Player_Bingo>): Boolean{
        var value = false
        for (i in winners.indices){
            if (winners[i] == true){
                players.get(i).score++
                value = true
            }
        }
        return value
    }

    fun checkDrum(ballRemoved : Int, players : ArrayList<Player_Bingo>, winners : Array<Boolean>){
        for (i in players.indices){
            for (j in players.get(i).cards.indices){
                val conteinsBall = players.get(i).cards.get(j).checkBall(ballRemoved)
                val winner = players.get(i).cards.get(j).numbers.isEmpty()
                if (conteinsBall){
                    println("${players.get(i).userName} - ${players.get(i).cards.get(j)}")
                    if (winner){
                        println("${players.get(i).userName} has a winning cardboard")
                        winners[i] = true
                    }
                }
            }
        }
    }

    fun fillDrum(drum : ArrayList<Int>){
        while(drum.size < DRUM_SIZE){
            val rand = (1..20).random()
            if (!drum.contains(rand)){
                drum.add(rand)
            }
        }
    }

    private fun signInPlayers(players : MutableList<Player_Bingo>){
        println("Type how many players will be in this match:")
        number_of_players = getInt()
        for (i in 0..<number_of_players){
            addPlayer(players, i)
        }


    }

    private fun addPlayer(players: MutableList<Player_Bingo>, index: Int){
        //update the local variable to have a reference on the id of the players
        Player_Bingo.playerBingoIndex++

        val id = "P-"+Player_Bingo.playerBingoIndex
        val userName = getString()
        val cardboards = generateCardboards(id)

        val player = Player_Bingo(id, userName, 0, cardboards)
        players.add(player)
    }

    fun generateCardboards(id: String): Array<Cardboard> {
        println("How many cardboards do you want for this match?")
        val n = getInt()
        return Array(n) {
            val numberList = ArrayList<Int>()

            while(numberList.size < CARDBOARD_SIZE){
                val rand = (1..20).random()
                if (!numberList.contains(rand)){
                    numberList.add(rand)
                }
            }
            Cardboard.cardboardIndex++
            val codeString = "CB-${Cardboard.cardboardIndex}"
            Cardboard(
                code = codeString,
                player = id,
                numbers = numberList
            )
        }
    }

    fun getString(): String{
        val errorMessage = " something went wrong, try again"
        while(true){
            try{
                println("Type your username")
                val name = sc.nextLine()
                return name
            }catch (e : NoSuchElementException){
                println("{$e}: $errorMessage")
            }
        }
    }

    fun getInt(): Int {
        /*
         podrán jugar entre 1 y N Jugadores.
        */
        val negativeNumberMessage = "The number can not be equal to 0, negative"
        val notANumberMessage = "Try again, can not contain letters or any special characters"
        var num: Int
        while(true){
            try {
                num = sc.nextInt()
                sc.nextLine()
                if (num <= 0){
                    throw InputMismatchException(negativeNumberMessage)
                }
                return num
            }catch(e: InputMismatchException){
                if (!e.message.equals(negativeNumberMessage)){
                    println("${e}: $notANumberMessage")
                }else println("${e}: ${e.message}")
                sc.nextLine()
            }
        }
    }
}