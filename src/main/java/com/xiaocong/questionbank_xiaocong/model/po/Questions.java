package com.xiaocong.questionbank_xiaocong.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "questions")
@Data
public class Questions implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String A;
    private String B;
    private String C;
    private String D;
    private Integer state;
    private String result;




}
