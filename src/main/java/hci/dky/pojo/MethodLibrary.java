package hci.dky.pojo;

public class MethodLibrary {
    private Long id;

    private String methodName;

    private String methodTable;

    public MethodLibrary(Long id, String methodName, String methodTable) {
        this.id = id;
        this.methodName = methodName;
        this.methodTable = methodTable;
    }

    public MethodLibrary() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getMethodTable() {
        return methodTable;
    }

    public void setMethodTable(String methodTable) {
        this.methodTable = methodTable == null ? null : methodTable.trim();
    }
}