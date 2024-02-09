package com.example.tourism.controller;

import com.example.tourism.model.TouristAttraction;
import com.example.tourism.repository.TouristRepository;
import com.example.tourism.service.TouristService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/attractions") //localhost:8080/attractions
public class TouristController {
    TouristRepository repository = new TouristRepository();
    TouristService service = new TouristService();
    private ArrayList<TouristRepository> attractionList;
    //TouristAttraction ta = new TouristAttraction();


    /** SHOW ALL ATTRACTIONS**/
    //@GetMapping("/show-all-attractions")
    public ResponseEntity<ArrayList<TouristAttraction>> getAllAttractions(String name){
        List<TouristAttraction> attractionList = service.getAttractionsName(name);
        return new ResponseEntity<>(repository.getAttractionsName(name), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @ResponseBody
    public ResponseEntity<TouristAttraction> getSpecificAttraction(String name, String description){
        String attractionName = String.valueOf(repository.getAttractionsName(name));
        String attractionDescription = String.valueOf(repository.getAttractionsDescription(description));

       HttpHeaders responseHeaders = new HttpHeaders();
       responseHeaders.set("Content-Type","text/html");

       /*String htmlResponse = "<html><body><h1>" +
               attractionName + attractionDescription +
               "</h1></body></html>";*/

       return new ResponseEntity<TouristAttraction>(
               "<html><body><h1>"
                       + attractionName.getSpecificAttraction()
                       + attractionDescription.getSpecificAttraction() +
                "</h1></body></html>", responseHeaders, HttpStatus.OK);
    }




    @GetMapping(path = "velkommen/{id}")    //localhost:8080/kea/velkommen/1
    public ResponseEntity<String> getMessage(@PathVariable int id) {
//        Message message = welcomeService.getWelcomeMessage(id);
//        return new ResponseEntity<Message>(message, HttpStatus.OK);


        Message message = welcomeService.getWelcomeMessage(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type","text/html");


        return new ResponseEntity<String>(
                "<html><body><h1>" +
                        message.getMessage() +
                        "</h1></body></html>"
                ,responseHeaders, HttpStatus.OK);
    }




    @PostMapping(path = "velkommen/opret")      //localhost:8080/kea/velkommen/opret
    public ResponseEntity<Message> postMessage(@RequestBody Message message) {
        Message returnMessage = welcomeService.postWelcomeMessage(message);
        return new ResponseEntity<Message>(returnMessage, HttpStatus.OK);
    }


    @PutMapping(path = "velkommen/ret")     //localhost:8080/kea/velkommen/ret
    public ResponseEntity<Message> putMessage(@RequestBody Message message) {
        Message returnMessage = welcomeService.putWelcomeMessage(message);
        if (returnMessage!=null)
            return new ResponseEntity<Message>(returnMessage, HttpStatus.OK);
        else
            return new ResponseEntity<Message>(new Message(0, "Ikke fundet"), HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("velkommen/slet")
    public ResponseEntity<Message> deleteMessage(@RequestBody Message message) {
        Message returnMessage = welcomeService.deleteWelcomeMessage(message);
        return new ResponseEntity<Message>(returnMessage, HttpStatus.OK);
    }
}

}
