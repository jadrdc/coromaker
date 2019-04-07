package agustinreinoso.com.coromaker.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "events")
public class Event {
    @PrimaryKey
    private long id;
    private String description;
    private Date date;
    private long lat;
    private long lng;
    private String usernameOwner;

    public String getUsernameOwner() {
        return usernameOwner;
    }

    public void setUsernameOwner(String usernameOwner) {
        this.usernameOwner = usernameOwner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLng() {
        return lng;
    }

    public void setLng(long lng) {
        this.lng = lng;
    }
}
