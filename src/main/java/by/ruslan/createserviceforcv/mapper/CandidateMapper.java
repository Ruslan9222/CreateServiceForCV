package by.ruslan.createserviceforcv.mapper;

import by.ruslan.createserviceforcv.dto.CreateCandidateDto;
import by.ruslan.createserviceforcv.model.Candidate;
import org.springframework.stereotype.Component;

@Component
public class CandidateMapper {
    public Candidate createCandidateToCandidate (CreateCandidateDto createCandidateDto, byte[] cv, byte[] avatar) {
        Candidate candidate = new Candidate();
        candidate.setName(createCandidateDto.getName());
        candidate.setSurname(createCandidateDto.getSurname());
        candidate.setPatronymic(createCandidateDto.getPatronymic());
        candidate.setDescription(createCandidateDto.getDescription());
        candidate.setCv(createCandidateDto.getCv());
        candidate.setAvatar(createCandidateDto.getAvatar());
        candidate.setDirectionList(createCandidateDto.getDirectionList());
        return candidate;
    }
}
