package bingo_game

class PlayerBingo(id : String, userName: String, score: Int, val cards : Array<Cardboard>) : Player(id, userName, score){
    constructor(id: String, userName: String, score: Int) : this(
        id = id,
        userName = userName,
        score = score,
        cards = emptyArray()
    )
    companion object{
        var playerBingoIndex = 0
    }

    override fun toString(): String {
        var cardString = "Null"

        if (cards.isNotEmpty()){
            cardString = cards.joinToString("\n")
        }
        return "$id - $userName - score: ${score}\n${cardString}"
    }


}