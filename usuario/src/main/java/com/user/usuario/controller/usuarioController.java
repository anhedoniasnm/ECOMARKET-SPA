



@RestController
@RequestMapping("/api/v1")
public class usuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private categoriaRepository categoriaRepository;

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping("/usuarios")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/categorias")
    public List<CategoriaUsuario> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @PostMapping("/categorias")
    public CategoriaUsuario createCategoria(@RequestBody CategoriaUsuario categoria) {
        return categoriaRepository.save(categoria);
    }

}
