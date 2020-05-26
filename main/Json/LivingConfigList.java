package Json;

import Util.DFormatEnum;
import Util.DateTimeUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author tangdongfan
 * @date 2020/5/12 17:13
 */
public class LivingConfigList {
    public static void main(String[] args) {
        String livingConfigList = "[{\"dateId\":\"20200514\",\"tabId\":4},{\"dateId\":\"20200512\",\"tabId\":2},{\"dateId\":\"20200513\",\"tabId\":3},{\"dateId\":\"20200511\",\"tabId\":1}]";
        List<LivingConfigDto> livingConfigDtoList = JSON.parseArray(livingConfigList, LivingConfigDto.class);

        /*livingConfigDtoList.sort(Comparator.comparing(LivingConfigDto::getDateId));
        for (LivingConfigDto l:livingConfigDtoList) {
            System.out.println(l.toString());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(new Date()));

        System.out.println("20200511".compareTo("20200511"));*/

        TreeMap<String, LivingConfigDto> livingConfigMap = new TreeMap<>();
        for (LivingConfigDto l:livingConfigDtoList) {
            livingConfigMap.put(l.getDateId(), l);
        }
        System.out.println(livingConfigMap);
        /*System.out.println(livingConfigMap.firstKey());
        System.out.println(livingConfigMap.lastKey());*/

        String[] dateIds = {"20200501","20200513","20200516"};
        String liveStartTime = livingConfigMap.firstKey();
        String liveEndTime = livingConfigMap.lastKey();
        for (String dateId:dateIds) {
            if (dateId.compareTo(liveStartTime)<0) {
                System.out.println(dateId + ": " + livingConfigMap.get(liveStartTime).getTabId());
            } else if (dateId.compareTo(liveEndTime)>0) {
                System.out.println(dateId + ": " + livingConfigMap.get(liveEndTime).getTabId());
            } else {
                System.out.println(dateId + ": " + livingConfigMap.get(dateId).getTabId());
            }
        }

        String result = "{\"code\":0,\"data\":{\"bizCode\":0,\"bizMsg\":\"Success\",\"result\":true},\"msg\":\"调用成功\"}";
        JSONObject resultJson = JSON.parseObject(result);
        System.out.println(resultJson.get("data"));


        System.out.println(new Boolean(true).equals("true"));   //false
    }
}
