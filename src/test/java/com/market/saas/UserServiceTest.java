package com.market.saas;

import com.market.saas.model.UserEntity;
import com.market.saas.repository.UserRepository;
import com.market.saas.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

//MOCKITO É UTILIZADO PARA SIMULAR OBJETOS E ETC
//JUNIT É FOCADO EM TUDO QUE É RELACIONADO A ESTRUTURA, OU SEJA COMPARAR DADOS, ESTRUTURAR OS TESTES E ETC
//TESTE DE SUCESSO E TESTE DE FALHA
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void mustCreateUser() {
        //CRIAR UM OBJETO QUE SERÁ USADO PARA TESTAR A FUNÇÃO
        UserEntity userEntity = mock(UserEntity.class);

        //ALTERAR OS VALORES DESSE OBJETO
        given(userEntity.getId()).willReturn(1L);
        given(userEntity.getNome()).willReturn("Gui");
        given(userEntity.getCpf()).willReturn("1234");
        given(userEntity.getIdade()).willReturn(26);

        //CRIAR SIMULAÇÕES DE COMPORTAMENTOS DESSA FUNÇÃO QUE ESTAMOS TESTANDO
        given(userRepository.save(userEntity)).willReturn(userEntity);

        //SALVAR O RETORNO DO RESULTADO EM UMA VARIAVEL
        UserEntity result = userService.createUser(userEntity);

        //COMPARAR VALORES
        assertEquals(1L, result.getId());
        assertEquals("Gui", result.getNome());
        assertEquals("1234", result.getCpf());
        assertEquals(26, result.getIdade());
    }
}
