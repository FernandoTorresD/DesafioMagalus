package tech.torres.magalums.config.Contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.torres.magalums.Service.NotificationService;
import tech.torres.magalums.config.Contoller.dto.ScheduleNotificationdto;

@RestController
@RequestMapping("/notifications")
class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping

    public ResponseEntity<Void>scheduleNotification(@RequestBody ScheduleNotificationdto dto) {
        notificationService.scheduleNotification(dto);


        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<?> getNotification(@PathVariable("notificationId") Long notificationId) {

        var notification = notificationService.findById(notificationId);

        if (notification.isEmpty()) {
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(notification.get());


    }
    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable("notificationID") Long notificationId) {
        notificationService.cancelNotification(notificationId);
        return ResponseEntity.noContent().build();
    }
}

