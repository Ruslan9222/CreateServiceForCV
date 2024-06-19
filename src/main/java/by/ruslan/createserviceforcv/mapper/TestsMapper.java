package by.ruslan.createserviceforcv.mapper;

import by.ruslan.createserviceforcv.dto.CreateTestDto;
import by.ruslan.createserviceforcv.model.Tests;
import org.springframework.stereotype.Component;

@Component
public class TestsMapper {
    public Tests createTestDtoToTest(CreateTestDto createTestDto) {
        Tests createTest = new Tests();
        createTest.setTestName(createTestDto.getTestName());
        createTest.setTestDescription(createTestDto.getTestDescription());
        createTest.setDirections(createTestDto.getDirections());
        return createTest;
    }

}
