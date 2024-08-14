package org.example.restfulapi.Entiry;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long No;

    private String category;

    private int baseDate; //발표일자

    private int baseTime; //발표시각

    private int nx; //x좌표

    private int ny; //y좌표


}