package com.xiaocong.questionbank_xiaocong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaocong.questionbank_xiaocong.model.po.Wrong;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WrongMapper extends BaseMapper<Wrong> {
    void removeAll();
}
