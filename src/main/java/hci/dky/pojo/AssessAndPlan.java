package hci.dky.pojo;

public class AssessAndPlan {
    private Long id;

    private String planType;

    private Long assessId;

    public AssessAndPlan(Long id, String planType, Long assessId) {
        this.id = id;
        this.planType = planType;
        this.assessId = assessId;
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
}