package br.com.ghabriel.forum.mapper

import br.com.ghabriel.forum.dto.TopicoForm
import br.com.ghabriel.forum.model.Topico
import br.com.ghabriel.forum.service.CursoService
import br.com.ghabriel.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
): Mapper<TopicoForm, Topico> {
    override fun map(t: TopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}
