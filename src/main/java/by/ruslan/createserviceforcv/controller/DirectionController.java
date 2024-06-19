package by.ruslan.createserviceforcv.controller;


import by.ruslan.createserviceforcv.dto.CreateDirectionDto;
import by.ruslan.createserviceforcv.dto.UpdateDirectionDto;
import by.ruslan.createserviceforcv.mapper.DirectionMapper;
import by.ruslan.createserviceforcv.model.Direction;
import by.ruslan.createserviceforcv.repository.DirectionRepository;
import by.ruslan.createserviceforcv.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direction")
public class DirectionController {
    private final DirectionService directionService;
    private final DirectionMapper directionMapper;
    private final DirectionRepository directionRepository;

    public DirectionController(DirectionService directionService, DirectionMapper directionMapper, DirectionRepository directionRepository) {
        this.directionService = directionService;
        this.directionMapper = directionMapper;
        this.directionRepository = directionRepository;
    }

    @PostMapping
    ResponseEntity<Direction> create(@RequestBody CreateDirectionDto createDirectionDto) {
        Direction directionToDirection = directionMapper.createDirectionToDirection(createDirectionDto);
        Direction direction = directionService.create(directionToDirection);
        return ResponseEntity.ok(direction);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity.BodyBuilder updateDirectionById(
            @RequestBody UpdateDirectionDto updateDirectionDto,
            @PathVariable("id") long id) {
        directionService.updateDirectionWithCustomQuery(id, String.valueOf(updateDirectionDto));
        return ResponseEntity.ok();
    }

    @GetMapping("{directionName}/all/{page}")
    public ResponseEntity<List<Direction>> findAllByDirectionName(
            @PathVariable String directionName,
            @PathVariable Integer page) {
        List<Direction> allByDirectionName = directionRepository.findAllByDirectionName(directionName,
                PageRequest.of(page, 5, Sort.Direction.ASC, "directionName"));
        return ResponseEntity.ok(allByDirectionName);
    }
}
