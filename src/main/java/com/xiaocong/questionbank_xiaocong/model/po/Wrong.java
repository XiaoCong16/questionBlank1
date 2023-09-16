package com.xiaocong.questionbank_xiaocong.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("wrong")
@Data
public class Wrong implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer questionsId;
}
