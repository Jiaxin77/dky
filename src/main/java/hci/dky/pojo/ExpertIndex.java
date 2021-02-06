package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * expert_index
 * @author 
 */
@Data
public class ExpertIndex implements Serializable {
    private Integer id;

    /**
     * 一级指标
     */
    private String index;

    private static final long serialVersionUID = 1L;
}