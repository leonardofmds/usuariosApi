package br.com.coti.usuariosApi.controllers;

import br.com.coti.usuariosApi.dtos.AutenticarUsuarioRequestDto;
import br.com.coti.usuariosApi.dtos.AutenticarUsuarioResponseDto;
import br.com.coti.usuariosApi.dtos.CriarUsuarioRequestDto;
import br.com.coti.usuariosApi.dtos.CriarUsuarioResponseDto;
import br.com.coti.usuariosApi.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Operation(summary = "Endpoint para cadastrar um novo usuário")
    @PostMapping("/criar")
    public ResponseEntity<CriarUsuarioResponseDto> criar(@RequestBody @Valid CriarUsuarioRequestDto request){

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(request));
    }

    @Operation(summary = "Endpoint para autenticar um usuário")
    @PostMapping("/autenticar")
    public ResponseEntity<AutenticarUsuarioResponseDto> autenticar(@RequestBody @Valid AutenticarUsuarioRequestDto request){

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.autenticarUsuario(request));
    }

}
