package br.com.czo.api2.controller.exceptions;

import br.com.czo.api2.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ControllerExceptionHandlerTest {
    @InjectMocks
    private ControllerExceptionHandler exceptionHandleron;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenObjectNotFoundExceptionThenReturnAResponseEntity() {
        ResponseEntity<StandardError> response = exceptionHandleron
                .objectNotFound(new ObjectNotFoundException("Objeto não encontrado"),
                                 new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals("Objeto não encontrado", response.getBody().getError());
        assertEquals(404, response.getBody().getStatus());
        assertNotEquals("/user/2",response.getBody().getPath());
        assertNotEquals(LocalDateTime.now(),response.getBody().getTimestamp());
    }

    @Test
    void whenDataIntegrityViolationException() {
        ResponseEntity<StandardError> response = exceptionHandleron
                .dataIntegrityViolationException(new DataIntegrityViolationException("Email já cadastrado!"),
                        new MockHttpServletRequest());
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals("Email já cadastrado!", response.getBody().getError());
        assertEquals(400, response.getBody().getStatus());
    }
}