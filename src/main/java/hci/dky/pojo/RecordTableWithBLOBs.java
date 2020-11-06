package hci.dky.pojo;

import java.util.Date;

public class RecordTableWithBLOBs extends RecordTable {
    private String basicSituation;

    private String breakDownDes;

    private String others;

    public RecordTableWithBLOBs(Long id, String systemName, String recorder, Date beginDate, Date endDate, Long dayCount, String recordPeriod, Boolean isBreakDown, Long breakDownCount, String breakdownType, Long planId, String basicSituation, String breakDownDes, String others) {
        super(id, systemName, recorder, beginDate, endDate, dayCount, recordPeriod, isBreakDown, breakDownCount, breakdownType, planId);
        this.basicSituation = basicSituation;
        this.breakDownDes = breakDownDes;
        this.others = others;
    }

    public RecordTableWithBLOBs() {
        super();
    }

    public String getBasicSituation() {
        return basicSituation;
    }

    public void setBasicSituation(String basicSituation) {
        this.basicSituation = basicSituation == null ? null : basicSituation.trim();
    }

    public String getBreakDownDes() {
        return breakDownDes;
    }

    public void setBreakDownDes(String breakDownDes) {
        this.breakDownDes = breakDownDes == null ? null : breakDownDes.trim();
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
    }
}