package com.education.domain;

import java.util.Date;

public class AclResource {
    private Integer id;

    private String controller;

    private String ctlTitle;

    private String action;

    private String actTitle;

    private String element;

    private Byte type;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller == null ? null : controller.trim();
    }

    public String getCtlTitle() {
        return ctlTitle;
    }

    public void setCtlTitle(String ctlTitle) {
        this.ctlTitle = ctlTitle == null ? null : ctlTitle.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public String getActTitle() {
        return actTitle;
    }

    public void setActTitle(String actTitle) {
        this.actTitle = actTitle == null ? null : actTitle.trim();
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element == null ? null : element.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}