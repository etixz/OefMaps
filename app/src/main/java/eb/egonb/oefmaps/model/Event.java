package eb.egonb.oefmaps.model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class Event implements Serializable {

    private String naam;
    private String info;
    private LatLng coords;
    private Enum<EventCategorie> categorie;

    public Event(String naam, String info, LatLng coords, Enum<EventCategorie> categorie) {
        this.naam = naam;
        this.info = info;
        this.coords = coords;
        this.categorie = categorie;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public LatLng getCoords() {
        return coords;
    }

    public void setCoords(LatLng coords) {
        this.coords = coords;
    }

    public Enum<EventCategorie> getCategorie() {
        return categorie;
    }

    public void setCategorie(Enum<EventCategorie> categorie) {
        this.categorie = categorie;
    }
}
