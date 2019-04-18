package agustinreinoso.com.coromaker.adapters;

import agustinreinoso.com.coromaker.R;
import agustinreinoso.com.coromaker.model.Event;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {

    Context app;
    List<Event> events;

    public EventListAdapter(Context context) {
        app = context;
        events = new ArrayList<>();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(app).inflate(R.layout.fragment_event_list, viewGroup, false);
        EventViewHolder holder = new EventViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder eventViewHolder, int i) {
        eventViewHolder.setView(events.get(i));

    }

    @Override
    public int getItemCount() {
        return events.size();
    }
    public void addEvents(List<Event> eventsList) {
        this.events = eventsList;
        notifyDataSetChanged();
    }
    public class EventViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtDate;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.event_name);
            txtDate = itemView.findViewById(R.id.event_date);
        }

        public void setView(Event event) {
            txtName.setText(event.getDescription());
            txtDate.setText(event.getDate().toString());
        }

    }
}
