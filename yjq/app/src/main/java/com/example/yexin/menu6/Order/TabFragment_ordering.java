<<<<<<< HEAD
package com.example.yexin.menu6.Order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yexin.menu6.Common.Url.Web_url;
import com.example.yexin.menu6.Order.Order;
import com.example.yexin.menu6.Index.SearchReasult;
import com.example.yexin.menu6.Index.fragmentone_stadiums_adapter;
import com.example.yexin.menu6.R;
import com.example.yexin.menu6.Sideslip.Sideslip_center.Setting.Account;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 23646 on 2019/10/31.
 */

public class TabFragment_ordering extends Fragment{

    private List<Order> mData = null;

    private JSONArray jsonArr;
    private JSONObject jsonObject=null;
    public static Fragment newInstance() {
        TabFragment_ordering fragment = new TabFragment_ordering();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        mData = new LinkedList<Order>();
        InitData(recyclerView);
       // recyclerView.setAdapter(new RecyclerAdapter((LinkedList<Order>)mData,getActivity()));

        return rootView;
    }

    public void InitData(final RecyclerView recyclerView){

        String Account="18879942330";
        RequestParams params = new RequestParams(Web_url.URL_GetReserveOrder);
        params.addHeader("Content-Type", "application/json-rpc"); //设置请求头部
        params.setAsJsonContent(true);//设置为json内容(这句个本人感觉不加也没有影响)
        try {
            jsonObject=new JSONObject();
            jsonObject.put("content",Account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        params.setBodyContent(jsonObject.toString());//添加json内容到请求参数里
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("yjq","网络请求成功order: "+result);  //接收JSON的字符串
//               HashMap<String,String> map=Web_Json.getJson(result);
                //HashMap<String,String> map=Web_Json.getJson(result);
                Log.e("yjqresult:",result.toString());
                Log.e("yjqresult:",result.length()+"");
                try{
                    //int jsonSize = result.length();//获取数据组的长度
                    jsonArr=new JSONArray(result);
                    for(int i=0;i<jsonArr.length();i++){

                        jsonObject = (JSONObject)jsonArr.getJSONObject(i);
                        Log.e("yjqresult:",i+":"+jsonObject.toString());
                        if(jsonObject.getString("pay").equals("0")) {
                            mData.add( new Order(jsonObject.getString("id"),jsonObject.getString("appointmenttime"),
                                    jsonObject.getString("type"),jsonObject.getString("site"),
                                    jsonObject.getString("time"),jsonObject.getString("place"),
                                    jsonObject.getString("money"),jsonObject.getString("pay")));
                        }
                    }
                   /*
                   * 此处不能运行*/
                }catch (Exception e){
                    e.printStackTrace();
                }
                mData.add(new Order("5155","54644846","C","抚州","8:39~10:00","6号场","￥110.00","待支付"));
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("yjq1","失败");
                Toast.makeText(getContext(), "连接超时，请查看网络连接", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("yjq","取消");
            }
            @Override
            public void onFinished() {
                Log.e("yjq","完成");
                recyclerView.setAdapter(new RecyclerAdapter((LinkedList<Order>)mData,getActivity()));

                //完成时候运行
            }
        });
    }
}
=======
package com.example.yexin.menu6.Order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yexin.menu6.Common.Url.Web_url;
import com.example.yexin.menu6.Order.Order;
import com.example.yexin.menu6.Index.SearchReasult;
import com.example.yexin.menu6.Index.fragmentone_stadiums_adapter;
import com.example.yexin.menu6.R;
import com.example.yexin.menu6.Sideslip.Sideslip_center.Setting.Account;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 23646 on 2019/10/31.
 */

public class TabFragment_ordering extends Fragment{

    private List<Order> mData = null;

    private JSONArray jsonArr;
    private JSONObject jsonObject=null;
    public static Fragment newInstance() {
        TabFragment_ordering fragment = new TabFragment_ordering();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        mData = new LinkedList<Order>();
        InitData(recyclerView);
       // recyclerView.setAdapter(new RecyclerAdapter((LinkedList<Order>)mData,getActivity()));

        return rootView;
    }

    public void InitData(final RecyclerView recyclerView){

        String Account="18879942330";
        RequestParams params = new RequestParams(Web_url.URL_GetReserveOrder);
        params.addHeader("Content-Type", "application/json-rpc"); //设置请求头部
        params.setAsJsonContent(true);//设置为json内容(这句个本人感觉不加也没有影响)
        try {
            jsonObject=new JSONObject();
            jsonObject.put("content",Account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        params.setBodyContent(jsonObject.toString());//添加json内容到请求参数里
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("yjq","网络请求成功order: "+result);  //接收JSON的字符串
//               HashMap<String,String> map=Web_Json.getJson(result);
                //HashMap<String,String> map=Web_Json.getJson(result);
                Log.e("yjqresult:",result.toString());
                Log.e("yjqresult:",result.length()+"");
                try{
                    //int jsonSize = result.length();//获取数据组的长度
                    jsonArr=new JSONArray(result);
                    for(int i=0;i<jsonArr.length();i++){

                        jsonObject = (JSONObject)jsonArr.getJSONObject(i);
                        Log.e("yjqresult:",i+":"+jsonObject.toString());
                        if(jsonObject.getString("pay").equals("0")) {
                            mData.add( new Order(jsonObject.getString("id"),jsonObject.getString("appointmenttime"),
                                    jsonObject.getString("type"),jsonObject.getString("site"),
                                    jsonObject.getString("time"),jsonObject.getString("place"),
                                    jsonObject.getString("money"),jsonObject.getString("pay")));
                        }
                    }
                   /*
                   * 此处不能运行*/
                }catch (Exception e){
                    e.printStackTrace();
                }
                mData.add(new Order("5155","54644846","C","抚州","8:39~10:00","6号场","￥110.00","待支付"));
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("yjq1","失败");
                Toast.makeText(getContext(), "连接超时，请查看网络连接", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("yjq","取消");
            }
            @Override
            public void onFinished() {
                Log.e("yjq","完成");
                recyclerView.setAdapter(new RecyclerAdapter((LinkedList<Order>)mData,getActivity()));

                //完成时候运行
            }
        });
    }
}
>>>>>>> 9f8f3bde2ef98cb76774d15524677b56858af769