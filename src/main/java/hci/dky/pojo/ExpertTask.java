package hci.dky.pojo;

public class ExpertTask {
    private Long id;

    private String systemName;

    private Long taskNum;

    private String taskDes;

    private Long planId;

    public ExpertTask(Long id, String systemName, Long taskNum, String taskDes, Long planId) {
        this.id = id;
        this.systemName = systemName;
        this.taskNum = taskNum;
        this.taskDes = taskDes;
        this.planId = planId;
    }

    public ExpertTask() {
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

    public Long getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(Long taskNum) {
        this.taskNum = taskNum;
    }

    public String getTaskDes() {
        return taskDes;
    }

    public void setTaskDes(String taskDes) {
        this.taskDes = taskDes == null ? null : taskDes.trim();
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }
}