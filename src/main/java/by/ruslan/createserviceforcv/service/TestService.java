package by.ruslan.createserviceforcv.service;

import by.ruslan.createserviceforcv.model.Tests;
import by.ruslan.createserviceforcv.repository.TestsRepository;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final TestsRepository testsRepository;

    public TestService(TestsRepository testsRepository) {
        this.testsRepository = testsRepository;
    }

    public Tests create(Tests tests) {
        return testsRepository.save(tests);
    }

    public void updateTestWithCustomQuery(Long id, String testDescription) {
        testsRepository.updateTestByID(id, testDescription);
    }
}
