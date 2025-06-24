package usuario.src.test.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UsuarioController.class)
@AutoConfigureMockMvc(addFilters = false)

public class UsuarioControllerTest {
    
    @MockBean
    private UsuarioService usuarioService;

    @MockBean
    private CategoriaService categoriaService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllUsuarios() throws Exception {    
        Usuario usuario1 = new Usuario(1L, "user1", "password1");
        Usuario usuario2 = new Usuario(2L, "user2", "password2");
        when(usuarioService.findAllUsuarios()).thenReturn(Arrays.asList(usuario1, usuario2));
        mockMvc.perform(get("/usuarios"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1L))
            .andExpect(jsonPath("$[0].username").value("user1"))
            .andExpect(jsonPath("$[1].id").value(2L))
            .andExpect(jsonPath("$[1].username").value("user2"));
        }


    @Test
    void testGetUsuarioById() throws Exception {
        Usuario usuario = new Usuario(1L, "user1", "password1");
        when(usuarioService.findUsuarioById(1L)).thenReturn(Optional.of(usuario));
        mockMvc.perform(get("/usuarios/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.username").value("user1"));
    }   

    @Test
    void testCreateUsuario() throws Exception {
        Usuario usuario = new Usuario(1L, "user1", "password1");
        when(usuarioService.saveUsuario(any(Usuario.class))).thenReturn(usuario);
        mockMvc.perform(post("/usuarios")
            .contentType("application/json")
            .content("{\"username\":\"user1\", \"password\":\"password1\"}"))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.username").value("user1"));
    }

    @Test
    void testUpdateUsuario() throws Exception {
        Usuario usuario = new Usuario(1L, "user1", "password1");
        when(usuarioService.updateUsuario(anyLong(), any(Usuario.class))).thenReturn(usuario);
        mockMvc.perform(put("/usuarios/1")
            .contentType("application/json")
            .content("{\"username\":\"user1\", \"password\":\"password1\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.username").value("user1"));
    }

    @Test
    void testDeleteUsuario() throws Exception {
        doNothing().when(usuarioService).deleteUsuario(1L);
        mockMvc.perform(delete("/usuarios/1"))
            .andExpect(status().isNoContent());
    }


}
