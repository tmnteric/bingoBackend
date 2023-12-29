/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bingo.repository;

import com.bingo.model.User;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByEmail(String email);
    
    static final Logger logger = Logger.getLogger(UserRepository.class.getName());
    
    default Optional<User> findByEmailWithLogging(String email) {
        logger.info("Buscando usuario por email: " + email);
        Optional<User> user = findByEmail(email);
        if (user.isPresent()) {
            logger.info("Usuario encontrado: " + user.get().toString());
        } else {
            logger.info("Usuario no encontrado para el email: " + email);
        }
        return user;
    }
}