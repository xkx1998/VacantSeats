package cn.xkx.vs.controller;

import cn.xkx.vs.pojo.Message;
import cn.xkx.vs.pojo.Place;
import cn.xkx.vs.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    /**
     * 查找所有已经启用的地点
     *
     * @return
     */
    @RequestMapping("/getAll")
    @ResponseBody
    public Message getAll() {
        System.out.println("=======================================================");
        List<Place> places = placeService.getAll();
        System.out.println("=======================================================" + places.size());
        return Message.success().add("places", places);
    }

}
