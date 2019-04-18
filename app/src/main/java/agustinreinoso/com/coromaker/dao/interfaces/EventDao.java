package agustinreinoso.com.coromaker.dao.interfaces;

import agustinreinoso.com.coromaker.model.Event;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface EventDao {
    @Insert
    void save(Event event);

    @Query("Select * from events e where e.date between :startdate and :endate")
    LiveData<List<Event>> getEvents(Date startdate , Date endate);
    @Query("Select * from events e")
    LiveData<List<Event>> getEvents();
}
