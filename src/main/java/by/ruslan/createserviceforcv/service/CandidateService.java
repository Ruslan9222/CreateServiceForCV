package by.ruslan.createserviceforcv.service;

import by.ruslan.createserviceforcv.model.Candidate;
import by.ruslan.createserviceforcv.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }


    public Candidate create (Candidate candidate){
        return candidateRepository.save(candidate);
    }

}
