package agustinreinoso.com.coromaker.viewmodels;

import agustinreinoso.com.coromaker.dao.impl.EventRoomRepository;
import agustinreinoso.com.coromaker.dao.interfaces.EventRepository;
import agustinreinoso.com.coromaker.model.Event;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class EventCreationViewModel extends AndroidViewModel {

    private EventRepository repository;
    private LiveData<List<Event>> listEvents;

    public MutableLiveData<Boolean> getInProgress() {
        return inProgress;
    }

    private MutableLiveData<Boolean> inProgress = new MutableLiveData<>();

    public EventCreationViewModel(@NonNull Application application) {
        super(application);
    }


    public void saveEvent(final Event event) {

        try {
            Thread.sleep(5000);
            if (repository == null) {
                repository = new EventRoomRepository(getApplication());
            }

            repository.save(event);

            inProgress.postValue(false);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
