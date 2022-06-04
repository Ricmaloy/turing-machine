package com.example.demo.mt

import Tape

class MaquinaTuring(
    val states: List<String>,
    val alphabet: List<Char>,
    val tapeAlphabet: List<Char>,
    val initialState: String,
    val acceptedState: List<String>,
    val whiteSymbol: Char,
    val transitions: Transitions,
) {

    private var tape : Tape? = null
    private var actualState = initialState

    fun startMT(word: String){
        tape = Tape(word,whiteSymbol, tapeAlphabet,initialState)
    }

    fun nextStep() : Steps{
        val transition = transitions.rule["$actualState,${tape?.getActualSymbol()}"]
        val isAccepted : Boolean?
        if(transition != null){
            tape?.walkOnTape(transition.direction, transition.symbol)
            actualState = transition.state
            isAccepted = null
        }else{
            isAccepted = acceptedState.contains(actualState)
        }
        return Steps(
            tape?.tape ?: arrayListOf(),
            tape?.actualPosition ?: 0,
            actualState,
            isAccepted,
            "//todo criar a string de transition"
        )
    }

}

data class Steps(
    val tapeValue : ArrayList<Char>,
    val tapePosition : Int,
    val actualState: String,
    val isAccepted : Boolean?,
    val transition : String?
)