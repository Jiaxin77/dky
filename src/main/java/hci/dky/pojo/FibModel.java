package hci.dky.pojo;

public class FibModel {
    private Long id;

    private String fibTitle;

    public FibModel(Long id, String fibTitle) {
        this.id = id;
        this.fibTitle = fibTitle;
    }

    public FibModel() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFibTitle() {
        return fibTitle;
    }

    public void setFibTitle(String fibTitle) {
        this.fibTitle = fibTitle == null ? null : fibTitle.trim();
    }
}