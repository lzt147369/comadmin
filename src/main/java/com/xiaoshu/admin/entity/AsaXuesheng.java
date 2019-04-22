package com.xiaoshu.admin.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xiaoshu.common.base.BaseEntity;

/**
 * <p>
 *
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-27
 */
@TableName("asa_xuesheng")
public class AsaXuesheng extends BaseEntity<AsaXuesheng> {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 学号
     */
    private String sno;

    /**
     * 班级
     */
    private String banji;

    /**
     * 电话
     */
    private String phone;

    /**
     * 宿舍
     */
    private String dorm;

    /**
     * 个人财产
     */
    @TableField("personal_id")
    private String personalId;

    /**
     * 1.在线2.退学3.毕业
     */
    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String SNO = "sno";

    public static final String BANJI = "banji";

    public static final String PHONE = "phone";

    public static final String DORM = "dorm";

    public static final String PERSONAL_ID = "personal_id";

    public static final String STATE = "state";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AsaXuesheng{" + ", id=" + id + ", name=" + name + ", sno=" + sno
                + ", banji=" + banji + ", phone=" + phone + ", dorm=" + dorm
                + ", personalId=" + personalId + ", state=" + state + "}";
    }
}
