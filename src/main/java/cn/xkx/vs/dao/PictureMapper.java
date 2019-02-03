package cn.xkx.vs.dao;

import cn.xkx.vs.pojo.Picture;
import cn.xkx.vs.pojo.PictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PictureMapper {
    long countByExample(PictureExample example);

    int deleteByExample(PictureExample example);

    int insert(Picture record);

    int insertSelective(Picture record);

    List<Picture> selectByExample(PictureExample example);

    int updateByExampleSelective(@Param("record") Picture record, @Param("example") PictureExample example);

    int updateByExample(@Param("record") Picture record, @Param("example") PictureExample example);
}