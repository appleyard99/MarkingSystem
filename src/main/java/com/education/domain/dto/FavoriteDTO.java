package com.education.domain.dto;

import com.education.domain.vo.FavoriteVo;
import com.education.domain.vo.QbKnowledgeVo;

import java.util.List;

public class FavoriteDTO extends FavoriteVo {

    private List<QbKnowledgeVo> knowinfo;

    public List<QbKnowledgeVo> getKnowinfo() {
        return knowinfo;
    }

    public void setKnowinfo(List<QbKnowledgeVo> knowinfo) {
        this.knowinfo = knowinfo;
    }
}
