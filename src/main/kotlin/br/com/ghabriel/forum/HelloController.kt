package br.com.ghabriel.forum

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/helllo")
class HelloController {

    @GetMapping
    fun hello(): String {
        return "Hello World"
    }
}