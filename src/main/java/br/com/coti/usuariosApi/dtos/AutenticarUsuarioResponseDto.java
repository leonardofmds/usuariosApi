package br.com.coti.usuariosApi.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class AutenticarUsuarioResponseDto {

    private UUID id;
    private String nome;
    private String email;
    private String perfil;
    private String token;
}
