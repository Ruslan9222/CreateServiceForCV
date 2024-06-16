package by.ruslan.createserviceforcv.repository;

import by.ruslan.createserviceforcv.model.Tests;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestsRepository extends JpaRepository<Tests, Long> {

    @Modifying
    @Query("update Tests u set u.testDescription = :testDescription where u.id = :id")
    void updateTestByID(@Param(value = "id") long id, @Param(value = "testDescription") String testDescription);

    List<Tests> findAllByTestName(String testName, Pageable pageable);
}
