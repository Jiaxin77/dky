package hci.dky.pojo;

public class SusScaleAnswerPaper {
    private Long id;

    private String answerName;

    private Long susId;

    public SusScaleAnswerPaper(Long id, String answerName, Long susId) {
        this.id = id;
        this.answerName = answerName;
        this.susId = susId;
    }

    public SusScaleAnswerPaper() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName == null ? null : answerName.trim();
    }

    public Long getSusId() {
        return susId;
    }

    public void setSusId(Long susId) {
        this.susId = susId;
    }
}