package by.ruslan.createserviceforcv.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

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
