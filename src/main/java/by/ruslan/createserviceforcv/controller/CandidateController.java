package by.ruslan.createserviceforcv.controller;

import by.ruslan.createserviceforcv.dto.CreateCandidateDto;
import by.ruslan.createserviceforcv.mapper.CandidateMapper;
import by.ruslan.createserviceforcv.model.Candidate;

import by.ruslan.createserviceforcv.repository.CandidateRepository;
import by.ruslan.createserviceforcv.service.CandidateService;
import lombok.SneakyThrows;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    private final CandidateRepository candidateRepository;
    private final CandidateService candidateService;
    private final CandidateMapper candidateMapper;

    public CandidateController(CandidateRepository candidateRepository,
                               CandidateService candidateService,
                               CandidateMapper candidateMapper) {
        this.candidateRepository = candidateRepository;
        this.candidateService = candidateService;
        this.candidateMapper = candidateMapper;
    }

    @SneakyThrows
    @PostMapping
    public ResponseEntity<Candidate> create(@RequestPart("candidate") CreateCandidateDto createCandidateDto,
                                            @RequestPart("cv") MultipartFile cv,
                                            @RequestPart("avatar") MultipartFile avatar) {
        Candidate candidateToCandidate = candidateMapper.createCandidateToCandidate(createCandidateDto, cv.getBytes(), avatar.getBytes());
        Candidate candidate = candidateService.create(candidateToCandidate);
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
