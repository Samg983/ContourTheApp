package swarm_app_3.ehb.com.contourtheapp.Webservice;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bram Schrooyen.
 */

public class SimpleWebrequest<ReturnType> extends Request<ReturnType> {
    private Response.Listener<ReturnType> uitvoerenIndienGeslaagd;
    protected Object teVerzendenObjectAlsJson;
    protected Map<String, String> teVerzendenParameters;
    private java.lang.reflect.Type returnType;

    public SimpleWebrequest(int requestMethod, String url, java.lang.reflect.Type returnType, Response.Listener<ReturnType> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(requestMethod, url, uitvoerenIndienNietGeslaagd);
        //Het object met daarin de methode die moet worden uitgevoerd indien de request geslaagd is
        this.uitvoerenIndienGeslaagd = uitvoerenIndienGeslaagd;
        this.returnType = returnType;
    }


    @Override
    protected void deliverResponse(ReturnType response) {
        uitvoerenIndienGeslaagd.onResponse(response);
    }


    @Override
    protected Response<ReturnType> parseNetworkResponse(NetworkResponse response) {
        ReturnType resultaat;
        try {
            String responseAlsString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));

            if (this.returnType.equals(String.class)) {
                resultaat = (ReturnType) responseAlsString;
            } else {
                //We gaan ervan uit dat we JSON terug krijgen
                Gson mijnGson = new Gson();
                resultaat = mijnGson.fromJson(responseAlsString, this.returnType);
            }
            return Response.success(resultaat, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> mijnParameters = super.getParams();
        if (mijnParameters == null) {
            mijnParameters = new HashMap<String, String>();
        }
        if (teVerzendenParameters != null) {
            mijnParameters.putAll(teVerzendenParameters);
        }
        return mijnParameters;
    }

    @Override
    public String getUrl() {
        String url = super.getUrl();
        if (this.getMethod() == Method.GET) {
            try {
                Map<String, String> mijnParameters = this.getParams();
                if (!mijnParameters.isEmpty()) {
                    url = url + "?";
                    for (Map.Entry<String, String> huidigeParameter : mijnParameters.entrySet()) {
                        url = url + huidigeParameter.getKey() + "=" + URLEncoder.encode(huidigeParameter.getValue(), "UTF-8") + "&";
                    }
                    url = url.substring(0, url.length() - 1);
                }
            } catch (AuthFailureError authFailureError) {
                authFailureError.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    @Override
    public String getBodyContentType() {
        if (teVerzendenObjectAlsJson != null) {
            return "application/json; charset=UTF-8";
        } else {
            return super.getBodyContentType();
        }
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        if (teVerzendenObjectAlsJson != null) {
            Gson gson = new Gson();
            String json = gson.toJson(teVerzendenObjectAlsJson);
            try {
                return json.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
        return super.getBody();
    }
}
