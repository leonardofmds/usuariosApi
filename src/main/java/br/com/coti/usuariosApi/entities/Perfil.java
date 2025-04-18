package br.com.coti.usuariosApi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_perfil")
public class Perfil {

    @Id
    private UUID id;

    @Column(name = "NOME", length = 254, nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "perfil")
    private List<Usuario> usuarios;

}
