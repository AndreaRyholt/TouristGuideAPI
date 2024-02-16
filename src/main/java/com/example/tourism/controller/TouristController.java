package com.example.tourism.controller;

import com.example.tourism.model.TouristAttraction;
import com.example.tourism.repository.TouristRepository;
import com.example.tourism.service.TouristService;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/attractions") //localhost:8080/attractions
public class TouristController {
    TouristRepository repository = new TouristRepository();
    TouristService service = new TouristService();
    private ArrayList<TouristRepository> attractionList;

    /** SHOW ALL ATTRACTIONS**/
    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAllAttractions(String name){
        List<TouristAttraction> attractionList = service.getAttractionsName(name);
        return new ResponseEntity<>(attractionList, HttpStatus.OK);
    }

    /** SHOW ATTRACTION NAME AND DESCRIPTION**/
    @GetMapping(path = "/{name}")

    public ResponseEntity<String> getSpecificAttraction(@PathVariable String name, String description) {

       ArrayList attractionName = service.getAttractionsName(name);
        ArrayList attractionDescription = service.getAttractionsDescription(description);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type","text/html");

        return new ResponseEntity<String>(
                "<html><body><h1>" +
                        attractionName +
                        attractionDescription +
                        "</h1></body></html>"
                ,responseHeaders, HttpStatus.OK);
    }

    @PostMapping(path = "show-all-attractions/opret")      //localhost:8080/kea/velkommen/opret
    public ResponseEntity<TouristAttraction> postAttraction(@RequestBody TouristAttraction attraction) {
        TouristAttraction addAttraction = service.postAttraction(attraction);
        return new ResponseEntity<TouristAttraction>(addAttraction, HttpStatus.OK);
    }

    @PutMapping(path = "show-all-attractions/ret")     //localhost:8080/kea/velkommen/ret
    public ResponseEntity<TouristAttraction> putAttraction(@RequestBody TouristAttraction attraction) {
        TouristAttraction updateAttraction = service.putAttractions(attraction);
        if (updateAttraction!=null)
            return new ResponseEntity<TouristAttraction>(updateAttraction, HttpStatus.OK);
        else
            return new ResponseEntity<TouristAttraction>(new TouristAttraction(null, "Ikke fundet"), HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("show-all-attractions/slet")
    public ResponseEntity<TouristAttraction> deleteAttraction(@RequestBody String name) {
        TouristAttraction deleteAttraction = service.deleteAttraction(name);
        return new ResponseEntity<TouristAttraction>(deleteAttraction, HttpStatus.OK);
    }
}
