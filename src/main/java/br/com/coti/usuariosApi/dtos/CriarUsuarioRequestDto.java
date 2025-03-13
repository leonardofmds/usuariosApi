package br.com.coti.usuariosApi.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CriarUsuarioRequestDto {

    @Size(min=8, max=150, message = "Por favor, informe um nome válido (entre 8 e 150 caracteres).")
    @NotEmpty(message = "Por favor, informe o nome do usuário.")
    private String nome;

    @Email(message = "Por favor, informe um email válido.")
    @NotEmpty(message = "Por favor, informe o email do usuário.")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$",
            message = "Por favor, informe a senha com letras minúsculas, maiúsculas, números, símbolos e pelos 8 caracteres")
    @NotEmpty(message = "Por favor, informe a senha do usuário.")
    private String senha;
}
