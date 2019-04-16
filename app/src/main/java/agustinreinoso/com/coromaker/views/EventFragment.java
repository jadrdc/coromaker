package agustinreinoso.com.coromaker.views;


import agustinreinoso.com.coromaker.R;
import agustinreinoso.com.coromaker.model.Event;
import agustinreinoso.com.coromaker.viewmodels.EventCreationViewModel;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {


    @BindView(R.id.button_save)
    Button btnSave;
    @BindView(R.id.edit_name)
    EditText editTextName;
    DatePicker datePicker;
    ProgressBar progressBar;
    private EventCreationViewModel eventCreationViewModel;

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.event_popup, container, false);
        ButterKnife.bind(this, view);

        progressBar = view.findViewById(R.id.progress);
        progressBar.setVisibility(View.INVISIBLE);
        datePicker = view.findViewById(R.id.date_event);
        if (eventCreationViewModel == null) {
            eventCreationViewModel = ViewModelProviders.of(this).get(EventCreationViewModel.class);
        }
        eventCreationViewModel.getInProgress().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                int visible;
                if (aBoolean) {
                    visible = View.VISIBLE;
                } else {
                  Toast.makeText(getContext(),"SE HA GUARDADO EL NUEVO EVENTO",Toast.LENGTH_LONG).show();
                    visible = View.INVISIBLE;

                }
                progressBar.setVisibility(visible);
            }
        });

        return view;
    }

    @OnClick(R.id.button_save)
    public void onClickSave(View view) {
        eventCreationViewModel.getInProgress().setValue(true);

        final Event event = new Event();
        event.setDescription(editTextName.getText().toString());
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();
        SimpleDateFormat format = new SimpleDateFormat("ddmmyyyy");
        Date date = null;
        try {
            date = format.parse(String.valueOf(day) + String.valueOf(month) + String.valueOf(year));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        event.setDate(date);
        new Thread(new Runnable() {
            @Override
            public void run() {
                eventCreationViewModel.saveEvent(event);

            }
        }).start();
    }

}
