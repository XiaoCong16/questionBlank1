package com.xiaocong.questionbank_xiaocong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaocong.questionbank_xiaocong.model.po.HaveDone;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HaveDoneMapper extends BaseMapper<HaveDone> {
    void removeAll();
}
