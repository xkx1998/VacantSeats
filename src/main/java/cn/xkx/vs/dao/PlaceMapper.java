package cn.xkx.vs.dao;

import cn.xkx.vs.pojo.Place;
import cn.xkx.vs.pojo.PlaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlaceMapper {
    long countByExample(PlaceExample example);

    int deleteByExample(PlaceExample example);

    int deleteByPrimaryKey(Integer placeid);

    int insert(Place record);

    int insertSelective(Place record);

    List<Place> selectByExample(PlaceExample example);

    List<Place> selectAllEnable();

    Place selectByPrimaryKey(Integer placeid);

    int updateByExampleSelective(@Param("record") Place record, @Param("example") PlaceExample example);

    int updateByExample(@Param("record") Place record, @Param("example") PlaceExample example);

    int updateByPrimaryKeySelective(Place record);

    int updateByPrimaryKey(Place record);
}