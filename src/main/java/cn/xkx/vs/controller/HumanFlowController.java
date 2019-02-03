package cn.xkx.vs.controller;

import cn.xkx.vs.pojo.HumanFlow;
import cn.xkx.vs.pojo.Message;
import cn.xkx.vs.pojo.Place;
import cn.xkx.vs.service.HumanFlowService;
import cn.xkx.vs.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import java.util.List;

@Controller
@RequestMapping("/humanflow")
public class HumanFlowController {

    @Autowired
    private HumanFlowService humanFlowService;

    @Autowired
    private PlaceService placeService;

    @RequestMapping("getByPlaceId")
    @ResponseBody
    public Message getByPlaceId(@RequestParam(value = "placeid", defaultValue = "1") Integer placeid) {

        //查出当日所有时刻的信息
        List<HumanFlow> list = humanFlowService.selectCurNumInfo(placeid);

        //查找单个地点的基本信息
        Place place = placeService.getByPlaceId(placeid);

        //楼层容量
        Integer capacity = place.getCapacity();

        //当前人数
        Integer curNum = 0;
        if (!list.isEmpty())
          curNum = list.get(0).getCurnum();
        //总人数
        int sum = 0;
        for (HumanFlow humanFlow:list) {
            sum += humanFlow.getCurnum();
        }


        //平均人数
        int avgNum = sum/list.size();

        //今日最大人流量
        int maxNum = 0;
        for(int i = 0; i < list.size();i++) {
            if(maxNum < list.get(i).getCurnum()){
                maxNum = list.get(i).getCurnum();
            }
        }

        //今日最小人流量
        int minNum = Integer.MAX_VALUE;
        for(int i = 0; i < list.size();i++) {
            if(minNum > list.get(i).getCurnum()){
                minNum = list.get(i).getCurnum();
            }
        }

        DecimalFormat format2 = new DecimalFormat( "0.00 ");

        //上座率
        double attendance = (float)curNum/(float)capacity * 100;
        attendance = Double.parseDouble(format2.format(attendance));

        //最多人数占比
        double maxNumPro = (float)maxNum/(float)capacity * 100;
        maxNumPro = Double.parseDouble(format2.format(maxNumPro));

        //最少人数占比
        double minNumPro = (float)minNum/(float)capacity * 100;
        minNumPro = Double.parseDouble(format2.format(minNumPro));

        //平均人数占比
        double avgNumPro = (float)avgNum/(float)capacity * 100;
        avgNumPro = Double.parseDouble(format2.format(avgNumPro));

        //拥挤程度Congestion level
        String clevel = "";
        if(attendance>=0 && attendance <= 30) {
            clevel = "非常空闲(建议前往)";
        }
        if(attendance>30 && attendance <= 50) {
            clevel = "比较空闲(建议前往)";
        }
        if(attendance>50 && attendance <= 60) {
            clevel = "适中(建议前往)";
        }
        if(attendance>60 && attendance <= 80) {
            clevel = "较为拥挤(可以考虑前往)";
        }
        if(attendance>80 && attendance <= 100) {
            clevel = "非常拥挤(建议换个地方)";
        }


        return Message.success().add("capacity",capacity)
                .add("curNum",curNum).add("maxNum",maxNum)
                .add("minNum",minNum).add("attendance",attendance)
                .add("clevel",clevel).add("maxNumPro",maxNumPro)
                .add("minNumPro",minNumPro).add("avgNumPro",avgNumPro);
    }
}
