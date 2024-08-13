package org.example.restfulapi.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.restfulapi.Service.UriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InfoRestController {

    @Autowired
    UriService service;

    @Autowired
    ObjectMapper mapper;

    @GetMapping("/url")
    public String generateUrl() throws JsonProcessingException {
        System.out.println("여기서 uri");
        String data = service.UrlPort();
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

        String baseDate = itemNode.path("baseDate").asText();
        String baseTime = itemNode.path("baseTime").asText();
        String category = itemNode.path("category").asText();
        String fcstDate = itemNode.path("fcstDate").asText();
        String fcstTime = itemNode.path("fcstTime").asText();
        String fcstValue = itemNode.path("fcstValue").asText();
        int nx = itemNode.path("nx").asInt();
        int ny = itemNode.path("ny").asInt();

        // 출력

        System.out.println("Base Date: " + baseDate);
        System.out.println("Base Time: " + baseTime);
        System.out.println("Category: " + category);
        System.out.println("Forecast Date: " + fcstDate);
        System.out.println("Forecast Time: " + fcstTime);
        System.out.println("Forecast Value: " + fcstValue);
        System.out.println("NX: " + nx);
        System.out.println("NY: " + ny);


        return "이이";
    }



}
