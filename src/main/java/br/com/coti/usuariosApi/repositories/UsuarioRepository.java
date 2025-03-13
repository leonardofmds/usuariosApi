package br.com.coti.usuariosApi.repositories;

import br.com.coti.usuariosApi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    @Query("select u from Usuario u where u.email = :email")
    Usuario findbyEmail(@Param("email") String email);

    @Query("select u from Usuario u where u.email = :email and u.senha = :senha")
    Usuario findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);
}
