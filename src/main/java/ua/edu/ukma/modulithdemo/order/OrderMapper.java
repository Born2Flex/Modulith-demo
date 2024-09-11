package ua.edu.ukma.modulithdemo.order;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    OrderDto toDto(OrderEntity order);

    OrderEntity toEntity(OrderDto dto);
}
