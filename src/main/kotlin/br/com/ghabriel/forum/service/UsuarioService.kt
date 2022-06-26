package br.com.ghabriel.forum.service

import br.com.ghabriel.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario1 = Usuario(
            id = 1,
            nome = "Ghabriel Silva",
            email = "ghabriel@ghabriel.com"
        )
        val usuario2 = Usuario(
            id = 2,
            nome = "Renato Lopes",
            email = "renato@renato.com"
        )
        usuarios = Arrays.asList(usuario1, usuario2)
    }

    fun buscarPorId(id: Long): Usuario{
        return usuarios.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }

}