package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * assess_and_plan
 * @author 
 */
@Data
public class AssessAndPlan implements Serializable {
    /**
     * 评估-方案表id
     */
    private Long id;

    /**
     * sus/borg/专家走查/问卷
     */
    private String planType;

    /**
     * 所属评估
     */
    private Long assessId;

    /**
     * 软件人机界面/硬件人机界面/整体评价
     */
    private String assessObject;

    /**
     * 评估指标id，如1;2;3，分号分割
     */
    private String indexList;

    /**
     * 用于存问卷id
     */
    private Long tableId;

    private static final long serialVersionUID = 1L;
}