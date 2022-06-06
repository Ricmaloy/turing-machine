package com.example.demo.mt

class MaquinaTuring(
    val states: List<String>,
    val alphabet: List<Char>,
    val tapeAlphabet: List<Char>,
    val initialState: String,
    val acceptedState: List<String>,
    val whiteSymbol: Char,
    val transitions: Transitions,
) {

    private var tape: Tape? = null
    private var actualState = initialState

    fun startMT(word: String): Steps {
        tape = Tape(word, whiteSymbol, alphabet, tapeAlphabet, initialState)
        var isAccepted : Boolean ? = null
        if(tape?.wrongWord == true){
            isAccepted = false
        }
        return Steps(
            tape?.tape ?: arrayListOf(),
            tape?.actualPosition ?: 0,
            actualState,
            isAccepted,
            null
        )
    }

    fun nextStep(): Steps {
        val transition = transitions.rule["$actualState,${tape?.getActualSymbol()}"]
        val transitionString =
            "($actualState,${tape?.getActualSymbol()}) -> (${transition?.state},${transition?.symbol}, ${transition?.direction})"
        val isAccepted: Boolean?
        if (transition != null) {
            tape?.walkOnTape(transition.direction, transition.symbol)
            actualState = transition.state
            isAccepted = if (states.contains(actualState)) {
                null
            } else {
                false
            }
        } else {
            isAccepted = acceptedState.contains(actualState)
        }
        return Steps(
            tape?.tape ?: arrayListOf(),
            tape?.actualPosition ?: 0,
            actualState,
            isAccepted,
            transitionString
            )
    }

}

data class Steps(
    val tapeValue: ArrayList<Char>,
    val tapePosition: Int,
    val actualState: String,
    val isAccepted: Boolean?,
    val transition: String?
)