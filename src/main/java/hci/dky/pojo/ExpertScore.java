package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * expert_score
 * @author 
 */
@Data
public class ExpertScore implements Serializable {
    /**
     * 专家走查分数表id
     */
    private Long id;

    /**
     * 所属方案id
     */
    private Long planId;

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

    /**
     * 任务id
     */
    private Long taskId;

    /**
     * 专家id
     */
    private Long expertId;

    private static final long serialVersionUID = 1L;
}