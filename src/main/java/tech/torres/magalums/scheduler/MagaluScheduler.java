package tech.torres.magalums.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tech.torres.magalums.Service.NotificationService;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class MagaluScheduler {

   private static final Logger logger = LoggerFactory.getLogger(MagaluScheduler.class);


   private final NotificationService notificationService;

    public MagaluScheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTask() {
        var dateTime = LocalDateTime.now();
        logger.info("Rodando á {}", dateTime);
        notificationService.checkAndSend(dateTime);

    }
}
