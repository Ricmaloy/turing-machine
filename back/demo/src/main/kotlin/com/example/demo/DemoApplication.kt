package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

val PATH = "C:\\Users\\ricar\\Documents\\www\\turing-machine\\back\\demo\\src\\main\\kotlin\\com\\example\\demo\\mt-files"

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
