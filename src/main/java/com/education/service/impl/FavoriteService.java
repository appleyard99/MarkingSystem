package com.education.service.impl;

import com.education.domain.dto.FavoriteDTO;
import com.education.domain.vo.FavoriteVo;
import com.education.domain.vo.QbKnowledgeVo;
import com.education.mapper.FavoriteMapper;
import com.education.mapper.QbKnowledgeMapper;
import com.education.service.IFavoriteService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FavoriteService implements IFavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;
    @Autowired
    private QbKnowledgeMapper qbKMapper;

   /* @Override
    public List<Favorite> findAllFavorites1() {
    return favoriteMapper.selectAll();
    }*/

    /**
     * @param userId
     * @param type
     * @param subjectId
     * @param page
     * @param pageLine
     * @param tagId
     * @return
     * @description:获取用户
     */
    public List<FavoriteDTO> getAllFavorites(Integer userId, Integer type, Integer subjectId, Integer page, Integer pageLine, Integer tagId) {
        //获取用户收藏的题目
        List<FavoriteVo> dataList = new ArrayList();
        page = (page - 1) * pageLine;
        if (1 == type) {
            dataList = favoriteMapper.findAllFavorites(userId, subjectId, page, pageLine, tagId);
        }
        Map<Integer, FavoriteVo> FavoritesMap = Maps.newHashMap();
        //转Map结构
        List<Integer> querylist = Lists.newArrayList();
        for (FavoriteVo favorite : dataList) {
            FavoritesMap.put(favorite.getQuestionbankid(), favorite);
            querylist.add(favorite.getQuestionbankid());
        }
        List<FavoriteDTO> ret = Lists.newArrayList();
        if (dataList.size() > 0) {
            List<QbKnowledgeVo> qbkList = qbKMapper.selectSome(querylist);
            HashMap<Integer, List<QbKnowledgeVo>> qbkmap = Maps.newHashMap();
            for (QbKnowledgeVo qbKnowledge : qbkList) {
                int qid = qbKnowledge.getQuestionbankid();
                if (!qbkmap.containsKey(qid)) {
                    qbkmap.put(qid, Lists.newArrayList());
                }
                List<QbKnowledgeVo> tmp = qbkmap.get(qid);
                tmp.add(qbKnowledge);
                qbkmap.put(qid, tmp);
            }
            for (FavoriteVo fv : dataList) {
                FavoriteDTO dto = new FavoriteDTO();
                //不想一个个设置，可以直接拷贝属性
                BeanUtils.copyProperties(fv, dto);
                dto.setKnowinfo(qbkmap.get(fv.getQuestionbankid()));
                ret.add(dto);
            }
        }
        return ret;
    }


}
