package com.market.saas.validator;

import com.market.saas.exception.BadRequestException;
import com.market.saas.model.UserEntity;

public class UserValidator {

    public static void validateUserFields(UserEntity userEntity) {
        validationUserName(userEntity.getNome());
        validatorCpf(userEntity.getCpf());
        validatorEmail(userEntity.getEmail());
    }

    public static void validationUserName(String username) {
        if (username.length() < 2 || username.length() > 100) {
            throw new BadRequestException("Digite seu nome corretamente!");
        }
        if (username.matches(".*\\d.*")) {
            throw new BadRequestException("Nome inválido! Caracteres especiais não são permitidos.");
        } if (username.isEmpty()){
            throw new BadRequestException("O campo nome não pode estar vazio!");
        }
    }

    public static void validatorCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new BadRequestException("O campo de CPF não pode ser inválido ou nulo");
        }
        if (!cpf.matches("\\d{11}")) {
            throw new BadRequestException("O campo Cpf deve conter apenas 11 digitos!");

        }
    }

    public static void validatorEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new BadRequestException("O campo email não pode ser inválido ou nulo");
        }
        if (!email.endsWith("gmail.com")) {
            throw new BadRequestException("O campo email deve terminar com @gmail.com");
        }
    }

}
