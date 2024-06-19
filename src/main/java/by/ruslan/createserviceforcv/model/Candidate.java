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
@Table(name = "db_candidate")
public class Candidate extends AbstractModelId {
    private String name;
    private String surname;
    private String patronymic;
    private byte[] avatar;
    private String description;
    private byte[] cv;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Direction> directionList;

}
