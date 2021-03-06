package com.example.demo.mt

import java.io.File
import java.io.FileNotFoundException
import java.util.*
import kotlin.collections.ArrayList

/**
 * Formato arquivo
 * , (splitter interno)
 * ; (splitter externo)
 * q0;q1;q2;q3 (conjunto de estados)
 * a;b;c;d;e;f;g (alfabeto)
 * a;b;c;d;e;f;g;X;Y;Y (alfabeto fita)
 * q0 (estado inicial)
 * q2;q3 (estados de aceitação)
 * $ (simbolo branco)
 * (q0,a)->(q1,a,d);(q0,a)->(q1,a,d);(q0,a)->(q1,a,d) (função transição)
 */

//Para o alfabeto aceitar
class MTFactory {

    private var externalSplitter = ""
    private var innerSplitter = ""
    lateinit var mt: MaquinaTuring

    constructor(fileName: String) {
        val file = File(fileName)
        try {
            Scanner(file).use { scanner ->
                innerSplitter = scanner.next()
                externalSplitter = scanner.next()
                val states = generateStates(scanner.next())
                val alphabet = generateAlphabet(scanner.next())
                val tapeAlphabet = generateAlphabet(scanner.next())
                val q0 = scanner.next()
                val qAccepted = generateStates(scanner.next())
                val whiteSymbol = scanner.next().toCharArray()[0]
                val transition = generateTransition(scanner.next())
                mt = MaquinaTuring(
                    states,
                    alphabet,
                    tapeAlphabet,
                    q0,
                    qAccepted,
                    whiteSymbol,
                    transition
                )
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }

    private fun generateStates(states: String) = states.split(externalSplitter)

    private fun generateAlphabet(alphabet: String): ArrayList<Char> {
        val aux = alphabet.split(externalSplitter)
        val alphabetSymbols = arrayListOf<Char>()
        aux.forEach {
            alphabetSymbols.add(it[0])
        }
        return alphabetSymbols
    }

    private fun generateTransition(transition: String): Transitions {
        val aux = transition.split(externalSplitter)
        val transitions = Transitions()
        aux.forEach {
            val split = it.split("->")
            transitions.rule[getEntry(split[0])] = getOutput(split[1])
        }
        return transitions
    }

    private fun getEntry(entry: String): String {
        var input = entry.removePrefix("(")
        input = input.removeSuffix(")")
        return input
    }

    private fun getOutput(entry: String): TransitionOutput {
        var input = entry.removePrefix("(")
        input = input.removeSuffix(")")
        val inputValues = input.split(innerSplitter)
        return TransitionOutput(inputValues[0], inputValues[1][0], inputValues[2][0])
    }
}

