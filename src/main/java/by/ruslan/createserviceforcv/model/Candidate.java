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
@Table (name = "db_candidate")
public class Candidate extends AbstractModelId{
    private String name;
    private String surname;
    private String patronymic;
    private byte[] avatar;
    private String description;
    private byte[] cv;
    @OneToMany (cascade = CascadeType.ALL)
    private List<Direction> directionList;

}
