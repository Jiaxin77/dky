package hci.dky.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class IndexLibrary {
    private Long id;

    private String category;

    private String firstIndex;

    @JsonInclude(JsonInclude.Include.NON_NULL) // 为空的话不会显示给前端
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