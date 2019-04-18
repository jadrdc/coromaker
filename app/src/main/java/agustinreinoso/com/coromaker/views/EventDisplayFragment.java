package agustinreinoso.com.coromaker.views;

import agustinreinoso.com.coromaker.R;
import agustinreinoso.com.coromaker.viewmodels.EventDisplayViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EventDisplayFragment extends Fragment {

    private EventDisplayViewModel eventDisplayViewModel;

    public EventDisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        eventDisplayViewModel = ViewModelProviders.of(getActivity()).get(EventDisplayViewModel.class);
        return inflater.inflate(R.layout.fragment_event_display, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
