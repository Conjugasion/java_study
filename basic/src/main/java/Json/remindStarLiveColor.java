package Json;

import com.alibaba.fastjson.JSONObject;

/**
 * @author tangdongfan
 * @date 2020/5/28 14:36
 */
public class remindStarLiveColor {
    public static void main(String[] args) {
        String result = "{\"code\":0,\"data\":[{\"bizCode\":0,\"bizMsg\":\"Success\",\"result\":true}],\"msg\":\"调用成功\"}";
        JSONObject parseObject = JSONObject.parseObject(result);
        System.out.println(parseObject.getJSONArray("data").getJSONObject(0).getString("result"));
    }
}
