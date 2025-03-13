package br.com.coti.usuariosApi.dtos;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class CriarUsuarioResponseDto {

    private UUID id;
    private String nome;
    private String email;
    private Instant dataCriacao;
    private String perfil;
}
