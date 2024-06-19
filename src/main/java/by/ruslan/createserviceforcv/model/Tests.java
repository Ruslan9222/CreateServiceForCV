package by.ruslan.createserviceforcv.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
