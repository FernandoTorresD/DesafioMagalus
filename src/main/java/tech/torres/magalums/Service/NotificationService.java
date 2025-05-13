package tech.torres.magalums.Service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import tech.torres.magalums.config.Contoller.dto.ScheduleNotificationdto;
import tech.torres.magalums.entity.Notification;
import tech.torres.magalums.entity.Status;
import tech.torres.magalums.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    private static NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;

    }


    public void scheduleNotification(ScheduleNotificationdto dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification>findById(Long notificarionId) {
        return notificationRepository.findById(notificarionId);    }

    public void cancelNotification(Long notificationId) {

        //buscando notificação pelo ID
        var notification = findById(notificationId);

        //se a notificação existir //
                if (notification.isPresent()) {
                    notification.get().setStatus(Status.Values.CANCELED.toStatus());
                    notificationRepository.save(notification.get());

                }
    }

    public void checkAndSend(LocalDateTime dateTime) {
        var notification = notificationRepository.findByStatusInAndDateTimeBefore(List.of(
                Status.Values.PENDING.toStatus(),
                Status.Values.ERROR.toStatus()), dateTime

        );
        notification.forEach(sendNotification());
    }

    private static @NotNull Consumer<Notification> sendNotification() {
        return n -> {
            // TODO - realizar o envio da notificação

            notificationRepository.save(n);
        };
    }
}

