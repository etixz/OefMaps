package eb.egonb.oefmaps.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import eb.egonb.oefmaps.R;
import eb.egonb.oefmaps.model.Event;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_details, container, false);

        TextView tvNaam = rootView.findViewById(R.id.tv_naam);
        TextView tvInfo = rootView.findViewById(R.id.tv_info);

        Bundle data = getArguments();
        if(data != null){
            if(data.containsKey("event")){
                Event passedEvent = (Event) data.getSerializable("event");
                tvNaam.setText(passedEvent.getNaam());
                tvInfo.setText(passedEvent.getInfo());
            }
        }

        return rootView;
    }

}
