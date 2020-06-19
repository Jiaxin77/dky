package hci.dky.pojo;

public class IndexLibrary {
    private Long id;

    private String category;

    private String firstIndex;

    private String secondIndex;

    public IndexLibrary(Long id, String category, String firstIndex, String secondIndex) {
        this.id = id;
        this.category = category;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    public IndexLibrary() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(String firstIndex) {
        this.firstIndex = firstIndex == null ? null : firstIndex.trim();
    }

    public String getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(String secondIndex) {
        this.secondIndex = secondIndex == null ? null : secondIndex.trim();
    }
}