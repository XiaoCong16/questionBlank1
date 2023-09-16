package com.xiaocong.questionbank_xiaocong;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuestionBlank1ApplicationTests {

    @Test
    void contextLoads() {
        String str = "1.在计算机中，运算器的基本功能是 \n" +
                "A.进行算术和逻辑运算\n" +
                "B.存储各种控制信息\n" +
                "C. 保持各种控制状态\n" +
                "D.控制机器各个部件协调一致地工作";
        int indexA = str.indexOf("A.");
        int indexB = str.indexOf("B.");
        int indexC = str.indexOf("C.");
        int indexD = str.indexOf("D.");
        String title = str.substring(0, indexA);
        String A = str.substring(indexA, indexB);
        String B = str.substring(indexB, indexC);
        String C = str.substring(indexC, indexD);
        String D = str.substring(indexD);
        System.out.println(title);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
    }

}
