package hci.dky.pojo;

public class ExpertTaskContent {
    private Long id;

    private String filePath;

    private Long taskId;

    public ExpertTaskContent(Long id, String filePath, Long taskId) {
        this.id = id;
        this.filePath = filePath;
        this.taskId = taskId;
    }

    public ExpertTaskContent() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}