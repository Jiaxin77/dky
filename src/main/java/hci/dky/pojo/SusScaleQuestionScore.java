package hci.dky.pojo;

public class SusScaleQuestionScore {
    private Long id;

    private Long questionNumber;

    private Long susPaperId;

    private Long score;

    public SusScaleQuestionScore(Long id, Long questionNumber, Long susPaperId, Long score) {
        this.id = id;
        this.questionNumber = questionNumber;
        this.susPaperId = susPaperId;
        this.score = score;
    }

    public SusScaleQuestionScore() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Long questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Long getSusPaperId() {
        return susPaperId;
    }

    public void setSusPaperId(Long susPaperId) {
        this.susPaperId = susPaperId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}