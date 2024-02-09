package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;

@Repository
public class TouristRepository {
        private ArrayList<TouristAttraction> attractionsList = new ArrayList<>();

        public void TouristRepository() {
            /*this.attractionsList = new ArrayList<TouristAttraction>();*/
            attractionsList.add(new TouristAttraction("Tivoli", "Stor forlystelsespark i midten af København."));
            attractionsList.add( new TouristAttraction("Den Lille Havfrue", "En havfrue på en sten, fra H. C. Andersens kendte eventyr 'Den lille Havfrue'."));
            attractionsList.add(new TouristAttraction("Djurs Sommerland", "Forlystelsespark for små børn."));
            attractionsList.add(new TouristAttraction("Glyptoteket", "Kunstmuseum i København."));
            attractionsList.add( new TouristAttraction("Bakken", "Danmarks ældste forlystelsespark."));
        }

    /*public void AddAttraction(String name, String description) {
        TouristAttraction attraction = new TouristAttraction(name, description);
        attractionsList.add(attraction);
    }*/

    public ArrayList getAttractionsName(String name) {
        return attractionsList;
    }

    public ArrayList getAttractionsDescription(String description) {
        return attractionsList;
    }

    public ArrayList getAttractionsList() {
        return attractionsList;
    }

    public void addAttraction(TouristAttraction attraction){
        attractionsList.add(attraction);
    }

    public void deleteAttraction(){
        int index = -1;
        
    }
}
