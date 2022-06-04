class Tape(
    word: String,
    whiteSymbol: Char,
    val acceptedSymbols: List<Char>,
    var actualState: String = ""

) {

    private var size: Int = 0
    var tape: ArrayList<Char> = arrayListOf()
    var actualPosition = 0

    init {
        size = word.length + 1
        word.forEach {
            tape.add(it)
        }
        tape.add(whiteSymbol)
    }

    fun printTape(): String {
        var aux = ""
        tape.forEachIndexed { index, c ->
            if (index == actualPosition) {
                aux += actualState
            }
            aux += c
        }
        return aux
    }

    fun walkOnTape(direction: Char, symbolToWrite: Char) {
        if (direction == 'R' || direction == 'r' || direction == 'D' || direction == 'd') {
            walkToRight(symbolToWrite)
        }
        if (direction == 'L' || direction == 'l' || direction == 'E' || direction == 'e') {
            walkToLeft(symbolToWrite)
        }
    }

    private fun walkToRight(symbolToWrite: Char) {
        if (symbolIsValid(symbolToWrite)) {
            tape[actualPosition] = symbolToWrite
            if(canWalkToRight()) {
                actualPosition++
            }
        }
    }

    private fun walkToLeft(symbolToWrite: Char) {
        if (symbolIsValid(symbolToWrite)) {
            tape[actualPosition] = symbolToWrite
            if (canWalkToLeft()) {
                actualPosition--
                //todo esquerad n infinita
            }
        }
    }

    private fun canWalkToLeft() = actualPosition != 0
    private fun canWalkToRight() = actualPosition < size - 1

    private fun symbolIsValid(symbolToWrite: Char) = acceptedSymbols.contains(symbolToWrite)

    fun getActualSymbol() = tape[actualPosition]
}