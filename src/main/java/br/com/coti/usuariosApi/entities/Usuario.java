package br.com.coti.usuariosApi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NOME", length = 150, nullable = false)
    private String nome;

    @Column(name = "EMAIL", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "SENHA", length = 100, nullable = false)
    private String senha;


    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;

}