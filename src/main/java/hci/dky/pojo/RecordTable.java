package hci.dky.pojo;

import java.util.Date;

public class RecordTable {
    private Long id;

    private String systemName;

    private String recorder;

    private Date beginDate;

    private Date endDate;

    private Long dayCount;

    private String recordPeriod;

    private Boolean isBreakDown;

    private Long breakDownCount;

    private String breakdownType;

    private Long planId;

    public RecordTable(Long id, String systemName, String recorder, Date beginDate, Date endDate, Long dayCount, String recordPeriod, Boolean isBreakDown, Long breakDownCount, String breakdownType, Long planId) {
        this.id = id;
        this.systemName = systemName;
        this.recorder = recorder;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.dayCount = dayCount;
        this.recordPeriod = recordPeriod;
        this.isBreakDown = isBreakDown;
        this.breakDownCount = breakDownCount;
        this.breakdownType = breakdownType;
        this.planId = planId;
    }

    public RecordTable() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder == null ? null : recorder.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getDayCount() {
        return dayCount;
    }

    public void setDayCount(Long dayCount) {
        this.dayCount = dayCount;
    }

    public String getRecordPeriod() {
        return recordPeriod;
    }

    public void setRecordPeriod(String recordPeriod) {
        this.recordPeriod = recordPeriod == null ? null : recordPeriod.trim();
    }

    public Boolean getIsBreakDown() {
        return isBreakDown;
    }

    public void setIsBreakDown(Boolean isBreakDown) {
        this.isBreakDown = isBreakDown;
    }

    public Long getBreakDownCount() {
        return breakDownCount;
    }

    public void setBreakDownCount(Long breakDownCount) {
        this.breakDownCount = breakDownCount;
    }

    public String getBreakdownType() {
        return breakdownType;
    }

    public void setBreakdownType(String breakdownType) {
        this.breakdownType = breakdownType == null ? null : breakdownType.trim();
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }
}