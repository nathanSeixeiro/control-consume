package consume.control.controllers;

import consume.control.Controller.UsuarioController;
import consume.control.Entity.Usuario.Usuario;
import consume.control.Entity.Usuario.UsuarioRecordDTO;
import consume.control.Repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
//import consume.control.Entity.Usuario.Usuario;
//import consume.control.Entity.Usuario.UsuarioRecordDTO;
//import consume.control.Repository.UsuarioRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
//import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioController usuarioController;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
    }

    @Test
    public void testRegisterUsuario() throws Exception {
        UsuarioRecordDTO usuarioRecordDTO = new UsuarioRecordDTO("John Doe", "john.doe@example.com");
        Usuario savedUsuario = new Usuario(usuarioRecordDTO);

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(savedUsuario);
        mockMvc.perform(post("/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(usuarioRecordDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists()); // valida pelo id
    }

    @Test
    public void testGetAllUsuarios() throws Exception {
        UsuarioRecordDTO user1Dto = new UsuarioRecordDTO( "John Doe", "john.doe@example.com");
        UsuarioRecordDTO user2Dto = new UsuarioRecordDTO("Jane Doe", "jane.doe@example.com");

        List<Usuario> usuarioList = Arrays.asList(
                new Usuario(user1Dto),
                new Usuario(user2Dto));

        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        mockMvc.perform(get("/usuario"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(usuarioList.size()));
    }

    @Test
    public void testDeleteUsuario() throws Exception {
        UsuarioRecordDTO usuarioRecordDTO = new UsuarioRecordDTO("John Doe", "john.doe@example.com");
        Usuario savedUsuario = new Usuario(usuarioRecordDTO);
        long usuarioId = savedUsuario.getId();

        doNothing().when(usuarioRepository).deleteById(usuarioId); // não tem dado de return
        mockMvc.perform(delete("/usuario/{id}", usuarioId))
                .andExpect(status().isOk());

        verify(usuarioRepository, times(1)).deleteById(usuarioId);
    }
}
