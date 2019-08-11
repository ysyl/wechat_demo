package com.zjldemo.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Note implements Serializable {
    /**
     * id
     */
    private int id = 0;

    /**
     * 标题
     */
    private String title = "";

    /**
     * 描述
     */
    private String description = "";

    /**
     * 创建日期
     */
    private Date createTime = null;

    /**
     * 消耗金钱
     */
    private double cost = 0;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note = (Note) o;
        return getId() == note.getId() &&
                Objects.equals(getTitle(), note.getTitle()) &&
                Objects.equals(getDescription(), note.getDescription()) &&
                Objects.equals(getCreateTime(), note.getCreateTime());
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getTitle(), getDescription(), getCreateTime());
    }
}
