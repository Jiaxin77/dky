package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * expert_task
 * @author 
 */
@Data
public class ExpertTask implements Serializable {
    /**
     * 任务id
     */
    private Long id;

    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 任务编号
     */
    private Long taskNum;

    /**
     * 任务说明
     */
    private String taskDes;

    /**
     * 所属方案id
     */
    private Long planId;

    /**
     * 文件路径
     */
    private String filepath;

    /**
     * 任务名称
     */
    private String taskName;

    private static final long serialVersionUID = 1L;
    
}