package eb.egonb.oefmaps.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;

import eb.egonb.oefmaps.R;
import eb.egonb.oefmaps.model.Event;
import eb.egonb.oefmaps.model.EventCategorie;
import eb.egonb.oefmaps.model.EventDAO;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {


    private MapView mapView;
    private GoogleMap myMap;


    private OnMapReadyCallback onMapReady = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            myMap = googleMap;

            LatLng coordToStartOn = new LatLng(50.859, 4.35);
            CameraUpdate moveToStartPoint = CameraUpdateFactory.newLatLngZoom(coordToStartOn, 14);

            myMap.animateCamera(moveToStartPoint);
            myMap.setOnInfoWindowClickListener(infoWindowClickListener);
            drawMarkers();
        }
    };

    private View rootView;

    public EventFragment() {
        // Required empty public constructor
    }

    private GoogleMap.OnInfoWindowClickListener infoWindowClickListener = new GoogleMap.OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {
            Bundle data = new Bundle();
            Event event = (Event) marker.getTag();
            data.putSerializable("event", event);
            Navigation.findNavController(rootView).navigate(R.id.navToDetailPage, data);
        }
    };

    private void drawMarkers(){
        for(Event event : EventDAO.getEVENTDAO().getEventList()){
            if(event.getCategorie().equals(EventCategorie.INTERACTIEF)) {
                Marker eventMarker = myMap.addMarker(new MarkerOptions().position(event.getCoords()));
                eventMarker.setTitle(event.getNaam());
                eventMarker.setSnippet(event.getInfo());
                eventMarker.setTag(event);
                eventMarker.setIcon(BitmapDescriptorFactory.defaultMarker(180));
            }
            if(event.getCategorie().equals(EventCategorie.NON_INTERACTIEF)) {
                Marker eventMarker = myMap.addMarker(new MarkerOptions().position(event.getCoords()));
                eventMarker.setTitle(event.getNaam());
                eventMarker.setSnippet(event.getInfo());
                eventMarker.setTag(event);
                eventMarker.setIcon(BitmapDescriptorFactory.defaultMarker(90));
            }
            if(event.getCategorie().equals(EventCategorie.VUURWERK)) {
                Marker eventMarker = myMap.addMarker(new MarkerOptions().position(event.getCoords()));
                eventMarker.setTitle(event.getNaam());
                eventMarker.setSnippet(event.getInfo());
                eventMarker.setTag(event);
                eventMarker.setIcon(BitmapDescriptorFactory.defaultMarker(0));
            }
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_event, container, false);

        mapView = rootView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(onMapReady);


        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
