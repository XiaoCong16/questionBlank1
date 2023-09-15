package com.xiaocong.questionbank_xiaocong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaocong.questionbank_xiaocong.model.po.Questions;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionsMapper extends BaseMapper<Questions> {
    void updateAll();
}
