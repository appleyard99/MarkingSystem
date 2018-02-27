package com.education.service.impl;
import com.education.domain.Favorite;
import com.education.domain.FavoriteTag;
import com.education.domain.QbKnowledge;
import com.education.domain.vo.FavoriteVo;
import com.education.domain.vo.QbKnowledgeVo;
import com.education.mapper.FavoriteMapper;
import com.education.mapper.QbKnowledgeMapper;
import com.education.service.IFavoriteService;
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
            /*
            //String idStr = StringUtils.collectionToDelimitedString(list1, ",");//获取题目的id串;
            if(!qbkList.isEmpty()&&qbkList.size()>0)
            {
                Map<Integer,QbKnowledgeVo> qbkMap = new HashMap<>();
                for(QbKnowledgeVo qbkItem : qbkList){
                    qbkMap.put(qbkItem.getQuestionbankid(),qbkItem);
                    //System.Out.print("id="+qbkItem.getQuestionbankid());

                }
                //System.out.print(qbkMap.isEmpty());
            }*/
            Integer qid=0;
            Map<Integer, Map<String, Object>> favorite1Map = new TreeMap<>();
            for (FavoriteVo favorite1:dataList){

                qid=favorite1.getQuestionbankid();
                List<Object> qkItemList = new ArrayList<>();
                //转MAP;
                //Map<String, Object> dataMap = new HashMap<>();
                //dataMap.put("favorite",favorite1);
                //获取知识点相关;
                if(!qbkList.isEmpty()&&qbkList.size()>0) {
                    for (QbKnowledgeVo qbkItem : qbkList) {
                        if(qid==qbkItem.getQuestionbankid()){
                            qkItemList.add(qbkItem);

                        }
                    }
                    System.out.print(qkItemList.isEmpty());
                }


                System.out.print(favorite1Map.isEmpty());
            }
            System.out.print("aaa");








            /*for(Map.Entry<Integer,FavoriteVo> entry:FavoritesMap.entrySet()){
                System.out.print("Key =" +entry.getKey() +",Value=" +entry.getValue());
            }*/

        }

        return dataList;
    }




}
