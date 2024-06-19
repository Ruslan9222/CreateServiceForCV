package by.ruslan.createserviceforcv.dto;

import by.ruslan.createserviceforcv.model.Direction;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Setter
@Getter
@ToString
public class CreateCandidateDto {
    private String name;
    private String surname;
    private String patronymic;
    private byte[] avatar;
    private String description;
    private byte[] cv;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Direction> directionList;

}
