/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bingo.model;

//import jakarta.persistence.*;
//import jakarta.persistence.Entity;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

     private static final Logger logger = Logger.getLogger(User.class.getName());
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public boolean verificarCredenciales(String email, String password) {
        logger.info("Verificando credenciales para el usuario con email: " + email);
        
        boolean credencialesValidas = this.email.equals(email) && this.password.equals(password);

        if (credencialesValidas) {
            logger.info("Credenciales válidas para el usuario con email: " + email);
        } else {
            logger.warning("Credenciales inválidas para el usuario con email: " + email);
        }

        return credencialesValidas;
    }

}
