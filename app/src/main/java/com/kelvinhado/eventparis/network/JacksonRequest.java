package com.kelvinhado.eventparis.network;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Kelvin HADO
 * on 13/11/15
 * http://www.github.com/kelvinhado
 */

@JsonIgnoreProperties
public class JacksonRequest<T> extends Request<T> {
    private final ObjectMapper objectMapper;
    private final Class<T> mClazz;
    private final Response.Listener<T> mListener;

    public JacksonRequest(int method, String url, Class<T> clazz,
                          Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mClazz = clazz;
        this.mListener = listener;
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public JacksonRequest(int method, String url, Class<T> clazz,
                          Response.Listener<T> listener, Response.ErrorListener errorListener, ObjectMapper objectMapper) {
        super(method, url, errorListener);
        this.mClazz = clazz;
        this.mListener = listener;
        this.objectMapper = objectMapper;
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

        Log.d("reponse ", response.toString());

        try {
            String json = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(objectMapper.readValue(json, mClazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonMappingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonParseException e) {
            return Response.error(new ParseError(e));
        } catch (IOException e) {
            return Response.error(new ParseError(e));
        }
    }
}
