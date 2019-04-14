package agustinreinoso.com.coromaker.dao.interfaces;

import agustinreinoso.com.coromaker.model.Event;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EventDao {
    @Insert
    void save(Event event);

    @Query("Select * from events")
    LiveData<List<Event>> getEvents();

}