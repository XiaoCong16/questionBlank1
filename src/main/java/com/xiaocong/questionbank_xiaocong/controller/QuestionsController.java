package com.xiaocong.questionbank_xiaocong.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.xiaocong.questionbank_xiaocong.model.po.Questions;
import com.xiaocong.questionbank_xiaocong.model.po.RestResponse;
import com.xiaocong.questionbank_xiaocong.service.QuestionsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class QuestionsController {
    @Autowired
    QuestionsService questionsService;

    @GetMapping("/question/findResult/{questionsId}/{result}")
    public RestResponse findResult(@PathVariable("questionsId") Integer questionId, @PathVariable("result") String result) {
        RestResponse result1 = questionsService.findResult(questionId, result);
        return result1;
    }

    @GetMapping(value = "/question/findQuestionByNext/{questionsId}", produces = "application/json; charset=utf-8")
    public RestResponse findQuestionByNext(@PathVariable("questionsId") Integer questionId) {
        RestResponse result1 = questionsService.findQuestionByNext(questionId);

        return result1;
    }


    @PostMapping(value = "/question/addQuestions", produces = "application/json; charset=utf-8")
    public RestResponse addQuestions(@RequestBody Map<String, String> map) {
        Questions questions = JSONObject.parseObject(JSONObject.toJSONString(map), Questions.class);
//        System.out.println(questions);
        RestResponse result1 = questionsService.addQuestions(questions);
        return result1;
    }

    @PostMapping(value = "/question/parseString/{str}")
    public RestResponse parseString(@PathVariable("str") String str) {
        return questionsService.parseString(str);
    }


}
