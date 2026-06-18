/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Veterinario {
    private int id;
    private String nome;
    private String crmv;
    private String telefone;
    
    public Veterinario(int id, String nome, String crmv, String telefone) {
        this.id = id;
        this.nome = nome;
        this.crmv = crmv;
        this.telefone = telefone;
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
    
    public String getCrmv() {
        return this.crmv;
    }
    
    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
