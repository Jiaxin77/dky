package hci.dky.pojo;

public class IndexAndMethod {
    private Long id;

    private Long indexId;

    private Long methodId;

    private Boolean isMust;

    public IndexAndMethod(Long id, Long indexId, Long methodId, Boolean isMust) {
        this.id = id;
        this.indexId = indexId;
        this.methodId = methodId;
        this.isMust = isMust;
    }

    public IndexAndMethod() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIndexId() {
        return indexId;
    }

    public void setIndexId(Long indexId) {
        this.indexId = indexId;
    }

    public Long getMethodId() {
        return methodId;
    }

    public void setMethodId(Long methodId) {
        this.methodId = methodId;
    }

    public Boolean getIsMust() {
        return isMust;
    }

    public void setIsMust(Boolean isMust) {
        this.isMust = isMust;
    }
}