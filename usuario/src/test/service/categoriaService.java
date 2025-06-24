import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class categoriaService {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    @Test
    void testFindAllCategorias() {  
        Categoria categoria1 = new Categoria(1L, "Categoria1");
        Categoria categoria2 = new Categoria(2L, "Categoria2");
        when(categoriaRepository.findAll()).thenReturn(Arrays.asList(categoria1, categoria2));

        List<Categoria> categorias = categoriaService.findAllCategorias();

        assertThat(categorias).hasSize(2);
        assertThat(categorias.get(0).getNombre()).isEqualTo("Categoria1");
        assertThat(categorias.get(1).getNombre()).isEqualTo("Categoria2");
    }

    @Test
    void testFindCategoriaById() {
        Categoria categoria = new Categoria(1L, "Categoria1");
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));

        Optional<Categoria> foundCategoria = categoriaService.findCategoriaById(1L);

        assertThat(foundCategoria).isPresent();
        assertThat(foundCategoria.get().getNombre()).isEqualTo("Categoria1");
    }   

    @Test
    void testSaveCategoria() {
        Categoria categoria = new Categoria(1L, "Categoria1");
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        Categoria savedCategoria = categoriaService.saveCategoria(categoria);

        assertThat(savedCategoria.getNombre()).isEqualTo("Categoria1");
    }

    @Test
    void testDeleteCategoria() {
        Categoria categoria = new Categoria(1L, "Categoria1");
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));

        categoriaService.deleteCategoria(1L);

        verify(categoriaRepository).delete(categoria);
    }

    @Test   
    void updateCategoria() {
        Categoria categoria = new Categoria(1L, "Categoria1");
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        Categoria updatedCategoria = categoriaService.updateCategoria(1L, "UpdatedCategoria");

        assertThat(updatedCategoria.getNombre()).isEqualTo("UpdatedCategoria");
        verify(categoriaRepository).save(any(Categoria.class));
    }


}
