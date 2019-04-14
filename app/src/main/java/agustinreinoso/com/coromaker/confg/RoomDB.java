package agustinreinoso.com.coromaker.confg;

import agustinreinoso.com.coromaker.dao.converters.DateConverter;
import agustinreinoso.com.coromaker.dao.interfaces.EventDao;
import agustinreinoso.com.coromaker.model.Event;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

@TypeConverters({DateConverter.class})
@Database(entities = {Event.class}, version = 2, exportSchema = true)
public abstract class RoomDB extends RoomDatabase {
    public static String DB_NAME = "events_db";

    public abstract EventDao getEventDao();
}
