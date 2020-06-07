package hci.dky.pojo;

public class BorgScale {
    private Long id;

    private Long assessId;

    public BorgScale(Long id, Long assessId) {
        this.id = id;
        this.assessId = assessId;
    }

    public BorgScale() {
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