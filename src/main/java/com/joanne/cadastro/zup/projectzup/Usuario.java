package com.joanne.cadastro.zup.projectzup;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Usuario {

    private String nome;
    private String email;
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDeNascimento;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idUsuario;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "fk_id_usuario"))
    @JsonManagedReference
    private List<Carro> listaDeCarros = new ArrayList<>();

    public Usuario(String nome, String email, String cpf, Date dataDeNascimento, Long idUsuario, List<Carro> listaDeCarros) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.idUsuario = idUsuario;
        this.listaDeCarros = listaDeCarros;
    }

    public Usuario() {
    }

    public void setId(Long idUsuario) {
        this.idUsuario = idUsuario;
    }


    public Long getId() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
