package cc.mrbird.febs.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Prock.Liy
 * @Date 2021/3/16 15:23
 * @Descripttion
 * @Version 1.0
 */
public class LotusUtil {

    /**
     * 困惑点集合调用
     * @return
     */
    public static List<String> confused(){
        List<String> confusedList = new ArrayList<>();
        confusedList.add("上台紧张怯场忘词");
        confusedList.add("上台发言没话说");
        confusedList.add("上台发言没条理");
        confusedList.add("上台发言没重点");
        confusedList.add("演讲缺少感染力");
        confusedList.add("演讲缺少营销力");
        confusedList.add("演讲没有说服力");
        confusedList.add("演讲没有领导影响力");
        return confusedList;
    }

    /**
     * 地区调用
     * @return
     */
    public static List<String> area(){
        List<String> areaList = new ArrayList<>();
        areaList.add("广州");
        areaList.add("深圳");
        areaList.add("珠海");
        areaList.add("上海");
        areaList.add("杭州");
        areaList.add("郑州");
        areaList.add("济南");
        areaList.add("长沙");
        return areaList;
    }
}
