package com.trivialgame.trivialgame.restcontroller;

import com.trivialgame.trivialgame.service.StructureTrivialDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TrivialRestController {

    private StructureTrivialDataService structureTrivialDataService;

    @GetMapping("/trivial")
    public String getTrivialRemoteData(){
        var trivialData = new RestTemplate().getForEntity("https://the-trivia-api.com/api/questions?limit=20&categories=science,history",String.class).getBody();
        //structureTrivialDataService.getData(trivialData);
        return trivialData;
    }

}
