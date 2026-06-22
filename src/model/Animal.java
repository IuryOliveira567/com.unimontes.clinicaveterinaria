/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Animal {
    private int id;
    private String nome;
    private String sexo;
    private int idade;
    private int cliente_id;
    private String especie;

    
    public Animal() {}
    
    public Animal(String nome, String sexo, int idade, int cliente_id, String especie) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.cliente_id = cliente_id;
        this.especie = especie;
    }
    
    public Animal(int id, String nome, String sexo, int idade, int cliente_id, String especie) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.cliente_id = cliente_id;
        this.especie = especie;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEspecie() {
        return this.especie;
    }
    
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public int getIdade() {
        return this.idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    public int getClienteId() {
        return this.cliente_id;
    }
    
    public void setClienteId(int cliente_id) {
        this.cliente_id = cliente_id;
    }   
}
