package by.ruslan.createserviceforcv.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "db_result_test_candidate")
public class ResultTests extends AbstractModelId {

    private String result;
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_test_id")
    private Candidate candidates;
    @OneToOne(cascade = CascadeType.ALL)
    private Tests tests;
}
