package com.xiaoshu.admin.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("asa_jiaofai")
public class AsaJiaofai extends BaseEntity<AsaJiaofai> {

    private static final long serialVersionUID = 1L;

    /**
     * 宿舍号
     */
    private String sushehao;

    /**
     * 缴费类型
     */
    private String jiaofaileixing;

    /**
     * 缴费金额
     */
    private String jiaofaijine;

    /**
     * 缴费时间
     */
    private LocalDateTime jiaofaishijian;

    /**
     * 缴费人
     */
    private String jiaofairen;

    /**
     * 处理人
     */
    private String chuliren;

    /**
     * 备注
     */
    private String beizhu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSushehao() {
        return sushehao;
    }

    public void setSushehao(String sushehao) {
        this.sushehao = sushehao;
    }

    public String getJiaofaileixing() {
        return jiaofaileixing;
    }

    public void setJiaofaileixing(String jiaofaileixing) {
        this.jiaofaileixing = jiaofaileixing;
    }

    public String getJiaofaijine() {
        return jiaofaijine;
    }

    public void setJiaofaijine(String jiaofaijine) {
        this.jiaofaijine = jiaofaijine;
    }

    public LocalDateTime getJiaofaishijian() {
        return jiaofaishijian;
    }

    public void setJiaofaishijian(LocalDateTime jiaofaishijian) {
        this.jiaofaishijian = jiaofaishijian;
    }

    public String getJiaofairen() {
        return jiaofairen;
    }

    public void setJiaofairen(String jiaofairen) {
        this.jiaofairen = jiaofairen;
    }

    public String getChuliren() {
        return chuliren;
    }

    public void setChuliren(String chuliren) {
        this.chuliren = chuliren;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public static final String ID = "id";

    public static final String SUSHEHAO = "sushehao";

    public static final String JIAOFAILEIXING = "jiaofaileixing";

    public static final String JIAOFAIJINE = "jiaofaijine";

    public static final String JIAOFAISHIJIAN = "jiaofaishijian";

    public static final String JIAOFAIREN = "jiaofairen";

    public static final String CHULIREN = "chuliren";

    public static final String BEIZHU = "beizhu";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AsaJiaofai{" + ", id=" + id + ", sushehao=" + sushehao
                + ", jiaofaileixing=" + jiaofaileixing + ", jiaofaijine="
                + jiaofaijine + ", jiaofaishijian=" + jiaofaishijian
                + ", jiaofairen=" + jiaofairen + ", chuliren=" + chuliren
                + ", beizhu=" + beizhu + "}";
    }
}
