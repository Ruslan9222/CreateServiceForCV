package by.ruslan.createserviceforcv.controller;

import by.ruslan.createserviceforcv.dto.CreateCandidateDto;
import by.ruslan.createserviceforcv.model.Candidate;

import by.ruslan.createserviceforcv.repository.CandidateRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/candidate")
public class CandidateController {
    private final CandidateRepository candidateRepository;

    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @SneakyThrows
    @PostMapping
    public ResponseEntity<Candidate> create(@RequestPart("candidate") CreateCandidateDto createCandidateDto,
                                            @RequestPart("cv") MultipartFile cv,
                                            @RequestPart("avatar") MultipartFile avatar) {
        log.info("Create Candidate", createCandidateDto);
        Candidate candidate = new Candidate();
        candidate.setName(createCandidateDto.getName());
        candidate.setSurname(createCandidateDto.getSurname());
        candidate.setPatronymic(createCandidateDto.getPatronymic());
        candidate.setDescription(createCandidateDto.getDescription());
        candidate.setAvatar(avatar.getBytes());
        candidate.setCv(cv.getBytes());
        candidateRepository.save(candidate);
        return ResponseEntity.ok(candidate);

    }

    @SneakyThrows
    @PutMapping("/{id}/avatar")
    public ResponseEntity<Candidate> updateAvatar(@PathVariable Long id,
                                                  @RequestPart("avatar") MultipartFile avatar) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow();
        candidate.setAvatar(avatar.getBytes());
        Candidate update = candidateRepository.save(candidate);
        return ResponseEntity.ok(update);
    }

    @SneakyThrows
    @PutMapping("/{id}/cv")
    public ResponseEntity<Candidate> updateCv(@PathVariable Long id,
                                              @RequestPart("cv") MultipartFile cv) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow();
        candidate.setCv(cv.getBytes());
        Candidate update = candidateRepository.save(candidate);
        return ResponseEntity.ok(update);
    }

    @GetMapping("/{name}/all/{page}")
    public ResponseEntity<List<Candidate>> findAllByName(@PathVariable String name,
                                                         @PathVariable Integer page) {
        List<Candidate> allByName = candidateRepository.findAllByName(name, PageRequest.of(page, 5, Sort.Direction.ASC, "name"));
        return ResponseEntity.ok(allByName);
    }


}
