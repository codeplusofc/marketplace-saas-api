package com.market.saas;

import com.market.saas.model.UserEntity;
import com.market.saas.repository.UserRepository;
import com.market.saas.service.UserService;
import com.market.saas.validator.UserValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserValidator userValidator;

    @InjectMocks
    private UserService userService;

    @Test
    public void mustCreateUser() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setNome("Gui");
        user.setCpf("12345678911");
        user.setIdade(26);
        user.setEmail("gui@gmail.com");

        given(userRepository.save(user)).willReturn(user);

        UserEntity result = userService.createUser(user);

        assertEquals(1L, result.getId());
        assertEquals("Gui", result.getNome());
        assertEquals("12345678911", result.getCpf());
        assertEquals(26, result.getIdade());
        assertEquals("gui@gmail.com", result.getEmail());
    }
}
