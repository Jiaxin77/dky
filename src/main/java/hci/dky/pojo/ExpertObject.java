package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * expert_object
 * @author 
 */
@Data
public class ExpertObject implements Serializable {
    private Integer id;

    private String object;

    private Integer question_number;

    /**
     * 问题
     */
    private String question;

    private static final long serialVersionUID = 1L;
}