package com.xiaocong.questionbank_xiaocong.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("have_done")
@Data
public class HaveDone {
    @TableId
    private Integer id;
    private Integer questionsId;
}
