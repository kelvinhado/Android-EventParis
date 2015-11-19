package com.kelvinhado.eventparis.network;

import com.android.volley.Request;
import com.android.volley.Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kelvinhado.eventparis.event.DataSet;

/**
 * Created by Kelvin HADO
 * on 13/11/15
 * http://www.github.com/kelvinhado
 */

@JsonIgnoreProperties
public class EventsRequest extends JacksonRequest {

    /**
     *
     *  &refine.date_start=2015%2F03%2F06
     *  &refine?
     *
     * */


    private static final String date_start = "2015%2F03%2F06";
    private static final String row = "-1";
    private static final String sort = "-date_start";


//    private static final String url = "http://opendata.paris.fr/api/records/1.0/search?dataset=evenements-a-paris&facet=updated_at&facet=tags&facet=department&facet=region&facet=city&facet=date_start&facet=date_end&refine.date_start=2015&refine.updated_at=2015&rows=100&sort=-date_start";
    private static final String baseUrl = "http://opendata.paris.fr/api/records/1.0/search?dataset=evenements-a-paris&rows=100";
    private static final String url = baseUrl + "&date_start=" + date_start + "&rows=" + row;



    public EventsRequest(Response.Listener<DataSet> listener, Response.ErrorListener errorListener) {
        super(Request.Method.GET, url , DataSet.class, listener, errorListener);


    }

}
