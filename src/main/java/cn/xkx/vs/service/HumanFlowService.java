package cn.xkx.vs.service;

import cn.xkx.vs.dao.HumanFlowMapper;
import cn.xkx.vs.pojo.HumanFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanFlowService {

    @Autowired
    private HumanFlowMapper humanFlowMapper;

    /**
     * 返回今日全部记录时刻的人流量信息
     * @return
     */
    public List<HumanFlow> selectCurNumInfo(Integer placeid) {
       return humanFlowMapper.selectCurNumInfo(placeid);
    }

}
