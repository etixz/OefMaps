package eb.egonb.oefmaps.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class EventDAO {

    private ArrayList<Event> eventList;

    private static final EventDAO EVENTDAO= new EventDAO();

    public EventDAO() {
    }

    public ArrayList<Event> getEventList(){
        if(eventList == null){
            eventList = new ArrayList<>();
            eventList.add(new Event("Kaaitheater", "Op deze locatie vaart elk uur een boot rond met vuurwerk", new LatLng(50.858712, 4.347446), EventCategorie.VUURWERK));
            eventList.add(new Event("Maximiliaan Park", "Interactieve projectie!", new LatLng(50.860215, 4.350880), EventCategorie.INTERACTIEF));
            eventList.add(new Event("Magasin4", "Lasershow op muziek, pew pew pew!", new LatLng(50.863994, 4.349828), EventCategorie.NON_INTERACTIEF));
            eventList.add(new Event("Grote Markt", "Het gebouw wordt belicht om de geschiedenis van Brussel voor te stellen", new LatLng(50.846777, 4.352360), EventCategorie.NON_INTERACTIEF));
        }
        return eventList;
    }

    public static EventDAO getEVENTDAO(){
        return EVENTDAO;
    }
}
