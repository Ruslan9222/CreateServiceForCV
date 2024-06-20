package by.ruslan.createserviceforcv.controller;

import by.ruslan.createserviceforcv.dto.ResultTestsDto;
import by.ruslan.createserviceforcv.dto.UpdateResultTestDto;
import by.ruslan.createserviceforcv.mapper.ResultMapper;
import by.ruslan.createserviceforcv.model.ResultTests;
import by.ruslan.createserviceforcv.repository.ResultTestsRepository;
import by.ruslan.createserviceforcv.service.ResultTestsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/result")
public class ResultTestsController {
    private final ResultTestsRepository resultTestsRepository;
    private final ResultTestsService resultTestsService;
    private final ResultMapper resultMapper;

    public ResultTestsController(ResultTestsRepository resultTestsRepository, ResultTestsService resultTestsService, ResultMapper resultMapper) {
        this.resultTestsRepository = resultTestsRepository;
        this.resultTestsService = resultTestsService;
        this.resultMapper = resultMapper;
    }

    @PostMapping
    ResponseEntity<ResultTests> create(@RequestBody ResultTestsDto resultTestsDto) {
        log.info("Creating new result tests", resultTestsDto);
        ResultTests resultTestsToResult = resultMapper.createResultToResult(resultTestsDto);
        ResultTests resultTests = resultTestsService.create(resultTestsToResult);
        return ResponseEntity.ok(resultTests);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity.BodyBuilder updateTestById(@RequestBody UpdateResultTestDto updateResultTestDto,
                                                     @PathVariable("id") long id) {
        log.info("Updating result tests", updateResultTestDto);
        resultTestsService.updateResultWithCustomQuery(id, String.valueOf(updateResultTestDto));
        return ResponseEntity.ok();
    }

    @GetMapping("{result}/all/{pages}")
    public ResponseEntity<List<ResultTests>> findAllByResult(@PathVariable String result,
                                                             @PathVariable Integer pages) {
        List<ResultTests> allByTestResult = resultTestsRepository.findAllByResult(result,
                PageRequest.of(pages, 5, Sort.Direction.ASC, "resultTest"));
        return ResponseEntity.ok(allByTestResult);
    }
}
