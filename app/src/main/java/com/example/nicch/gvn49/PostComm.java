package com.example.nicch.gvn49;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nicch on 4/3/18.
 */

public class PostComm extends StringRequest {
    private static final String Writa_Url="https://muruakyone.000webhostapp.com/Gvn49/Input.php";
    //private static final String Writa_Url="http://192.168.43.240/Brk01/NewUserFella.php";
    private Map<String, String> params;
    public PostComm(int phon,String tim, String cat, String Mess, String rep, String Vwd, Response.Listener<String> listener)
    {
        super(Request.Method.POST,Writa_Url,listener,null);
        params=new HashMap<>();
        params.put("Phone",phon+"");
        params.put("Time",tim);
        params.put("Category",cat);
        params.put("Message",Mess);
        params.put("Reply",rep);
        params.put("View",Vwd);


    }
    public Map<String, String> getParams()
    {
        return params;
    }
}//phon,tim,cat,Mess,rep,Vwd