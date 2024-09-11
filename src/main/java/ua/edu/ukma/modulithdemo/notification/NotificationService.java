package ua.edu.ukma.modulithdemo.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import ua.edu.ukma.modulithdemo.order.OrderCreatedEvent;
import ua.edu.ukma.modulithdemo.order.OrderDto;

@Service
@Slf4j
public class NotificationService {

    public void notifyUser(OrderDto order) {
        log.info("Order created: {}", order);
    }

    @ApplicationModuleListener
    public void onNewOrder(OrderCreatedEvent event) {
        log.info("Order created: {}", event);
    }
}
