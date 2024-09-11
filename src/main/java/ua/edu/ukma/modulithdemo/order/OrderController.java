package ua.edu.ukma.modulithdemo.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto order) {
        return orderService.save(order);
    }

    @GetMapping
    public List<OrderDto> findAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderDto findOrderById(@PathVariable Integer id) {
        return orderService.findById(id);
    }

    @PutMapping
    public boolean updateOrder(OrderDto order) {
        return orderService.update(order);
    }
}
