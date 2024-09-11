package ua.edu.ukma.modulithdemo.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderCreatedEvent {
    private Integer orderId;
    private LocalDateTime creationTime;
    private String description;
}
