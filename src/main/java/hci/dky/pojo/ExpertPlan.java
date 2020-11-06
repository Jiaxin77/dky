package hci.dky.pojo;

public class ExpertPlan {
    private Long id;

    private Long assessId;

    public ExpertPlan(Long id, Long assessId) {
        this.id = id;
        this.assessId = assessId;
    }

    public ExpertPlan() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssessId() {
        return assessId;
    }

    public void setAssessId(Long assessId) {
        this.assessId = assessId;
    }
}