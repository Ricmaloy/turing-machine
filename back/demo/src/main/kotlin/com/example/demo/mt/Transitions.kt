package com.example.demo.mt

class Transitions {
   val rule: HashMap<String, TransitionOutput> = hashMapOf()
}


data class TransitionOutput(
    val state: String,
    val symbol: Char,
    val direction: Char,
)