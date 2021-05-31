package com.joanne.cadastro.zup.projectzup;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
public class Carro {

    private String marca;
    private String modelo;
    private String ano;
    private String placa;
    private Double preco;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "fk_id_usuario"))
    @JsonBackReference
    private Usuario usuario;
    public String getRodizio() {
        String ano = this.ano.substring(this.ano.length() - 1);
        switch (ano) {
            case "0":
            case "1":
                return "segunda-feira";
            case "2":
            case "3":
                return "terça-feira";
            case "4":
            case "5":
                return "quarta-feira";
            case "6":
            case "7":
                return "quinta-feira";
            case "8":
            case "9":
                return "sexta-feira";
            default:
                return null;
        }
    }

    public boolean getRodizioAtivo(){
        GregorianCalendar calendar = new GregorianCalendar();
        int dia = calendar.get(GregorianCalendar.DAY_OF_WEEK);
        String diaAtivo = getRodizio();
        switch (dia) {
            case 1:
            case 7 :
                return false;
            case 2:
                return (diaAtivo.equals("segunda-feira"));
            case 3:
                return (diaAtivo.equals("terça-feira"));
            case 4:
                return (diaAtivo.equals("quarta-feira"));
            case 5:
                return (diaAtivo.equals("quinta-feira"));
            case 6:
                return (diaAtivo.equals("sexta-feira"));
            default:
                return false;
        }
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public Carro(String marca, String modelo, String ano, String placa, Double preco, Long id, Usuario usuario) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.preco = preco;
        this.id = id;
        this.usuario = usuario;
    }

    public Carro() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
