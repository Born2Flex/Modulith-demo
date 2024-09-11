package ua.edu.ukma.modulithdemo.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderDto {
    private Integer id;
    @Size(max = 256)
    @NotBlank
    private String name;
}
