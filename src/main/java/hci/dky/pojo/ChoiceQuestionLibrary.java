package hci.dky.pojo;

public class ChoiceQuestionLibrary {
    private Long id;

    private String choiceTitle;

    private String choiceId;

    private Long questionId;

    public ChoiceQuestionLibrary(Long id, String choiceTitle, String choiceId, Long questionId) {
        this.id = id;
        this.choiceTitle = choiceTitle;
        this.choiceId = choiceId;
        this.questionId = questionId;
    }

    public ChoiceQuestionLibrary() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChoiceTitle() {
        return choiceTitle;
    }

    public void setChoiceTitle(String choiceTitle) {
        this.choiceTitle = choiceTitle == null ? null : choiceTitle.trim();
    }

    public String getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(String choiceId) {
        this.choiceId = choiceId == null ? null : choiceId.trim();
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}