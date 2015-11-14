package com.kelvinhado.eventparis.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kelvinhado.eventparis.R;
import com.kelvinhado.eventparis.event.Event;
import com.kelvinhado.eventparis.event.Events;

/**
 * Created by Kelvin HADO
 * on 13/11/15
 * http://www.github.com/kelvinhado
 */
public class EventsListAdapter extends ArrayAdapter {

    Events events;
    LayoutInflater mInflater;
    Context context;

    public EventsListAdapter(Context context, Events events) {
        super(context, 0, events);
        this.events = events;
        this.context = context;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.item_event_list,parent,false);
            holder = new ViewHolder();

            //holder.number = (TextView) convertView.findViewById(R.id.tvStationNumber);
            holder.eventTitle = (TextView) convertView.findViewById(R.id.tvEventTitle);
            holder.eventDateStart = (TextView) convertView.findViewById(R.id.tvEventDateStart);

            // we set a tag to our view to re-use it
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }

        Event event = events.get(position);
        holder.eventTitle.setText(event.getFields().getTitle());
        holder.eventDateStart.setText(event.getFields().getDate_start());
        return convertView;

    }

    static class ViewHolder
    {
        TextView eventTitle;
        TextView eventDateStart;
    }
}
