package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * expert_object
 * @author 
 */
@Data
public class ExpertObject implements Serializable {
    /**
     * id

     */
    private Integer id;

    /**
     * 针对对象
     */
    private String object;

    /**
     * 编码
     */
    private Integer question_number;

    private static final long serialVersionUID = 1L;
}