package br.com.coti.usuariosApi.repositories;

import br.com.coti.usuariosApi.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, UUID> {

    @Query("select p from Perfil p where p.nome = :nome")
    Perfil findByNome(@Param("nome") String nome);


}
