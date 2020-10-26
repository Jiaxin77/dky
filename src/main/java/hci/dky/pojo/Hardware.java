package hci.dky.pojo;

import java.math.BigDecimal;

public class Hardware {
    private Long hardwareId;

    private String firstObjectName;

    private String secondObjectName;

    private String firstIndexName;

    private String secondIndexName;

    private String evaCondition;

    private BigDecimal hardwareLower;

    private BigDecimal hardwareBest;

    private BigDecimal hardwareUpper;

    private String hardwareUnit;

    private String otherStandard;

    private String seriousDegree;

    private String picDes;

    private String indexSource;

    public Hardware(Long hardwareId, String firstObjectName, String secondObjectName, String firstIndexName, String secondIndexName, String evaCondition, BigDecimal hardwareLower, BigDecimal hardwareBest, BigDecimal hardwareUpper, String hardwareUnit, String otherStandard, String seriousDegree, String picDes, String indexSource) {
        this.hardwareId = hardwareId;
        this.firstObjectName = firstObjectName;
        this.secondObjectName = secondObjectName;
        this.firstIndexName = firstIndexName;
        this.secondIndexName = secondIndexName;
        this.evaCondition = evaCondition;
        this.hardwareLower = hardwareLower;
        this.hardwareBest = hardwareBest;
        this.hardwareUpper = hardwareUpper;
        this.hardwareUnit = hardwareUnit;
        this.otherStandard = otherStandard;
        this.seriousDegree = seriousDegree;
        this.picDes = picDes;
        this.indexSource = indexSource;
    }

    public Hardware() {
        super();
    }

    public Long getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(Long hardwareId) {
        this.hardwareId = hardwareId;
    }

    public String getFirstObjectName() {
        return firstObjectName;
    }

    public void setFirstObjectName(String firstObjectName) {
        this.firstObjectName = firstObjectName == null ? null : firstObjectName.trim();
    }

    public String getSecondObjectName() {
        return secondObjectName;
    }

    public void setSecondObjectName(String secondObjectName) {
        this.secondObjectName = secondObjectName == null ? null : secondObjectName.trim();
    }

    public String getFirstIndexName() {
        return firstIndexName;
    }

    public void setFirstIndexName(String firstIndexName) {
        this.firstIndexName = firstIndexName == null ? null : firstIndexName.trim();
    }

    public String getSecondIndexName() {
        return secondIndexName;
    }

    public void setSecondIndexName(String secondIndexName) {
        this.secondIndexName = secondIndexName == null ? null : secondIndexName.trim();
    }

    public String getEvaCondition() {
        return evaCondition;
    }

    public void setEvaCondition(String evaCondition) {
        this.evaCondition = evaCondition == null ? null : evaCondition.trim();
    }

    public BigDecimal getHardwareLower() {
        return hardwareLower;
    }

    public void setHardwareLower(BigDecimal hardwareLower) {
        this.hardwareLower = hardwareLower;
    }

    public BigDecimal getHardwareBest() {
        return hardwareBest;
    }

    public void setHardwareBest(BigDecimal hardwareBest) {
        this.hardwareBest = hardwareBest;
    }

    public BigDecimal getHardwareUpper() {
        return hardwareUpper;
    }

    public void setHardwareUpper(BigDecimal hardwareUpper) {
        this.hardwareUpper = hardwareUpper;
    }

    public String getHardwareUnit() {
        return hardwareUnit;
    }

    public void setHardwareUnit(String hardwareUnit) {
        this.hardwareUnit = hardwareUnit == null ? null : hardwareUnit.trim();
    }

    public String getOtherStandard() {
        return otherStandard;
    }

    public void setOtherStandard(String otherStandard) {
        this.otherStandard = otherStandard == null ? null : otherStandard.trim();
    }

    public String getSeriousDegree() {
        return seriousDegree;
    }

    public void setSeriousDegree(String seriousDegree) {
        this.seriousDegree = seriousDegree == null ? null : seriousDegree.trim();
    }

    public String getPicDes() {
        return picDes;
    }

    public void setPicDes(String picDes) {
        this.picDes = picDes == null ? null : picDes.trim();
    }

    public String getIndexSource() {
        return indexSource;
    }

    public void setIndexSource(String indexSource) {
        this.indexSource = indexSource == null ? null : indexSource.trim();
    }
}