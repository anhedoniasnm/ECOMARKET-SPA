package com.pagos.pago.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pagos.pago.repository.PagosRepository;

@Service
@Transactional
public class PagosService {

    @Autowired
    private PagosRepository pagosRepository;
     
    @Autowired
    private PedidoClient pedidoClient;
    
    public List <Pago> getAllPagos() {
        return pagosRepository.findAll();
    }

    public Pago getPagoById(Long id) {
        return pagosRepository.findById(id).orElse(null);
    }

    public Pago createPago(Pago pago) {

        Map<String, Object> pedido= pedidoClient.getPedidoById(pago.getIdPedido());
        
        if (pedido == null) {
            throw new RuntimeException("Pedido con id: " + pago.getIdPedido()+" no encontrado");
        }
        return pagosRepository.save(pago);

        Object monto = pedido.get("totalPedido");
        Double montototal = null;
        if(monto instanceof Double) {
            montototal = (Double) monto;
        } 
        else {
            throw new RuntimeException("Tipo de monto no soportado: " + monto.getClass().getName());
        }
        pago.setTotal(montototal);

        Object nombre = pedido.get("nombreProducto");
        String nombreCli = (nombre != null) ? nombre.toString() : "Desconocido";
        pago.setNombreCliente(nombreCli);

        return pagosRepository.save(pago);
    }

}
