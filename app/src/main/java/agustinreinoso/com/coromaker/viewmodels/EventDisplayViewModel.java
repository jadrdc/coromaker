package agustinreinoso.com.coromaker.viewmodels;

import agustinreinoso.com.coromaker.dao.impl.EventRoomRepository;
import agustinreinoso.com.coromaker.dao.interfaces.EventRepository;
import agustinreinoso.com.coromaker.model.Event;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.Date;
import java.util.List;

public class EventDisplayViewModel extends AndroidViewModel {


    private MutableLiveData<List<Event>> listEvents;
    private EventRepository repository;

    public EventDisplayViewModel(@NonNull Application application) {
        super(application);
    }

    public void setEvents(final Date datefrom, final Date dateto) {

        if (repository == null) {
            repository = new EventRoomRepository(getApplication());
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                listEvents.setValue(repository.getEvents(datefrom, dateto).getValue());
            }
        }).start();


    }


}
