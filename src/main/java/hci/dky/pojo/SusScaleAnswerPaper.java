package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * sus_scale_answer_paper
 * @author 
 */
@Data
public class SusScaleAnswerPaper implements Serializable {
    /**
     * sus量表答卷id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String answerName;

    /**
     * sus量表id
     */
    private String scaleid;

    /**
     * 对应任务ID

     */
    private Long taskId;

    /**
     * 对应专家id
     */
    private Long expertId;

    /**
     * 对应方案id
     */
    private Long planId;

    private static final long serialVersionUID = 1L;
}