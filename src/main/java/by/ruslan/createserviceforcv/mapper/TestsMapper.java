package by.ruslan.createserviceforcv.mapper;

import by.ruslan.createserviceforcv.dto.CreateTestDto;
import by.ruslan.createserviceforcv.model.Tests;
import org.springframework.stereotype.Component;

@Component
public class TestsMapper {
    public Tests createTestDtoToTest(CreateTestDto createTestDto){
        Tests createTest = new Tests();
        createTest.setTestName(createTest.getTestName());
        createTest.setTestDescription(createTest.getTestDescription());
        createTest.setDirections(createTestDto.getDirections());
        return createTest;
    }

}
