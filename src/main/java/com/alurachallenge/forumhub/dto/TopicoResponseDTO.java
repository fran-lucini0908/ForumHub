package com.alurachallenge.forumhub.dto;


import com.alurachallenge.forumhub.entity.StatusTopico;
import com.alurachallenge.forumhub.entity.Topico;
import java.time.LocalDateTime;
import java.util.List;

public record TopicoResponseDTO(

        Long id,
        String titulo,
        String mensagem,
        String autor,
        String curso,
        LocalDateTime criacao,
        StatusTopico status,
        List<RespostaResponseDTO> respostas
) {

    public TopicoResponseDTO(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor().getUsername(),
                topico.getCurso(),
                topico.getCriacao(),
                topico.getStatus(),
                topico.getResposta().stream()
                        .map(r -> new RespostaResponseDTO(
                                r.getId(),
                                r.getMensagem(),
                                r.getAutor().getUsername(),
                                r.getCriacao()
                        ))
                        .toList()
        );
    }

}
