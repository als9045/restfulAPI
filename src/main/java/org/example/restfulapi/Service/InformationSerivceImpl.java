package org.example.restfulapi.Service;


import org.example.restfulapi.DTO.InformationDTO;
import org.example.restfulapi.Entiry.Information;
import org.example.restfulapi.Repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
public class InformationSerivceImpl implements InformationService {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    InfoRepository repository;


    @Override
    public String urlReponse(String baseDate,String baseTime) {
        System.out.println("여기서 HTTP전송");
        System.out.println("웹 값이전해졌나 = "+baseDate+baseTime);

        String baseUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst";

        String serviceKey = "H7LxAs15pOZnyG4VqjV7hWVJD0ZOQufI80JdgY5Y4rkZbVb5O8DdTBXwtumStyWoXYUExsHQ7aR00nUcBeGgSw=="; // 인증키를 실제 값으로 대체하세요.
        String numOfRows = "3";
        String dataType = "JSON";
        String bseDate = baseDate;
        String bseTime = baseTime;
        String nx = "55";
        String ny = "127";

        String uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("serviceKey", serviceKey)
                .queryParam("numOfRows", numOfRows)
                .queryParam("dataType", dataType)
                .queryParam("base_date", baseDate)
                .queryParam("base_time", baseTime)
                .queryParam("nx", nx)
                .queryParam("ny", ny)
                .build()
                .toUriString();

        return restTemplate.getForObject(uri, String.class);

    }


    @Override
    public Long register(InformationDTO dto) {

        Information entity = dtoToEntity(dto);

        repository.save(entity);

        return entity.getNo();
    }

    @Override
    public List<Information> getAllInformation() {
    return repository.findAll();
    }

    @Override
    public InformationDTO findNoInformation(Long no) {
        Information info = repository.getById(no);

        entityToDto(info);

        return entityToDto(info);
    }

}
