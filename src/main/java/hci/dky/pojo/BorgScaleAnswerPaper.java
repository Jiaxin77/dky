package hci.dky.pojo;

public class BorgScaleAnswerPaper {
    private Long id;

    private Long borgId;

    private String date;

    private String completePerson;

    private String chargePerson;

    private String position;

    private String taskName;

    private Long score;

    public BorgScaleAnswerPaper(Long id, Long borgId, String date, String completePerson, String chargePerson, String position, String taskName, Long score) {
        this.id = id;
        this.borgId = borgId;
        this.date = date;
        this.completePerson = completePerson;
        this.chargePerson = chargePerson;
        this.position = position;
        this.taskName = taskName;
        this.score = score;
    }

    public BorgScaleAnswerPaper() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBorgId() {
        return borgId;
    }

    public void setBorgId(Long borgId) {
        this.borgId = borgId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getCompletePerson() {
        return completePerson;
    }

    public void setCompletePerson(String completePerson) {
        this.completePerson = completePerson == null ? null : completePerson.trim();
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson == null ? null : chargePerson.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}