package hci.dky.pojo;

public class SusScale {
    private Long id;

    private String systemName;

    private Long assessId;

    public SusScale(Long id, String systemName, Long assessId) {
        this.id = id;
        this.systemName = systemName;
        this.assessId = assessId;
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

    public Long getAssessId() {
        return assessId;
    }

    public void setAssessId(Long assessId) {
        this.assessId = assessId;
    }
}