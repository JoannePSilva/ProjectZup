package com.joanne.cadastro.zup.projectzup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping
    public ResponseEntity<?> cadastroUsuario(@RequestBody Usuario user) {
        service.criarUsuario(user);
        return new ResponseEntity<> (HttpStatus.CREATED);
    }

    @PostMapping("/{id}/carro")
    public ResponseEntity<?> cadastroCarro(@RequestBody Carro car, @PathVariable String id) {
        boolean resultado = service.criarCarro(car, id);

        if(resultado)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<String>("Usuário não encontrado", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> Usuario(@PathVariable String id) {
        Usuario usuario = service.buscarUsuario(id);
        if(usuario == null){
            return new ResponseEntity<String>("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

    }

}