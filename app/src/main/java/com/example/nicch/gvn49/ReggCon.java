package com.example.nicch.gvn49;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nicch on 4/3/18.
 */

public class ReggCon extends StringRequest {
    private static final String Writa_Url="https://muruakyone.000webhostapp.com/Gvn49/New.php";
    //private static final String Writa_Url="http://192.168.42.125/G49/New.php";
    private Map<String, String> params;
    public ReggCon(String nms,String Usrn,String eml,int Phon, String Regg, String pwdd, Response.Listener<String> listener)
    {
        super(Request.Method.POST,Writa_Url,listener,null);
        params=new HashMap<>();

        params.put("Name",nms);
        params.put("Username",Usrn);
        params.put("Email",eml);
        params.put("Phone",Phon+"");
        params.put("Region",Regg);
        params.put("Password",pwdd);

    }
    public Map<String, String> getParams()
    {
        return params;
    }
}
