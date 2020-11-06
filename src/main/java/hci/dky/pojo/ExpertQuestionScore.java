package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * expert_question_score
 * @author 
 */
@Data
public class ExpertQuestionScore implements Serializable {
    /**
     * 专家走查分数表id
     */
    private Long id;

    /**
     * 题号
     */
    private Long questionNumber;

    /**
     * 符合度评分
     */
    private Double conformanceScore;

    /**
     * 重要度评分
     */
    private Double importanceScore;

    /**
     * 问题描述
     */
    private String questionDes;

    private Long paperId;

    private static final long serialVersionUID = 1L;
}