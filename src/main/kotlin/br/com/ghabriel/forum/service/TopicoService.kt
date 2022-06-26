package br.com.ghabriel.forum.service

import br.com.ghabriel.forum.dto.AtualizacaoTopicoForm
import br.com.ghabriel.forum.dto.TopicoForm
import br.com.ghabriel.forum.dto.TopicoView
import br.com.ghabriel.forum.mapper.TopicoFormMapper
import br.com.ghabriel.forum.mapper.TopicoViewMapper
import br.com.ghabriel.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(),
                    private val topicoViewMapper: TopicoViewMapper,
                    private val topicoFormMapper: TopicoFormMapper
) {



    fun listar(): List<TopicoView> {
        return topicos.stream().map{t -> topicoViewMapper.map(t)}.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: TopicoForm) {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm) {
        val topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()
        topicos = topicos.minus(topico).plus(Topico(
            id = form.id ,
            titulo = form.titulo,
            mensagem  = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        ))
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        topicos = topicos.minus(topico)
    }

}