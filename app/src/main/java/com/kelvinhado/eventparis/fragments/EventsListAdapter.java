package com.kelvinhado.eventparis.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kelvinhado.eventparis.R;
import com.kelvinhado.eventparis.event.Event;
import com.kelvinhado.eventparis.event.Events;
import com.kelvinhado.eventparis.network.ImageDownloaderTask;

import java.io.InputStream;

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
            holder.eventTitle = (TextView) convertView.findViewById(R.id.tvEventTitle);
            holder.eventSpaceTimeInfo = (TextView) convertView.findViewById(R.id.tvEventSpaceTimeInfo);
            holder.eventDescription = (TextView) convertView.findViewById(R.id.tvEventDescription);
            holder.eventPrice = (TextView) convertView.findViewById(R.id.tvEventPrice);
            holder.eventImgThumb = (ImageView) convertView.findViewById(R.id.imgEventThumb);

            // we set a tag to our view to re-use it
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }

        /** we fill our views in this area

         */
        // TODO use link to String.xml folder instead of strong written
        Event event = events.get(position);
        holder.eventTitle.setText(event.getFields().getTitle());
        holder.eventSpaceTimeInfo.setText(event.getFields().getSpace_time_info());
        holder.eventDescription.setText("Description : " + event.getFields().getDescription());

        // displaying the price
        String eventPrice = event.getFields().getPricing_info();
        if(eventPrice == null || eventPrice.equals("0")) {
            holder.eventPrice.setText("");
        }
        else {
            holder.eventPrice.setText("Price : " + eventPrice);
        }


        if (holder.eventImgThumb != null) {
//            new ImageDownloaderTask(holder.eventImgThumb).execute(event.getFields().getImage_thumb());
        }


        return convertView;

    }

    static class ViewHolder
    {
        TextView eventTitle;
        TextView eventSpaceTimeInfo;
        TextView eventDescription;
        TextView eventPrice;
        ImageView eventImgThumb;
    }

}
