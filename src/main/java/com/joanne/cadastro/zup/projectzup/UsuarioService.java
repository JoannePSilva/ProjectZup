package com.joanne.cadastro.zup.projectzup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    RepositorioUsuario repositorioUsuario;

    @Autowired
    RepositorioCarro repositorioCarro;

    public void criarUsuario(Usuario user) {
        Usuario usuarioSalvo = repositorioUsuario.save(user);

    }

    public Usuario buscarUsuario(String id) {
        return repositorioUsuario.findById(Long.parseLong(id)).orElse(null);
    }

    public boolean criarCarro(Carro carro, String id) {
        Usuario usuario = buscarUsuario(id);
        if (usuario != null) {
            carro.setUsuario(usuario);
            repositorioCarro.save(carro);
            return true;
        }else{
            return false;
        }
    }
}
