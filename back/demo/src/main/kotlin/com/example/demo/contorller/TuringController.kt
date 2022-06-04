package com.example.demo.contorller

import com.example.demo.PATH
import com.example.demo.mt.MTRunning
import com.example.demo.mt.Steps
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.File
import javax.xml.crypto.Data


@RestController
class TuringController {

    //return a list of MT on directory mt-files
    @GetMapping("/list")
    fun getAllMT(): List<String> {
        val list = arrayListOf<String>()
        File(PATH).walk().forEach {
            if (it.name.endsWith(".txt")) {
                list.add(it.name)
            }
        }
        return list
    }

    //This api is used to start the MT whe @GetMapping("/start")
    @GetMapping("/startMT")
    fun startMT(
        @RequestParam("filename") fileName: String,
        @RequestParam("word") word: String
    ): Steps? {
        return MTRunning.startMT(fileName, word)
    }

    @GetMapping("/clearMT")
    fun clearMT(): String {
        MTRunning.clearMT()
        return ""
    }

    @GetMapping("/nextStepMT")
    fun nextStep(): Steps? {
        return MTRunning.nextStep()

    }

}