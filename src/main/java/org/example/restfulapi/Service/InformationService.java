package org.example.restfulapi.Service;

import org.example.restfulapi.DTO.InformationDTO;
import org.example.restfulapi.Entiry.Information;

import java.util.List;
import java.util.Optional;

public interface InformationService {

    String urlReponse(String baseDate,String baseTime);

    Long register(InformationDTO dto);

    List<Information> getAllInformation();

    InformationDTO findNoInformation(Long No);


    default InformationDTO entityToDto(Information entity) {

        // entity 객체의 메서드를 사용하여 DTO 생성
        InformationDTO dtoEn = InformationDTO.builder()
                .category(entity.getCategory())
                .baseDate(entity.getBaseDate())
                .baseTime(entity.getBaseTime())
                .No(entity.getNo()) // DTO의 필드와 엔티티의 필드를 매핑합니다.
                .nx(entity.getNx())
                .ny(entity.getNy())
                .build();

        return dtoEn;
    }


    default Information dtoToEntity(InformationDTO dto) {
        Information entity = Information.builder()
                .category(dto.getCategory())
                .nx(dto.getNx())
                .ny(dto.getNy())
                .No(dto.getNo())
                .baseTime(dto.getBaseTime())
                .baseDate(dto.getBaseDate())
                .build();
        return entity;
    }


}
