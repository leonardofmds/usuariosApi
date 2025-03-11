package br.com.coti.usuariosApi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Operation(summary = "Endpoint para cadastrar um novo usuário")
    @PostMapping("/cadastrar")
    public void criar(){
        //TODO
    }

    @Operation(summary = "Endpoint para autenticar um usuário")
    @PostMapping("/autenticar")
    public void autenticar(){
        //TODO
    }

}
