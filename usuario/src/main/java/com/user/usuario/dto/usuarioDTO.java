package com.user.usuario.dto;
import lombok.Data;
import com.user.usuario.model.categoriaUsuario;
@Data
public class usuarioDTO {
    private Long idUsuario;
    private String nombreUsuario;
    private String emailUsuario;
    private CategoriaUsuario categoriaUsuario;

}
