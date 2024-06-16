package by.ruslan.createserviceforcv.service;

import by.ruslan.createserviceforcv.model.Direction;
import by.ruslan.createserviceforcv.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DirectionService {

    private final DirectionRepository directionRepository;

    public DirectionService(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }

    public Direction create(Direction direction) {
        return directionRepository.save(direction);
    }

    public void updateDirectionWithCustomQuery(Long id, String description) {
        directionRepository.updateDirectionByID(id, description);
    }


}
