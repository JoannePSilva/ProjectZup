package com.joanne.cadastro.zup.projectzup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
