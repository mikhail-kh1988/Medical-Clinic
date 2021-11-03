package com.medclinic.dto;

public class CreateCommentDTO {

    private long createBy;
    private String description;
    private String createDate;

    public CreateCommentDTO(long createBy, String description, String createDate) {
        this.createBy = createBy;
        this.description = description;
        this.createDate = createDate;
    }

    public CreateCommentDTO() {
    }

    public long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(long createBy) {
        this.createBy = createBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
