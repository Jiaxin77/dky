package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * borg_scale_answer_paper
 * @author 
 */
@Data
public class BorgScaleAnswerPaper implements Serializable {
    /**
     * borg量表答卷id
     */
    private Long id;

    /**
     * 所属方案id
     */
    private Long planId;

    /**
     * 日期
     */
    private String date;

    /**
     * 分数
     */
    private Long score;

    /**
     * 专家id
     */
    private Long expertId;

    /**
     * 任务id
     */
    private Long taskId;

    private static final long serialVersionUID = 1L;
}