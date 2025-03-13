package br.com.coti.usuariosApi.components;

import java.util.UUID;

import br.com.coti.usuariosApi.entities.Perfil;
import br.com.coti.usuariosApi.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDataComponent implements ApplicationRunner {
    //Atributos para injeção de dependência
    @Autowired
    PerfilRepository perfilRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var perfilOperador = new Perfil();
        perfilOperador.setId(UUID.fromString("90207052-09b5-4827-b071-479a943a261c"));
        perfilOperador.setNome("OPERADOR");

        var perfilAdministrador = new Perfil();
        perfilAdministrador.setId(UUID.fromString("f4e0b0d3-1a5d-4e1e-8b5c-3b3f2f4f5f7e"));
        perfilAdministrador.setNome("ADMINISTRADOR");

        perfilRepository.save(perfilOperador);
        perfilRepository.save(perfilAdministrador);
    }
}


