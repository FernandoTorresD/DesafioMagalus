package tech.torres.magalums.config.Contoller.dto;

import tech.torres.magalums.entity.Notification;
import tech.torres.magalums.entity.Channel;
import tech.torres.magalums.entity.Status;
import java.time.LocalDateTime;

public record ScheduleNotificationdto(LocalDateTime dateTime,
                                      String destination,
                                      String message,
                                      Channel.Values channel) {

        public Notification toNotification() {
        return new Notification(
                dateTime,
                destination,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
       );

    }
}
