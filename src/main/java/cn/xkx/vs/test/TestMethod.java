package cn.xkx.vs.test;

import cn.xkx.vs.dao.HumanFlowMapper;
import cn.xkx.vs.dao.PlaceMapper;
import cn.xkx.vs.pojo.HumanFlow;
import cn.xkx.vs.pojo.Place;
import cn.xkx.vs.service.HumanFlowService;
import cn.xkx.vs.service.PlaceService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/applicationContext.xml"})
public class TestMethod {
    @Autowired
    private PlaceMapper placeMapper;

    @Autowired
    private HumanFlowMapper humanFlowMapper;

    @Test
    public void test() {
        //查出当日所有时刻的信息
        List<HumanFlow> list = humanFlowMapper.selectCurNumInfo(1);

        //查找单个地点的基本信息
        Place place = placeMapper.selectByPrimaryKey(1);

        //楼层容量
        Integer capacity = place.getCapacity();

        //当前人数
        Integer curNum = 0;
        if (!list.isEmpty())
            curNum = list.get(0).getCurnum();

        //今日最大人流量
        int maxNum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (maxNum < list.get(i).getCurnum()) {
                maxNum = list.get(i).getCurnum();
            }
        }

        //今日最小人流量
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (minNum > list.get(i).getCurnum()) {
                minNum = list.get(i).getCurnum();
            }
        }
//上座率
        float attendance = (float) curNum / (float) capacity;
        System.out.println("capacity" + capacity);
        System.out.println("curNum" + curNum);
        System.out.println("maxNum" + maxNum);
        System.out.println("minNum" + minNum);
        System.out.println(attendance);
    }
}
