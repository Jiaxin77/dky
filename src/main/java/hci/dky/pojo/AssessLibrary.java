package hci.dky.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * assess_library
 * @author 
 */
@Data
public class AssessLibrary implements Serializable {
    /**
     * 评估id
     */
    private Long assessId;

    /**
     * 评估名称
     */
    private String assessName;

    /**
     * 评估描述
     */
    private String assessDes;

    /**
     * 评估对象
     */
    private String assessObject;

    /**
     * 发起者
     */
    @JsonInclude(JsonInclude.Include.NON_NULL) // 为空的话不会显示给前端
    private String creator;

    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     * 评估状态
     */
    private String assessState;

    /**
     * 是否为模板
     */
    private Boolean isModel;

    /**
     * 所选指标id（1;2;3)
     */
    private String indexList;

    private Boolean isExist;

    /**
     * 所选指标对应方法id
     */
    private String indexMethodList;

    private static final long serialVersionUID = 1L;
}