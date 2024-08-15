package org.example.restfulapi.DTO;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InformationDTO {

    private Long No;
    private String category;
    private int baseDate; //발표일자
    private int baseTime; //발표시각
    private String fcstDate;
    private String fcstTime;
    private String fcstValue;
    private int nx; //x좌표
    private int ny; //y좌표
}
