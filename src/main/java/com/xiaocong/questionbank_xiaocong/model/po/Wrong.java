package com.xiaocong.questionbank_xiaocong.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("wrong")
@Data
public class Wrong {
    @TableId
    private Integer id;
    private Integer questionsId;
}
