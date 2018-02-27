package com.education.domain.dto;

import com.education.domain.vo.FavoriteVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FavoriteDTO extends FavoriteVo {
    @Getter
    @Setter
    private List knowinfo;
}
