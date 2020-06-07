package hci.dky.pojo;

public class SusScaleAnswerPaper {
    private Long id;

    private String answerName;

    public SusScaleAnswerPaper(Long id, String answerName) {
        this.id = id;
        this.answerName = answerName;
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
}