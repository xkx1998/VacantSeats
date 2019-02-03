package cn.xkx.vs.dao;

import cn.xkx.vs.pojo.HumanFlow;
import cn.xkx.vs.pojo.HumanFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HumanFlowMapper {
    long countByExample(HumanFlowExample example);

    int deleteByExample(HumanFlowExample example);

    int insert(HumanFlow record);

    int insertSelective(HumanFlow record);

    List<HumanFlow> selectByExample(HumanFlowExample example);

    int updateByExampleSelective(@Param("record") HumanFlow record, @Param("example") HumanFlowExample example);

    int updateByExample(@Param("record") HumanFlow record, @Param("example") HumanFlowExample example);

    //根据地点Id查找当前某一时刻人流信息，按时间从最近更新时间开始
    List<HumanFlow> selectCurNumInfo(Integer placeid);
}