package by.ruslan.createserviceforcv.service;

import by.ruslan.createserviceforcv.model.ResultTests;
import by.ruslan.createserviceforcv.repository.ResultTestsRepository;
import org.springframework.stereotype.Service;

@Service
public class ResultTestsService {

    private final ResultTestsRepository resultTestsRepository;

    public ResultTestsService(ResultTestsRepository resultTestsRepository) {
        this.resultTestsRepository = resultTestsRepository;
    }

    public ResultTests create(ResultTests resultTests) {
        return resultTestsRepository.save(resultTests);
    }

    public void updateResultWithCustomQuery(Long id, String result) {
        resultTestsRepository.updateResultTestsByID(id, result);
    }

}
