package com.user.usuario.config;
import org.springframework.context.annotation.Bean;
import com.user.usuario.model.categoriaUsuario;
import com.user.usuario.repository.categoriaRepository; 
import com.user.usuario.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
@Configuration
public class cargarBD {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepository, categoriaRepository categoriaRepository) {
        //Cargar Usuarios y Roles pre creados
        return args -> {
            
            if(categoriaRepository.count() == 0 && usuarioRepository.count() == 0) {
                
                categoriaUsuario Admin = new categoriaUsuario();
                Admin.setNombreCategoriaUsuario("Administrador");
                categoriaRepository.save(Admin);

                categoriaUsuario Cliente = new categoriaUsuario();
                Cliente.setNombreCategoriaUsuario("Cliente");
                categoriaRepository.save(Cliente);

                categoriaUsuario Empleado = new categoriaUsuario();
                Empleado.setNombreCategoriaUsuario("Empleado");
                categoriaRepository.save(Empleado);

                categoriaUsuario Logistico = new categoriaUsuario();
                Logistico.setNombreCategoriaUsuario("Logístico");
                categoriaRepository.save(Logistico);

                // AQUI SE CREAN USUARIOS CON SUS ROLES PARA POSTERIOR USO EN POSTMAN
            }
            else {
                System.out.println("La base de datos ya contiene datos, no se cargará nuevamente.");
            }

        };
    }
}