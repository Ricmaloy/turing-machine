package com.example.demo.mt

class Tape(
    word: String,
    whiteSymbol: Char,
    val alphabet: List<Char>,
    val acceptedSymbols: List<Char>,
    var actualState: String = ""
) {

    private var size: Int = 0
    var tape: ArrayList<Char> = arrayListOf()
    var actualPosition = 1
    var wrongWord = false
    init {
        size = word.length + 2
        tape.add(whiteSymbol)
        word.forEach {
            if(alphabet.contains(it)){
                tape.add(it)
            }
            else{
                wrongWord = true
            }
        }
        tape.add(whiteSymbol)
    }

    fun walkOnTape(direction: Char, symbolToWrite: Char) {
        if (direction == 'R') {
            walkToRight(symbolToWrite)
        }
        if (direction == 'L') {
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
            }
        }
    }

    private fun canWalkToLeft() = actualPosition != 0
    private fun canWalkToRight() = actualPosition < size - 1

    private fun symbolIsValid(symbolToWrite: Char) = acceptedSymbols.contains(symbolToWrite)

    fun getActualSymbol() = tape[actualPosition]
}