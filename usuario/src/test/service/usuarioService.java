package usuario.src.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.test.context.SpringBootTest;
import usuario.src.main.model.Usuario;
import usuario.src.main.model.Categoria;
import usuario.src.main.repository.UsuarioRepository;
import usuario.src.main.repository.CategoriaRepository;
import usuario.src.main.service.UsuarioService;
import usuario.src.main.service.CategoriaService;


@ExtendWith(MockitoExtension.class)
public class usuarioService {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private categoriaRepository categoriaRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void testFindAllUsuarios() {
        Usuario usuario1 = new Usuario(1L, "user1", "password1");
        Usuario usuario2 = new Usuario(2L, "user2", "password2");
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario1, usuario2));

        List<Usuario> usuarios = usuarioService.findAllUsuarios();

        assertThat(usuarios).hasSize(2);
        assertThat(usuarios.get(0).getUsername()).isEqualTo("user1");
        assertThat(usuarios.get(1).getUsername()).isEqualTo("user2");
    }

    @Test
    void testFindUsuarioById() { 
        Usuario usuario = new Usuario(1L, "user1", "password1");
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<Usuario> foundUsuario = usuarioService.findUsuarioById(1L);

        assertThat(foundUsuario).isPresent();
        assertThat(foundUsuario.get().getUsername()).isEqualTo("user1");
    }

    @Test
    void testSaveUsuario() {
        Usuario usuario = new Usuario(1L, "user1", "password1");
        when(passwordEncoder.encode("password1")).thenReturn("encodedPassword");
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario savedUsuario = usuarioService.saveUsuario(usuario);

        assertThat(savedUsuario.getUsername()).isEqualTo("user1");
        assertThat(savedUsuario.getPassword()).isEqualTo("encodedPassword");
        verify(usuarioRepository).save(any(Usuario.class));
    }

    @Test
    void testDeleteUsuario() {  
        Usuario usuario = new Usuario(1L, "user1", "password1");
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        usuarioService.deleteUsuario(1L);

        verify(usuarioRepository).delete(usuario);
    }

    @Test
    void testFindAllCategorias() {
        Categoria categoria1 = new Categoria(1L, "categoria1");
        Categoria categoria2 = new Categoria(2L, "categoria2");
        when(categoriaRepository.findAll()).thenReturn(Arrays.asList(categoria1, categoria2));

        List<Categoria> categorias = usuarioService.findAllCategorias();

        assertThat(categorias).hasSize(2);
        assertThat(categorias.get(0).getNombre()).isEqualTo("categoria1");
        assertThat(categorias.get(1).getNombre()).isEqualTo("categoria2");
    }

    @Test
    void updateUsuario() {
        Usuario usuario = new Usuario(1L, "user1", "password1");
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario updatedUsuario = usuarioService.updateUsuario(1L, "newUser", "newPassword");

        assertThat(updatedUsuario.getUsername()).isEqualTo("newUser");
        assertThat(updatedUsuario.getPassword()).isEqualTo("encodedPassword");
        verify(usuarioRepository).save(any(Usuario.class));
    }

}
