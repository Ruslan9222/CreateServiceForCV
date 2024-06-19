package by.ruslan.createserviceforcv.repository;

import by.ruslan.createserviceforcv.model.Candidate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {

    List<Candidate> findAllByName (String candidates, Pageable pageable);
}
