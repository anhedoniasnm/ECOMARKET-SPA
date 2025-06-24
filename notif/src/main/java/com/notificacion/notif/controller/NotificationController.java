package com.notificacion.notif.controller;

@RestController
@RequestMapping("api/v1/notificaciones")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.createNotification(notification);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        Notification notification = notificationService.getNotificationById(id);
        if (notification == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
        return new ResponseEntity<>(notification, HttpStatus.OK);
        }
    }   

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        if (notifications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
        return new ResponseEntity<>(notifications, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        if (!notificationService.getAllNotifications().stream().anyMatch(n -> n.getIdNotification().equals(id))) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            notificationService.deleteNotification(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification notification) {
        Notification updatedNotification = notificationService.updateNotification(id, notification);
        if (updatedNotification == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            updatedNotification.setIdNotification(id);
            updatedNotification = notificationService.updateNotification(id, updatedNotification);
        }
        return new ResponseEntity<>(updatedNotification, HttpStatus.OK);
    }

}
