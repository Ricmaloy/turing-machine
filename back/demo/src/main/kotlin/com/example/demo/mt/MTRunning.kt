package com.example.demo.mt

import com.example.demo.PATH

object MTRunning {
    var mt : MaquinaTuring? = null

    fun startMT(fileName : String){
        val factory = MTFactory("$PATH\\$fileName" )
        mt = factory.mt
    }

    fun clearMT() {
        mt = null
    }

    fun nextStep(): Steps? {
        return mt?.nextStep()
    }


}