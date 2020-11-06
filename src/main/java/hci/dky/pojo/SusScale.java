package hci.dky.pojo;

public class SusScale {
    private Long id;

    private String systemName;

    private Long planId;

    public SusScale(Long id, String systemName, Long planId) {
        this.id = id;
        this.systemName = systemName;
        this.planId = planId;
    }

    public SusScale() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }
}