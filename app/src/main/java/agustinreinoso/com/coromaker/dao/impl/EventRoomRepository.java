package agustinreinoso.com.coromaker.dao.impl;


import agustinreinoso.com.coromaker.confg.RoomDB;
import agustinreinoso.com.coromaker.dao.interfaces.EventRepository;
import agustinreinoso.com.coromaker.model.Event;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.Date;
import java.util.List;

public class EventRoomRepository implements EventRepository {

    private RoomDB db;

    public EventRoomRepository(Context context)

    {
        db = Room.databaseBuilder(context, RoomDB.class, RoomDB.DB_NAME).fallbackToDestructiveMigration().build();

    }

    @Override
    public long  save(final Event event) {
      return   db.getEventDao().save(event);
    }

    @Override
    public LiveData<List<Event>> getEvents(Date startdate, Date endate) {
        return db.getEventDao().getEvents(startdate,endate);
    }

    @Override
    public List<Event> getEvents() {
        return db.getEventDao().getEvents();
    }
}
