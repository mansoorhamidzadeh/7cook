package com.example.mansoor.sevencook.a7cook;

import android.support.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.example.mansoor.sevencook.a7cook.data.Banner;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Map;

public class GsonRequest<T> extends Request<T> {
    private Gson gson = new Gson();
    private Response.Listener<T> reListener;

    // private Class<T> clazz;
    private Type type;

    public GsonRequest(int method, String url, Type type, Response.Listener<T> responceListener, @Nullable Response.ErrorListener listener) {
        super(method, url, listener);
        this.reListener = responceListener;
        this.type = type;

    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data);
            return (Response<T>) Response.success(gson.fromJson(json, type), HttpHeaderParser.parseCacheHeaders(response));

        } catch (Exception e) {
            return Response.error(new VolleyError(e));

        }

    }

    @Override
    protected void deliverResponse(T response) {

        reListener.onResponse(response);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return super.getHeaders();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        return super.getBody();
    }
}
