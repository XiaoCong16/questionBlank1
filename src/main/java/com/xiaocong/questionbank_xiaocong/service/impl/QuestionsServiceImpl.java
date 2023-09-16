package com.xiaocong.questionbank_xiaocong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaocong.questionbank_xiaocong.mapper.HaveDoneMapper;
import com.xiaocong.questionbank_xiaocong.mapper.QuestionsMapper;
import com.xiaocong.questionbank_xiaocong.mapper.WrongMapper;
import com.xiaocong.questionbank_xiaocong.model.po.HaveDone;
import com.xiaocong.questionbank_xiaocong.model.po.Questions;
import com.xiaocong.questionbank_xiaocong.model.po.RestResponse;
import com.xiaocong.questionbank_xiaocong.model.po.Wrong;
import com.xiaocong.questionbank_xiaocong.service.QuestionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;

@Service
@Slf4j
@CrossOrigin()
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    QuestionsMapper questionsMapper;
    @Autowired
    HaveDoneMapper haveDoneMapper;
    @Autowired
    WrongMapper wrongMapper;


    static Set<Integer> set = new HashSet();

    @Override
    public RestResponse findAllWrong() {
//        查找出所有错题
        List<Wrong> wrongList = wrongMapper.selectList(null);
        List<Integer> questionsIds = new ArrayList<>();
//        将错题关联的问题id查询出来
        for (Wrong wrong : wrongList) {
            questionsIds.add(wrong.getQuestionsId());
        }
        List<Questions> questions = questionsMapper.selectBatchIds(questionsIds);
        return new RestResponse(questions);
    }

    @Override
    public RestResponse findQuestionByRandom(Integer questionId) {
        Long count = questionsMapper.selectCount(null);
        Random random = new Random(count);
        int randomIndex = random.nextInt();
        while (set.contains(randomIndex)) {
            randomIndex = random.nextInt();
        }
        set.add(randomIndex);
        QueryWrapper<Questions> questionsQueryWrapper = new QueryWrapper<>();
        questionsQueryWrapper.ne("state", "2").last(" limit " + randomIndex + ",1");
        Questions questions = questionsMapper.selectOne(questionsQueryWrapper);
        if (questions != null) {
            questions.setResult("");
        }
        return new RestResponse(questions);
    }

    @Override
    public RestResponse findQuestionByNext(Integer questionId) {
        QueryWrapper<Questions> questionsQueryWrapper = null;
        if (questionId == -1) {
            questionsQueryWrapper = new QueryWrapper<>();
            questionsQueryWrapper.ne("state", "2").orderByAsc("id").last(" limit 0,1");
        } else {
            questionsQueryWrapper = new QueryWrapper<>();
            questionsQueryWrapper.ne("state", "2").gt("id", questionId).last(" limit 0,1");
        }

        Questions questions = questionsMapper.selectOne(questionsQueryWrapper);
        if (questions != null) {
            questions.setResult("");
        } else {
            questions = new Questions();
        }

        return new RestResponse(questions);
    }

    @Override
    public RestResponse findResult(Integer questionId, String result) {
        QueryWrapper<Questions> questionsQueryWrapper = new QueryWrapper<>();
        questionsQueryWrapper.eq("id", questionId);
        Questions questions = questionsMapper.selectOne(questionsQueryWrapper);
        if (questions != null && !StringUtils.isEmpty(result)) {
            if (questions.getResult().equals(result)) {
                questions.setState(2);
                questionsMapper.updateById(questions);
            }
        }
        return new RestResponse(questions.getResult());
    }

    @Override
    public RestResponse findHaveDone() {
        //        查找出所有错题
        List<HaveDone> haveDones = haveDoneMapper.selectList(null);
        List<Integer> questionsIds = new ArrayList<>();
//        将错题关联的问题id查询出来
        for (HaveDone haveDone : haveDones) {
            questionsIds.add(haveDone.getQuestionsId());
        }
        List<Questions> questions = questionsMapper.selectBatchIds(questionsIds);
        return new RestResponse(questions);
    }

    @Override
    public RestResponse resettingAll() {
        questionsMapper.updateAll();
        wrongMapper.removeAll();
        haveDoneMapper.removeAll();
        return new RestResponse();
    }

    @Override
    public RestResponse addQuestions(Questions questions) {
        questionsMapper.insert(questions);
        return new RestResponse();
    }

    public RestResponse parseString(String str) {
        int index0 = str.indexOf(" (");
        int indexA = str.indexOf("A.");
        int indexB = str.indexOf("B.");
        int indexC = str.indexOf("C.");
        int indexD = str.indexOf("D.");
        String title = str.substring(0, index0);
        String result = str.substring(index0+2,index0+3);
        String A = str.substring(indexA, indexB);
        String B = str.substring(indexB, indexC);
        String C = str.substring(indexC, indexD);
        String D = str.substring(indexD);
        Questions questions = new Questions();
        questions.setTitle(title);
        questions.setA(A);
        questions.setB(B);
        questions.setC(C);
        questions.setD(D);
        questions.setResult(result);

        System.out.println(index0);
        System.out.println(questions);
        return new RestResponse(questions);
    }
}
