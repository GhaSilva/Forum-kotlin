package br.com.ghabriel.forum.service

import br.com.ghabriel.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(var cursos: List<Curso>) {

    init {
        val curso1 = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )
        val curso2 = Curso(
            id = 2,
            nome = "Kotlin",
            categoria = "Programação"
        )
        cursos = Arrays.asList(curso1, curso2)
    }

    fun buscarPorId(id: Long): Curso{
        return cursos.stream().filter({
            c -> c.id == id
        }).findFirst().get()
    }

}
