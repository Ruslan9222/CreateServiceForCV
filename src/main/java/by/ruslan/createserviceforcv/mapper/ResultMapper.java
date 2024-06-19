package by.ruslan.createserviceforcv.mapper;

import by.ruslan.createserviceforcv.dto.ResultTestsDto;
import by.ruslan.createserviceforcv.model.ResultTests;
import org.springframework.stereotype.Component;

@Component
public class ResultMapper {
    public ResultTests createResultToResult(ResultTestsDto resultTestsDto) {
        ResultTests resultTests = new ResultTests();
        resultTests.setDate(resultTestsDto.getDate());
        resultTests.setResult(resultTests.getResult());
        return resultTests;

    }
}
