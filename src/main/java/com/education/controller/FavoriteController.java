package com.education.controller;

import com.education.domain.dto.FavoriteDTO;
import com.education.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class FavoriteController {

    @Autowired
    private IFavoriteService iFavoriteService;

    //@GetMapping("/favorite/getList/{userId}/{type}/{subjectId}/{page}/{pageLine}/{tagId}")
    //http://localhost:8081/favorite/getList?userId=119&type=1&subjectId=1&page=1&pageLine=10
    @GetMapping("/favorite/getList")
    public Map<String, Object> findFavoriteList(
            @RequestParam(value = "userId") Integer userId,
            @RequestParam(value = "type") Integer type,
            @RequestParam(value = "subjectId") Integer subjectId,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pageLine", required = false, defaultValue = "10") Integer pageLine,
            @RequestParam(value = "tagId", required = false, defaultValue = "0") Integer tagId

    ) {
        System.out.println(type);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<FavoriteDTO> dataList = iFavoriteService.getAllFavorites(userId, type, subjectId, page, pageLine, tagId);

            if (null != dataList) {
                map.put("code", 200);
                map.put("data", dataList);
            } else {
                map.put("code", 502);
                map.put("msg", "参数有误~");
            }

            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 501);
            map.put("msg", "网络异常");
            return map;
        }
    }

}
