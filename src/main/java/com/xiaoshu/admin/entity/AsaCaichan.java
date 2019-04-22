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
@TableName("asa_caichan")
public class AsaCaichan extends BaseEntity<AsaCaichan> {

    private static final long serialVersionUID = 1L;

    /**
     * 学生学号
     */
    @TableField("xuesheng_id")
    private String xueshengId;

    /**
     * 姓名
     */
    @TableField("personal_name")
    private String personalName;

    /**
     * 财物
     */
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXueshengId() {
        return xueshengId;
    }

    public void setXueshengId(String xueshengId) {
        this.xueshengId = xueshengId;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static final String ID = "id";

    public static final String XUESHENG_ID = "xuesheng_id";

    public static final String PERSONAL_NAME = "personal_name";

    public static final String REMARK = "remark";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AsaCaichan{" + ", id=" + id + ", xueshengId=" + xueshengId
                + ", personalName=" + personalName + ", remark=" + remark + "}";
    }

}
