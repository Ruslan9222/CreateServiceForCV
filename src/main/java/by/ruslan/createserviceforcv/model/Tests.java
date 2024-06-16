package by.ruslan.createserviceforcv.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

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
    private List<Direction> directions;
}
