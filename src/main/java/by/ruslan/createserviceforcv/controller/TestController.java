package by.ruslan.createserviceforcv.controller;

import by.ruslan.createserviceforcv.dto.CreateTestDto;
import by.ruslan.createserviceforcv.dto.UpdateDirectionDto;
import by.ruslan.createserviceforcv.mapper.TestsMapper;
import by.ruslan.createserviceforcv.model.Tests;
import by.ruslan.createserviceforcv.repository.TestsRepository;
import by.ruslan.createserviceforcv.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestsRepository testsRepository;

    private final TestService testsService;

    private final TestsMapper testsMapper;

    public TestController(TestsRepository testsRepository, TestService testsService, TestsMapper testsMapper) {
        this.testsRepository = testsRepository;
        this.testsService = testsService;
        this.testsMapper = testsMapper;
    }

    @PostMapping
    ResponseEntity<Tests> create(@RequestBody CreateTestDto createTestDto) {
        Tests testsToTests = testsMapper.createTestDtoToTest(createTestDto);
        Tests tests = testsService.create(testsToTests);
        return ResponseEntity.ok(tests);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity.BodyBuilder updateTestById(
            @RequestBody UpdateDirectionDto updateTestDto,
            @PathVariable("id") long id) {
        testsService.updateTestWithCustomQuery(id, String.valueOf(updateTestDto));
        return ResponseEntity.ok();
    }

    @GetMapping("{testName}/all/{page}")
    public ResponseEntity<List<Tests>> findAllByTestsName(
            @PathVariable String testName,
            @PathVariable Integer page) {
        List<Tests> allByTestName = testsRepository.findAllByTestName(testName,
                PageRequest.of(page, 5, Sort.Direction.ASC, "testName"));
        return ResponseEntity.ok(allByTestName);
    }

}
