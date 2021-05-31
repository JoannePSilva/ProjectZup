package com.joanne.cadastro.zup.projectzup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface RepositorioCarro extends JpaRepository<Carro, Long> {

}
