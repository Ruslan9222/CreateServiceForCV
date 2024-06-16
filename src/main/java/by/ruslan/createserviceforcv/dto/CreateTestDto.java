package by.ruslan.createserviceforcv.dto;

import by.ruslan.createserviceforcv.model.Direction;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class CreateTestDto {
    private String testName;
    private String testDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerDirection")
    private List<Direction> directions;

}
