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
 * @since 2019-03-29
 */
@TableName("asa_huowu")
public class AsaHuowu extends BaseEntity<AsaHuowu> {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String xingming;

    /**
     * 学号
     */
    private String xuehao;

    /**
     * 班级
     */
    private String banji;

    /**
     * 宿舍
     */
    private String sushe;

    /**
     * 电话
     */
    private String dianhua;

    /**
     * 货物名称
     */
    private String huowu;

    /**
     * 时间
     */
    private LocalDateTime shijian;

    /**
     * 1.出去2.进入
     */
    private Integer churu;

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

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    public String getXuehao() {
        return xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public String getSushe() {
        return sushe;
    }

    public void setSushe(String sushe) {
        this.sushe = sushe;
    }

    public String getDianhua() {
        return dianhua;
    }

    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }

    public String getHuowu() {
        return huowu;
    }

    public void setHuowu(String huowu) {
        this.huowu = huowu;
    }

    public LocalDateTime getShijian() {
        return shijian;
    }

    public void setShijian(LocalDateTime shijian) {
        this.shijian = shijian;
    }

    public Integer getChuru() {
        return churu;
    }

    public void setChuru(Integer churu) {
        this.churu = churu;
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

    public static final String XINGMING = "xingming";

    public static final String XUEHAO = "xuehao";

    public static final String BANJI = "banji";

    public static final String SUSHE = "sushe";

    public static final String DIANHUA = "dianhua";

    public static final String HUOWU = "huowu";

    public static final String SHIJIAN = "shijian";

    public static final String CHURU = "churu";

    public static final String CHULIREN = "chuliren";

    public static final String BEIZHU = "beizhu";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AsaHuowu{" + ", id=" + id + ", xingming=" + xingming
                + ", xuehao=" + xuehao + ", banji=" + banji + ", sushe=" + sushe
                + ", dianhua=" + dianhua + ", huowu=" + huowu + ", shijian="
                + shijian + ", churu=" + churu + ", chuliren=" + chuliren
                + ", beizhu=" + beizhu + "}";
    }
}
