package by.ruslan.createserviceforcv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "db_directionNames")
public class Direction extends AbstractModelId {
    private String directionName;
    private String description;

}
