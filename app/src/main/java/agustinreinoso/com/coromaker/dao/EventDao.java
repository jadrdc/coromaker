package agustinreinoso.com.coromaker.dao;

import agustinreinoso.com.coromaker.model.Event;
import android.arch.persistence.room.Query;

public interface EventDao {

    Event getEvents(long id);
}
