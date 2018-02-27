package com.education.service;

import com.education.domain.Favorite;
import com.education.domain.vo.FavoriteVo;

import java.util.List;
import java.util.Map;
public interface IFavoriteService {

    //List<Favorite> findAllFavorites1();
    List<FavoriteVo> getAllFavorites(Integer userId, Integer type, Integer subjectId, Integer page, Integer pageLine, Integer tagId);
}
