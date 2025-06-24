

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagosService pagosService;

    @GetMapping
    public List<Pago> getAllPagos() {
        List<Pago> pagos = pagosService.getAllPagos();
        if (pagos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontraron pagos");
        }
        return ResponseEntity.ok(pagos);
    }

    @GetMapping("/{id}")
    public Pago getPagoById(@PathVariable Long id) {    
        return pagosService.getPagoById(id);
    }

    @PostMapping
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago) {   
    try{     
        Pago createdPago = pagosService.createPago(pago);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPago);
    }
    catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al crear el pago: " + e.getMessage());
    }
    }

}
