package hci.dky.pojo;

public class PaperList {
    private Long id;

    private Long surveyId;

    private String user;

    public PaperList(Long id, Long surveyId, String user) {
        this.id = id;
        this.surveyId = surveyId;
        this.user = user;
    }

    public PaperList() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }
}