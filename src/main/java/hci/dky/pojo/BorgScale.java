package hci.dky.pojo;

public class BorgScale {
    private Long id;

    private Long planId;

    public BorgScale(Long id, Long planId) {
        this.id = id;
        this.planId = planId;
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

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }
}