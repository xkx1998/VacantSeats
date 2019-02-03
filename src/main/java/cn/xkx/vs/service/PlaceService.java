package cn.xkx.vs.service;

import cn.xkx.vs.dao.PlaceMapper;
import cn.xkx.vs.pojo.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceMapper placeMapper;
    /**
     * 查找所有可用地点
     * @return
     */
    public List<Place> getAll() {
        return placeMapper.selectAllEnable();
    }

    /**
     * 根据地点Id查找
     * @param placeid
     * @return
     */
    public Place getByPlaceId(Integer placeid) {
        return placeMapper.selectByPrimaryKey(placeid);
    }
}
