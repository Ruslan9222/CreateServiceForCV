package by.ruslan.createserviceforcv.dto;

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
