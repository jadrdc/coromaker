package agustinreinoso.com.coromaker.views;


import agustinreinoso.com.coromaker.R;
import agustinreinoso.com.coromaker.adapters.EventListAdapter;
import agustinreinoso.com.coromaker.model.Event;
import agustinreinoso.com.coromaker.viewmodels.EventDisplayViewModel;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventListFragment extends Fragment {

    private EventDisplayViewModel eventDisplayViewModel;
    private RecyclerView recyclerView;
    public EventListAdapter adapter;

    public EventListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        eventDisplayViewModel = ViewModelProviders.of(getActivity()).get(EventDisplayViewModel.class);
        View layout = inflater.inflate(R.layout.fragment_event_list, container, false);

        recyclerView = layout.findViewById(R.id.event_list_recycle);
        adapter = new EventListAdapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        eventDisplayViewModel.getListEvents().observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(@Nullable List<Event> events) {
                adapter.addEvents(events);
                Toast.makeText(getContext(),"ENTRO EN OBSERVSER",Toast.LENGTH_LONG).show();
            }
        });

        eventDisplayViewModel.getEvents();

        return layout;
    }

}
