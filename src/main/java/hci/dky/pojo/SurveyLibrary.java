package hci.dky.pojo;

public class SurveyLibrary {
    private Long id;

    private String surveyTitle;

    private String surveyDes;

    private Long nowPeopleNum;

    private Boolean isModel;

    private Long assessId;

    private Long planId;

    public SurveyLibrary(Long id, String surveyTitle, String surveyDes, Long nowPeopleNum, Boolean isModel, Long assessId, Long planId) {
        this.id = id;
        this.surveyTitle = surveyTitle;
        this.surveyDes = surveyDes;
        this.nowPeopleNum = nowPeopleNum;
        this.isModel = isModel;
        this.assessId = assessId;
        this.planId = planId;
    }

    public SurveyLibrary() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void setSurveyTitle(String surveyTitle) {
        this.surveyTitle = surveyTitle == null ? null : surveyTitle.trim();
    }

    public String getSurveyDes() {
        return surveyDes;
    }

    public void setSurveyDes(String surveyDes) {
        this.surveyDes = surveyDes == null ? null : surveyDes.trim();
    }

    public Long getNowPeopleNum() {
        return nowPeopleNum;
    }

    public void setNowPeopleNum(Long nowPeopleNum) {
        this.nowPeopleNum = nowPeopleNum;
    }

    public Boolean getIsModel() {
        return isModel;
    }

    public void setIsModel(Boolean isModel) {
        this.isModel = isModel;
    }

    public Long getAssessId() {
        return assessId;
    }

    public void setAssessId(Long assessId) {
        this.assessId = assessId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }
}