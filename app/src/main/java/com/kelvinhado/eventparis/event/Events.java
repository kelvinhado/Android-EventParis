package com.kelvinhado.eventparis.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelvin HADO
 * on 13/11/15
 * http://www.github.com/kelvinhado
 */
public class Events extends ArrayList<Event> {

    /**
     * @param eventId : the id of the event we want to get
     * @return the of the list that have the same Id as the one provided
     */
    public Event findEventById(String eventId) {
        for(Event event : this) {
            if(event.getRecordid().equals(eventId)) {
                return event;
            }
        }
        return null;
    }

}
