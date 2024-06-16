package by.ruslan.createserviceforcv.mapper;

import by.ruslan.createserviceforcv.dto.CreateDirectionDto;
import by.ruslan.createserviceforcv.model.Direction;
import org.springframework.stereotype.Component;

@Component
public class DirectionMapper {
    public Direction createDirectionToDirection(CreateDirectionDto createDirectionDto){
        Direction direction = new Direction();
        direction.setDirectionName(createDirectionDto.getDirectionName());
        direction.setDescription(createDirectionDto.getDescription());
        return direction;
    }
}
