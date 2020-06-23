/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author xsura
 */
public class GatePass {
    
    private String gatepassId;

    
    private String uid;
    private String placeOfVisit;
    private String issuedBy;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private String status;
    private Timestamp issueDateTime;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPlaceOfVisit() {
        return placeOfVisit;
    }

    public void setPlaceOfVisit(String placeOfVisit) {
        this.placeOfVisit = placeOfVisit;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getIssueDateTime() {
        return issueDateTime;
    }

    public void setIssueDateTime(Timestamp issueDateTime) {
        this.issueDateTime = issueDateTime;
    }
    public String getGatepassId() {
        return gatepassId;
    }

    public void setGatepassId(String gatepassId) {
        this.gatepassId = gatepassId;
    }
    
    
}
