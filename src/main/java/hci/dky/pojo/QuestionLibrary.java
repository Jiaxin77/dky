package hci.dky.pojo;

public class QuestionLibrary {
    private Long id;

    private String questionType;

    private String questionTitle;

    private Boolean isMust;

    private Long surveyId;

    public QuestionLibrary(Long id, String questionType, String questionTitle, Boolean isMust, Long surveyId) {
        this.id = id;
        this.questionType = questionType;
        this.questionTitle = questionTitle;
        this.isMust = isMust;
        this.surveyId = surveyId;
    }

    public QuestionLibrary() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle == null ? null : questionTitle.trim();
    }

    public Boolean getIsMust() {
        return isMust;
    }

    public void setIsMust(Boolean isMust) {
        this.isMust = isMust;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }
}