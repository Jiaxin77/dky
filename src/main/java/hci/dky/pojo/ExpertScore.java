package hci.dky.pojo;

public class ExpertScore {
    private Long id;

    private Long planId;

    private Long questionNumber;

    private Float conformanceScore;

    private Float importanceScore;

    private String questionDes;

    public ExpertScore(Long id, Long planId, Long questionNumber, Float conformanceScore, Float importanceScore, String questionDes) {
        this.id = id;
        this.planId = planId;
        this.questionNumber = questionNumber;
        this.conformanceScore = conformanceScore;
        this.importanceScore = importanceScore;
        this.questionDes = questionDes;
    }

    public ExpertScore() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Long questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Float getConformanceScore() {
        return conformanceScore;
    }

    public void setConformanceScore(Float conformanceScore) {
        this.conformanceScore = conformanceScore;
    }

    public Float getImportanceScore() {
        return importanceScore;
    }

    public void setImportanceScore(Float importanceScore) {
        this.importanceScore = importanceScore;
    }

    public String getQuestionDes() {
        return questionDes;
    }

    public void setQuestionDes(String questionDes) {
        this.questionDes = questionDes == null ? null : questionDes.trim();
    }
}