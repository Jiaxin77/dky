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

    private static final long serialVersionUID = 1L;
}