package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * expert_answer_paper
 * @author 
 */
@Data
public class ExpertAnswerPaper implements Serializable {
    private Long id;

    private Long taskId;

    private Long expertId;

    private Long planId;

    private static final long serialVersionUID = 1L;
}