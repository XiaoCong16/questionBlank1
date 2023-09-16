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

    @PostMapping(value = "/question/parseString")
    public RestResponse parseString(@RequestBody Map<String,String> map) {
//        System.out.println(map);
        String str = map.get("str");
        return questionsService.parseString(str);
    }

    @GetMapping("/question/findAllWrong")
    public RestResponse findAllWrong(){
        return questionsService.findAllWrong();
    }

    @GetMapping("/question/removeWrong/{questionsId}")
    public RestResponse removeWrong(@PathVariable("questionsId")Integer questionsId){
        return questionsService.removeWrong(questionsId);
    }

    @GetMapping("/question/resettingAll")
    public RestResponse resettingAll(){
        return questionsService.resettingAll();
    }
    @GetMapping("/question/findHaveDone")
    public RestResponse findHaveDone(){
        return questionsService.findHaveDone();
    }

}
