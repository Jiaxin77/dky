package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * expert
 * @author 
 */
@Data
public class Expert implements Serializable {
    /**
     * 专家id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 背景
     */
    private String background;

    /**
     * 评估部分
     */
    private String assess_object;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 所属方案id
     */
    private Long plan_id;

    private static final long serialVersionUID = 1L;
}