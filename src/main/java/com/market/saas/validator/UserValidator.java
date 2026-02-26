package com.market.saas.validator;

import com.market.saas.exception.StatusException;
import com.market.saas.model.UserEntity;
import jakarta.validation.constraints.Email;

import java.beans.Transient;
import java.util.regex.Pattern;


public class UserValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");;

    public static void validate(UserEntity userEntity) {
    }

    public void username (String username ) {
        if (username.length() < 5) {
            throw new IllegalArgumentException("Digite seu nome corretamente");
        }
            if (username.matches(".*\\d.*")) {
                System.out.println(" Nome inválido! Números não são permitidos.");
            } else if (username.trim().isEmpty()) {
                System.out.println(" O nome não pode estar vazio.");
            } else {
                System.out.println("✅ Nome aceito: " + username);
        }
    }

    public void validatorCpf (String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPf invalido ou nulo");
        }
            if (! cpf.matches("\\d{11}")){

                throw new IllegalArgumentException("cpf deve conter apenas 11 digitos");

            }

    }
    public void validatorEmail (String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email invalido ou nulo");
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Email inválido.");
    }
   }
    
}
