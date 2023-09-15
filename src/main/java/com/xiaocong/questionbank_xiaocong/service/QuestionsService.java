package com.xiaocong.questionbank_xiaocong.service;


import com.xiaocong.questionbank_xiaocong.model.po.RestResponse;

public interface QuestionsService {
    /**
     * 查询出所有错题
     * @return
     */
    public RestResponse findAllWrong();

    /**
     * 随机出题
     * @return
     */
    public RestResponse findQuestionByRandom(Integer questionId);

    /**
     * 顺序出题
     * @return
     */
    public RestResponse findQuestionByNext(Integer questionId);

    /**
     * 查询答案
     * @param questionId
     * @return
     */
    public RestResponse findResult(Integer questionId,String result);

    /**
     * 查询做过的题目

     * @return
     */
    public RestResponse findHaveDone();

    /**
     *  重置题目
     * @return
     */
    public RestResponse resettingAll();
}
