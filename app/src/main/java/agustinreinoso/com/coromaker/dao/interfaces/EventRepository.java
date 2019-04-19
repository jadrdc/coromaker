package agustinreinoso.com.coromaker.dao.interfaces;

import agustinreinoso.com.coromaker.model.Event;
import android.arch.lifecycle.LiveData;

import java.util.Date;
import java.util.List;

public  interface EventRepository {
    long  save(Event event);
    LiveData<List<Event>> getEvents(Date startdate,Date endate);
    List<Event> getEvents();
}
