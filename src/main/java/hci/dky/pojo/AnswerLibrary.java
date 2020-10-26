package hci.dky.pojo;

public class AnswerLibrary {
    private Long id;

    private Long questionId;

    private String answer;

    private Long paperId;

    public AnswerLibrary(Long id, Long questionId, String answer, Long paperId) {
        this.id = id;
        this.questionId = questionId;
        this.answer = answer;
        this.paperId = paperId;
    }

    public AnswerLibrary() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }
}