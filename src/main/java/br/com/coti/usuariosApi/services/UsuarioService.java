package br.com.coti.usuariosApi.services;

import br.com.coti.usuariosApi.components.JwtTokenComponent;
import br.com.coti.usuariosApi.components.SHA256Component;
import br.com.coti.usuariosApi.dtos.AutenticarUsuarioRequestDto;
import br.com.coti.usuariosApi.dtos.AutenticarUsuarioResponseDto;
import br.com.coti.usuariosApi.dtos.CriarUsuarioRequestDto;
import br.com.coti.usuariosApi.dtos.CriarUsuarioResponseDto;
import br.com.coti.usuariosApi.entities.Usuario;
import br.com.coti.usuariosApi.repositories.PerfilRepository;
import br.com.coti.usuariosApi.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired UsuarioRepository usuarioRepository;
    @Autowired PerfilRepository perfilRepository;
    @Autowired SHA256Component sha256Component;
    @Autowired JwtTokenComponent jwtTokenComponent;


    public CriarUsuarioResponseDto criarUsuario(CriarUsuarioRequestDto request){

        if(usuarioRepository.findbyEmail(request.getEmail())!=null){
            throw new IllegalArgumentException("O email informado já encontra-se cadastrado.");
        }

        var usuario = new Usuario();
        BeanUtils.copyProperties(request, usuario);
        usuario.setPerfil(perfilRepository.findByNome("OPERADOR"));
        usuario.setSenha(sha256Component.encrypt(request.getSenha()));

        var response = new CriarUsuarioResponseDto();
        BeanUtils.copyProperties(usuarioRepository.save((usuario)), response);
        response.setDataCriacao(Instant.now());
        response.setPerfil(usuario.getPerfil().getNome());

        return response;
    }

    public AutenticarUsuarioResponseDto autenticarUsuario(AutenticarUsuarioRequestDto request){

        var usuario = usuarioRepository.findByEmailAndSenha(request.getEmail(), sha256Component.encrypt(request.getSenha()));

        if(usuario == null){
            throw new IllegalArgumentException("Usuário e/ou senha inválidos.");
        }

        var response = new AutenticarUsuarioResponseDto();
        BeanUtils.copyProperties(usuario, response);
        response.setPerfil(usuario.getPerfil().getNome());
        response.setToken(jwtTokenComponent.getToken(usuario));

        return response;
    }



}
