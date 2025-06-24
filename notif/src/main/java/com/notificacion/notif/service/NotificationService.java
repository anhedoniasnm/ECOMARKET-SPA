@Service
@Transactional
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private PagoClient pagoClient;

    @Autowired
    private PedidoClient pedidoClient;

    @Autowired
    private LogisticaClient logisticaClient;   

    public Notification createNotification(Notification notification) {
        
        Map<String, Object> usuario = usuarioClient.getUsuarioById(notification.getUsuarioId());
        if(usuario == null) {
            throw new RuntimeException("Usuario not found");
        }
        else{
            notification.setIdCliente((Long) usuario.get("id"));
        }
        Map<String, Object> pago = pagoClient.getPagoById(notification.getPagoId());
        if(pago == null) {
            throw new RuntimeException("Pago not found");
        }
        else{
            notification.setIdPago((Long) pago.get("id"));
        }
        Map<String, Object> pedido = pedidoClient.getPedidoById(notification.getPedidoId());
        if(pedido == null) {    
            throw new RuntimeException("Pedido not found");
        }
        else{
            notification.setIdPedido((Long) pedido.get("id"));
        }
        Map<String, Object> logistica = logisticaClient.getLogisticaById(notification.getLogisticaId());
        if(logistica == null) {
            throw new RuntimeException("Logistica not found");
        }
        else{
            notification.setIdEnvio((Long) logistica.get("id"));
        }
        notification.setEstado("PENDING");
        notification.setMessage("Se crearon los datos de envío");
        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
    }

    public Notification updateNotification(Long id, Notification notification) {
        Notification existingNotification = getNotificationById(id);
        existingNotification.setEstado(notification.getEstado());
        existingNotification.setMessage(notification.getMessage());
        return notificationRepository.save(existingNotification);
    }

    public void deleteNotification(Long id) {
        Notification existingNotification = getNotificationById(id);
        notificationRepository.delete(existingNotification);
    }

}
