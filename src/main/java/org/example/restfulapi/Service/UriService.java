package org.example.restfulapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UriService {

    @Autowired
    RestTemplate restTemplate;

    public String UrlPort(){
        System.out.println("여기서 HTTP전송");

        String baseUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst";

        String serviceKey = "H7LxAs15pOZnyG4VqjV7hWVJD0ZOQufI80JdgY5Y4rkZbVb5O8DdTBXwtumStyWoXYUExsHQ7aR00nUcBeGgSw=="; // 인증키를 실제 값으로 대체하세요.
        String numOfRows = "3";
        String dataType = "JSON";
        String baseDate = "20240812";
        String baseTime = "0630";
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
    }
