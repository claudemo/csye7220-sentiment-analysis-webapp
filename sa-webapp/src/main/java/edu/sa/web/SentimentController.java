package edu.sa.web;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.sa.web.dto.SentenceDto;
import edu.sa.web.dto.SentimentDto;

@CrossOrigin(origins = "*")
@RestController
public class SentimentController {
@Value("${sa.logic.api.url}") 
private String saLogicApiUrl;

 // Maps POST requests to /sentiment to get the sentiment of a sentence
@PostMapping("/testSentiment")
public SentimentDto sentimentAnalysis(@RequestBody SentenceDto sentenceDto) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(saLogicApiUrl + "/analyse/sentiment",
                sentenceDto, SentimentDto.class)
                .getBody();
    }
@GetMapping("/testHealth")  // Maps GET requests to /testHealth to this method
public String testHealth() {
    return "hello world from java from java endpoint!";  // Returns a simple string response
}
@GetMapping("/testComms")
    public ResponseEntity<String> getHealthStatus() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(saLogicApiUrl+ "/testHealth", String.class);
        return response;
    }

    
    @GetMapping("/testhappy") 
    public String testSentimentGet() {
    
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result =
            restTemplate.getForEntity(saLogicApiUrl + "/analyse?sentence=i+am+so+happy!", String.class);
    //assertEquals(HttpStatus.OK, result.getStatusCode()); 
        return result.getBody();
    }
}