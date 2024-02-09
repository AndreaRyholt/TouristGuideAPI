package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;
import tourism.service.TouristService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/attractions") //localhost:8080/attractions
public class TouristController {
    TouristRepository tr = new TouristRepository();
    TouristService ts = new TouristService();
    private ArrayList<TouristRepository> attractionList;
    //TouristAttraction ta = new TouristAttraction();


   /* @GetMapping(path = "velkommen")
    public ResponseEntity<List<Message>> getAttractions() {
        List attractionsList = welcomeService.getWelcomeMessages();
        return new ResponseEntity<List<Message>>(messageList, HttpStatus.OK);
    }*/

    /** SHOW ALL ATTRACTIONS**/
    //@GetMapping("/show-all-attractions")
    public ResponseEntity<ArrayList<TouristAttraction>> showAllAttractions(String name){
        return new ResponseEntity<>(tr.getAttractionsName(name), HttpStatus.OK);
    }

   /* @GetMapping("/tivoli")
    @ResponseBody
    public ArrayList tivoli(String description){

        //attraction skal findes i listen
        return tr.getAttractionsList(description);
    }

    @GetMapping("/djurs-sommerland")
    @ResponseBody
    public ArrayList tivoli(String description){
        return tr.getAttractionsList(description);
    }

    @GetMapping("/glyptoteket")
    @ResponseBody
    public ArrayList tivoli(String description){
        return tr.getAttractionsList(description);
    }

    @GetMapping("/den-lille-havfrue")
    @ResponseBody
    public ArrayList tivoli(String description){
        return tr.getAttractionsList(description);
    }

    @GetMapping("/bakken")
    @ResponseBody
    public ArrayList tivoli(String description){
        return tr.getAttractionsList(description);
    }*/










}
