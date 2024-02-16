package com.example.tourism.service;

import com.example.tourism.model.TouristAttraction;
import com.example.tourism.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TouristService {

    private TouristRepository repository;

    public TouristService() {
        repository = new TouristRepository();
    }

    public ArrayList<TouristAttraction> getAllAttractions()  {
        return repository.getAttractionsList();
    }

    public ArrayList getAttractionsName(String name){
        return repository.getAttractionsName(name);
    }

    public ArrayList getAttractionsDescription(String description) {
        return repository.getAttractionsDescription(description);
    }

    public TouristAttraction postAttraction(TouristAttraction attraction) {
        return  repository.addAttraction(attraction);
    }

    public TouristAttraction putAttractions(TouristAttraction attraction) {
        return repository.updateAttraction(attraction);
    }


    public TouristAttraction deleteAttraction(String name){
        return repository.deleteAttraction(name);

    }

}
