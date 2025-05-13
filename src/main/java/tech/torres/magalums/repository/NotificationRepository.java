package tech.torres.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.torres.magalums.entity.Notification;
import tech.torres.magalums.entity.Status;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    static void save(javax.management.Notification notification) {
    }

    List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
