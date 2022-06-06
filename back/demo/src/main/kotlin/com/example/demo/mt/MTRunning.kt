package com.example.demo.mt

import com.example.demo.PATH

object MTRunning {
    var mt : MaquinaTuring? = null

    fun startMT(fileName : String, word : String) : Steps?{
        val factory = MTFactory("$PATH\\$fileName" )
        mt = factory.mt
        return mt?.startMT(word)
    }

    fun clearMT() {
        mt = null
    }

    fun nextStep() = mt?.nextStep()


}