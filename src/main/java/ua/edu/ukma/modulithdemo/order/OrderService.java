package ua.edu.ukma.modulithdemo.order;

import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.edu.ukma.modulithdemo.notification.NotificationService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ApplicationEventPublisher eventPublisher;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).toList();
    }

    public OrderDto findById(Integer id) {
        return orderRepository.findById(id).map(orderMapper::toDto).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Transactional
    public OrderDto save(OrderDto orderDto) {
        OrderDto createdOrder = orderMapper.toDto(orderRepository.save(orderMapper.toEntity(orderDto)));
        eventPublisher.publishEvent(new OrderCreatedEvent(createdOrder.getId(), LocalDateTime.now(), createdOrder.getName()));
//        notificationService.notifyUser(createdOrder);
        return createdOrder;
    }

    public boolean delete(Integer id) {
        orderRepository.deleteById(id);
        return true;
    }

    public boolean update(OrderDto orderDto) {
        orderRepository.saveAndFlush(orderMapper.toEntity(orderDto));
        return true;
    }
}
