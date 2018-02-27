package com.education.service.impl;
import com.education.domain.Favorite;
import com.education.domain.FavoriteTag;
import com.education.domain.QbKnowledge;
import com.education.domain.vo.FavoriteVo;
import com.education.domain.vo.QbKnowledgeVo;
import com.education.mapper.FavoriteMapper;
import com.education.mapper.QbKnowledgeMapper;
import com.education.service.IFavoriteService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.*;

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
     * @description:获取用户
     * @param userId
     * @param type
     * @param subjectId
     * @param page
     * @param pageLine
     * @param tagId
     * @return
     */
    public List<FavoriteVo> getAllFavorites(Integer userId,Integer type,Integer subjectId,Integer page,Integer pageLine,Integer tagId){
        //获取用户收藏的题目
        List<FavoriteVo> dataList = new ArrayList();;
        page = (page-1)*pageLine;
        if(1==type) {
            dataList = favoriteMapper.findAllFavorites(userId, subjectId, page, pageLine, tagId);
        }

        if(!dataList.isEmpty() &&dataList.size() > 0)
        {
            Map<Integer,FavoriteVo> FavoritesMap= new HashMap<>();
            //转Map结构;
            for (FavoriteVo favorite:dataList) {
                FavoritesMap.put(favorite.getQuestionbankid(),favorite);
            }
            Set<Integer> set=FavoritesMap.keySet();
            List<Integer> list1=new ArrayList<Integer>();
            list1.addAll(set);
            List<QbKnowledgeVo> qbkList= new ArrayList<QbKnowledgeVo>();
            qbkList=qbKMapper.selectSome(list1);
            //qbkList转Map key=>value questionbankid=>listData;
            Map<Integer,List<QbKnowledgeVo>> qbkMap = new HashMap<>();
            if(!qbkList.isEmpty()&&qbkList.size()>0){

                for(QbKnowledgeVo qbkItem : qbkList){
                    //qbkMap.put(qbkItem.getQuestionbankid(),qbkItem);
                    Integer qbid = qbkItem.getQuestionbankid();
                    if(qbkMap.containsKey(qbid)){
                        List<QbKnowledgeVo> tmpList = (List<QbKnowledgeVo>) qbkMap.get(qbid);
                        tmpList.add(qbkItem);
                        System.out.print(tmpList.isEmpty());
                        qbkMap.put(qbid,tmpList);
                    }else{
                        List<QbKnowledgeVo> init = Lists.newArrayList();
                        init.add(qbkItem);
                        qbkMap.put(qbid, init);
                        qbkMap.put(qbid, Lists.newArrayList(qbkItem));
                    }

                }



            }












            /*for(Map.Entry<Integer,FavoriteVo> entry:FavoritesMap.entrySet()){
                System.out.print("Key =" +entry.getKey() +",Value=" +entry.getValue());
            }*/

        }

        return dataList;
    }




}
