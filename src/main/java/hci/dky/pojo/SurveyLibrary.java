package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * survey_library
 * @author 
 */
@Data
public class SurveyLibrary implements Serializable {
    /**
     * 问卷id
     */
    private Long id;

    /**
     * 问卷标题
     */
    private String surveyTitle;

    /**
     * 问卷简介
     */
    private String surveyDes;

    /**
     * 已填人数
     */
    private Long nowPeopleNum;

    /**
     * 是否为模板
     */
    private Boolean isModel;

    /**
     * 所属评估
     */
    private Long assessId;

    /**
     * 所属方案id
     */
    private Long planId;

    /**
     * 模板题的id列表
     */
    private String modelid;

    /**
     * 问卷是否存在
     */
    private Boolean isexist;

    private static final long serialVersionUID = 1L;
}