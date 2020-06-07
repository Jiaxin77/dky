package hci.dky.pojo;

public class Expert {
    private Long id;

    private String name;

    private String background;

    private String assessObject;

    private String remarks;

    private Long expertPlanId;

    public Expert(Long id, String name, String background, String assessObject, String remarks, Long expertPlanId) {
        this.id = id;
        this.name = name;
        this.background = background;
        this.assessObject = assessObject;
        this.remarks = remarks;
        this.expertPlanId = expertPlanId;
    }

    public Expert() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background == null ? null : background.trim();
    }

    public String getAssessObject() {
        return assessObject;
    }

    public void setAssessObject(String assessObject) {
        this.assessObject = assessObject == null ? null : assessObject.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Long getExpertPlanId() {
        return expertPlanId;
    }

    public void setExpertPlanId(Long expertPlanId) {
        this.expertPlanId = expertPlanId;
    }
}