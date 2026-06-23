/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.LoginDAO;
import model.Usuario;
/**
 *
 * @author admin
 */
public class LoginController {
    private LoginDAO loginDAO;
    
    public LoginController() {
        this.loginDAO = new LoginDAO();
    }
    
    public Usuario AutenticaUsuario(String login, String senha) {
        return loginDAO.Autentica(login, senha);
    }
}
