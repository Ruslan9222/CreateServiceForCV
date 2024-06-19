package by.ruslan.createserviceforcv.dto;

import by.ruslan.createserviceforcv.model.Candidate;
import by.ruslan.createserviceforcv.model.Tests;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultTestsDto {
    private int result;
    private LocalDate date;


}
