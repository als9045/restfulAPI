package org.example.restfulapi.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.restfulapi.DTO.InformationDTO;
import org.example.restfulapi.Entiry.Information;
import org.example.restfulapi.Service.InformationSerivceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.expression.Arrays;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/information")
public class InfoRestController {

    @Autowired
    InformationSerivceImpl service;

    @Autowired
    ObjectMapper mapper;

    @GetMapping("/registerWeather")
    public InformationDTO registerWeather(@RequestParam String baseDate, @RequestParam String baseTime) throws JsonProcessingException,Exception {
        System.out.println("여기서 uri");
        String data = service.urlReponse(baseDate,baseTime);
        System.out.println("data= "+data);
        JsonNode jsonNode = mapper.readTree(data);
        ObjectMapper objectMapper = new ObjectMapper();

        // "response" 노드 접근
        JsonNode responseNode = jsonNode.path("response");

        // "header" 노드 접근
        JsonNode headerNode = responseNode.path("header");

        // "body" 노드 접근
        JsonNode bodyNode = responseNode.path("body");
        JsonNode itemsNode = bodyNode.path("items");
        JsonNode itemNode = itemsNode.path("item").get(0); // 첫 번째 항목
        InformationDTO informationDTO = objectMapper.treeToValue(itemNode, InformationDTO.class);

        service.register(informationDTO);


        System.out.println("결과 = "+ informationDTO.getCategory());

        return informationDTO;
    }
    @GetMapping("/findWeather")
    public InformationDTO findWeather(@RequestParam String baseDate, @RequestParam String baseTime) throws JsonProcessingException,Exception {
        System.out.println("여기서 uri");
        String data = service.urlReponse(baseDate,baseTime);
        System.out.println("data= "+data);
        JsonNode jsonNode = mapper.readTree(data);


        // "response" 노드 접근
        JsonNode responseNode = jsonNode.path("response");

        // "header" 노드 접근
        JsonNode headerNode = responseNode.path("header");

        // "body" 노드 접근
        JsonNode bodyNode = responseNode.path("body");
        JsonNode itemsNode = bodyNode.path("items");
        JsonNode itemNode = itemsNode.path("item").get(0); // 첫 번째 항목
        InformationDTO informationDTO = mapper.treeToValue(itemNode, InformationDTO.class);


        System.out.println("결과 = "+ informationDTO.getCategory());

        return informationDTO;
    }
    @GetMapping("/all")
    public List<Information> getAllInformation() {

        return service.getAllInformation();
    }

    @GetMapping("/findNo")
    public InformationDTO findInformation(@RequestParam Long no) {

        System.out.println("No ="+no);

        service.findNoInformation(no);

        System.out.println("데이터 "+service.findNoInformation(no));

        return service.findNoInformation(no);
    }


}
