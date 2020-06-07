package hci.dky.pojo;

import java.util.Date;

public class AssessLibrary {
    private Long assessId;

    private String assessName;

    private String assessDes;

    private String assessObject;

    private String creator;

    private Date beginTime;

    private String assessState;

    private Boolean isModel;

    private String indexList;

    private Boolean isExist;

    public AssessLibrary(Long assessId, String assessName, String assessDes, String assessObject, String creator, Date beginTime, String assessState, Boolean isModel, String indexList, Boolean isExist) {
        this.assessId = assessId;
        this.assessName = assessName;
        this.assessDes = assessDes;
        this.assessObject = assessObject;
        this.creator = creator;
        this.beginTime = beginTime;
        this.assessState = assessState;
        this.isModel = isModel;
        this.indexList = indexList;
        this.isExist = isExist;
    }

    public AssessLibrary() {
        super();
    }

    public Long getAssessId() {
        return assessId;
    }

    public void setAssessId(Long assessId) {
        this.assessId = assessId;
    }

    public String getAssessName() {
        return assessName;
    }

    public void setAssessName(String assessName) {
        this.assessName = assessName == null ? null : assessName.trim();
    }

    public String getAssessDes() {
        return assessDes;
    }

    public void setAssessDes(String assessDes) {
        this.assessDes = assessDes == null ? null : assessDes.trim();
    }

    public String getAssessObject() {
        return assessObject;
    }

    public void setAssessObject(String assessObject) {
        this.assessObject = assessObject == null ? null : assessObject.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getAssessState() {
        return assessState;
    }

    public void setAssessState(String assessState) {
        this.assessState = assessState == null ? null : assessState.trim();
    }

    public Boolean getIsModel() {
        return isModel;
    }

    public void setIsModel(Boolean isModel) {
        this.isModel = isModel;
    }

    public String getIndexList() {
        return indexList;
    }

    public void setIndexList(String indexList) {
        this.indexList = indexList == null ? null : indexList.trim();
    }

    public Boolean getIsExist() {
        return isExist;
    }

    public void setIsExist(Boolean isExist) {
        this.isExist = isExist;
    }
}