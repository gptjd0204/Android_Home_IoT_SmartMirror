package com.example.android_home_iot_smartmirror.ui.apicall;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_home_iot_smartmirror.R;
import com.example.android_home_iot_smartmirror.httpconnection.GetRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GetModeShadow extends GetRequest {
    final static String TAG = "AndroidMyMKR1API";
    String urlStr;
    public GetModeShadow(Activity activity, String urlStr) {
        super(activity);
        this.urlStr = urlStr;
    }

    // 충격 감지 상태 조회

    @Override
    protected void onPreExecute() {
        try {
            Log.e(TAG, urlStr);
            url = new URL(urlStr);

        } catch (MalformedURLException e) {
            Toast.makeText(activity,"URL is invalid:"+urlStr, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            activity.finish();
        }
    }

    @Override
    protected void onPostExecute(String jsonString) {
        if (jsonString == null)
            return;
        Map<String, String> state = getStateFromJSONString(jsonString);
        TextView reported_mode = activity.findViewById(R.id.reported_mode);
        //ImageView light_drawable = activity.findViewById(R.id.gas_drawable);

        // 아두이노 디바이스에 상태를 조회하여 가스밸브 상태 조회
        if (state.get("reported_MIRROR_MODE").equals("DOOR")){
            //light_drawable.setImageResource(R.drawable.gas_on);
            reported_mode.setText("현재 현관 모드입니다");
            reported_mode.setTextColor(Color.parseColor("#17c217"));
        } else {
            //light_drawable.setImageResource(R.drawable.gas_off);
            reported_mode.setText("현재 프리 모드입니다");
            reported_mode.setTextColor(Color.parseColor("#ff0000"));
        }
    }

    protected Map<String, String> getStateFromJSONString(String jsonString) {
        Map<String, String> output = new HashMap<>();
        try {
            // 처음 double-quote와 마지막 double-quote 제거
            jsonString = jsonString.substring(1,jsonString.length()-1);
            // \\\" 를 \"로 치환
            jsonString = jsonString.replace("\\\"","\"");
            Log.i(TAG, "jsonString="+jsonString);
            JSONObject root = new JSONObject(jsonString);
            JSONObject state = root.getJSONObject("state");
            JSONObject reported = state.getJSONObject("reported");
            String mirrorModeValue = reported.getString("MIRROR_MODE");
            output.put("reported_MIRROR_MODE", mirrorModeValue);

            JSONObject desired = state.getJSONObject("desired");
            String desired_mirrorModeValue = desired.getString("MIRROR_MODE");
            output.put("desired_MIRROR_MODE", desired_mirrorModeValue);


        } catch (JSONException e) {
            Log.e(TAG, "Exception in processing JSONString.", e);
            e.printStackTrace();
        }
        return output;
    }
}