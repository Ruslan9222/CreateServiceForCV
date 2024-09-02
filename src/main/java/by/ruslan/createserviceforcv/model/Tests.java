package by.ruslan.createserviceforcv.model;

import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "db_tests")
public class Tests extends AbstractModelId {
    private String testName;
    private String testDescription;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id", nullable = false)
    private List<Direction> directions;
}
