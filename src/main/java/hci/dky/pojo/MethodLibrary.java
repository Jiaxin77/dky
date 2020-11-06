package hci.dky.pojo;

public class MethodLibrary {
    private Long id;

    private String methodName;

    private String methodTable;

    private String dataForm;

    private String needPeople;

    public MethodLibrary(Long id, String methodName, String methodTable, String dataForm, String needPeople) {
        this.id = id;
        this.methodName = methodName;
        this.methodTable = methodTable;
        this.dataForm = dataForm;
        this.needPeople = needPeople;
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

    public String getDataForm() {
        return dataForm;
    }

    public void setDataForm(String dataForm) {
        this.dataForm = dataForm == null ? null : dataForm.trim();
    }

    public String getNeedPeople() {
        return needPeople;
    }

    public void setNeedPeople(String needPeople) {
        this.needPeople = needPeople == null ? null : needPeople.trim();
    }
}