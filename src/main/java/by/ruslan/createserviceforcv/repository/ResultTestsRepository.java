package by.ruslan.createserviceforcv.repository;

import by.ruslan.createserviceforcv.model.ResultTests;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ResultTestsRepository extends JpaRepository<ResultTests, Long> {
    @Modifying
    @Query("update ResultTests u set u.result = :result where u.id = :id")
    void updateResultTestsByID(@Param(value = "id") long id, @Param(value = "result") String result);


    List<ResultTests> findAllByResult(String result, Pageable pageable);

}
