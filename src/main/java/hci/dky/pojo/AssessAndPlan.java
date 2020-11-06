package hci.dky.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class AssessAndPlan {
    private Long id;

    private String planType;

    private Long assessId;

    private String assessObject;

    private String indexList;

    @JsonInclude(JsonInclude.Include.NON_NULL) // 为空的话不会显示给前端
    private String tableId;

    public AssessAndPlan(Long id, String planType, Long assessId, String assessObject, String indexList, String tableId) {
        this.id = id;
        this.planType = planType;
        this.assessId = assessId;
        this.assessObject = assessObject;
        this.indexList = indexList;
        this.tableId = tableId;
    }

    public AssessAndPlan(Long id, String planType, Long assessId, String assessObject, String indexList) {
        this.id = id;
        this.planType = planType;
        this.assessId = assessId;
        this.assessObject = assessObject;
        this.indexList = indexList;
    }


    public AssessAndPlan() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType == null ? null : planType.trim();
    }

    public Long getAssessId() {
        return assessId;
    }

    public void setAssessId(Long assessId) {
        this.assessId = assessId;
    }

    public String getAssessObject() {
        return assessObject;
    }

    public void setAssessObject(String assessObject) {
        this.assessObject = assessObject == null ? null : assessObject.trim();
    }

    public String getIndexList() {
        return indexList;
    }

    public void setIndexList(String indexList) {
        this.indexList = indexList == null ? null : indexList.trim();
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId == null ? null : tableId.trim();
    }
}