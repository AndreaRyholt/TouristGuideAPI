package tourism.service;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.ArrayList;

@Service
public class TouristService {

        private TouristRepository repository;

        public TouristService() {
            repository = new TouristRepository();
        }

        public ArrayList<TouristAttraction> getAllAttractions(String name)  {
            return repository.getAttractionsName(name);
        }

        public ArrayList getAttractions(String name)  {
            return repository.getAttractionsName(name);
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
