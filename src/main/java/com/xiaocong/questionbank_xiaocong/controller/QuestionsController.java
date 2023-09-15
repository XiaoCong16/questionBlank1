package com.xiaocong.questionbank_xiaocong.controller;

import com.xiaocong.questionbank_xiaocong.model.po.RestResponse;
import com.xiaocong.questionbank_xiaocong.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(result1);
        return result1;
    }


}
