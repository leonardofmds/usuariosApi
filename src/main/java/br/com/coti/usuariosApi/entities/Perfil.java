package br.com.coti.usuariosApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PERFIL")
public class Perfil {

    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NOME", length = 254, nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "perfil")
    private List<Usuario> usuarios;

}
