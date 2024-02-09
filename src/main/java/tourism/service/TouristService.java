package tourism.service;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.ArrayList;

@Service
public class TouristService {

        // Stub implementering
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

        public Message postWelcomeMessage(Message message) {
            Message returnMessage = repository.addMessage(message);
            // her kunne server tilføje eksytra attributter, f.eks dato for oprettelse
            return returnMessage;
        }

        public Message putWelcomeMessage(Message message) {
            Message returnMessage = repository.changeMessage(message);
            return returnMessage;
        }

        public Message deleteWelcomeMessage(Message message) {
            Message returnMessage = repository.deleteMessage(message);
            if (returnMessage != null)
                return returnMessage;
            else return new Message("Ikke fundet");
        }

    }



}
