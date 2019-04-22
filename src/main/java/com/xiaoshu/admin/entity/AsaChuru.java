package com.xiaoshu.admin.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("asa_churu")
public class AsaChuru extends BaseEntity<AsaChuru> {

    private static final long serialVersionUID = 1L;

    /**
     * 来访人姓名
     */
    @TableField("laifang_name")
    private String laifangName;

    /**
     * 来访时间
     */
    @TableField("laifang_shijian")
    private LocalDateTime laifangShijian;

    /**
     * 来访原因
     */
    @TableField("laifang_yuanyin")
    private String laifangYuanyin;

    /**
     * 来访人_电话
     */
    @TableField("laifang_dianhua")
    private String laifangDianhua;

    /**
     * 被访人姓名
     */
    @TableField("beifang_name")
    private String beifangName;

    /**
     * 被访人宿舍
     */
    @TableField("beifang_sushehao")
    private String beifangSushehao;

    /**
     * 被访人班级
     */
    @TableField("beifang_banji")
    private String beifangBanji;

    /**
     * 被访人电话
     */
    @TableField("beifang_dianhua")
    private String beifangDianhua;

    /**
     * 离开时间
     */
    private LocalDateTime likeishijian;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLaifangName() {
        return laifangName;
    }

    public void setLaifangName(String laifangName) {
        this.laifangName = laifangName;
    }

    public LocalDateTime getLaifangShijian() {
        return laifangShijian;
    }

    public void setLaifangShijian(LocalDateTime laifangShijian) {
        this.laifangShijian = laifangShijian;
    }

    public String getLaifangYuanyin() {
        return laifangYuanyin;
    }

    public void setLaifangYuanyin(String laifangYuanyin) {
        this.laifangYuanyin = laifangYuanyin;
    }

    public String getLaifangDianhua() {
        return laifangDianhua;
    }

    public void setLaifangDianhua(String laifangDianhua) {
        this.laifangDianhua = laifangDianhua;
    }

    public String getBeifangName() {
        return beifangName;
    }

    public void setBeifangName(String beifangName) {
        this.beifangName = beifangName;
    }

    public String getBeifangSushehao() {
        return beifangSushehao;
    }

    public void setBeifangSushehao(String beifangSushehao) {
        this.beifangSushehao = beifangSushehao;
    }

    public String getBeifangBanji() {
        return beifangBanji;
    }

    public void setBeifangBanji(String beifangBanji) {
        this.beifangBanji = beifangBanji;
    }

    public String getBeifangDianhua() {
        return beifangDianhua;
    }

    public void setBeifangDianhua(String beifangDianhua) {
        this.beifangDianhua = beifangDianhua;
    }

    public LocalDateTime getLikeishijian() {
        return likeishijian;
    }

    public void setLikeishijian(LocalDateTime likeishijian) {
        this.likeishijian = likeishijian;
    }

    public static final String ID = "id";

    public static final String LAIFANG_NAME = "laifang_name";

    public static final String LAIFANG_SHIJIAN = "laifang_shijian";

    public static final String LAIFANG_YUANYIN = "laifang_yuanyin";

    public static final String LAIFANG_DIANHUA = "laifang_dianhua";

    public static final String BEIFANG_NAME = "beifang_name";

    public static final String BEIFANG_SUSHEHAO = "beifang_sushehao";

    public static final String BEIFANG_BANJI = "beifang_banji";

    public static final String BEIFANG_DIANHUA = "beifang_dianhua";

    public static final String LIKEISHIJIAN = "likeishijian";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AsaChuru{" + ", id=" + id + ", laifangName=" + laifangName
                + ", laifangShijian=" + laifangShijian + ", laifangYuanyin="
                + laifangYuanyin + ", laifangDianhua=" + laifangDianhua
                + ", beifangName=" + beifangName + ", beifangSushehao="
                + beifangSushehao + ", beifangBanji=" + beifangBanji
                + ", beifangDianhua=" + beifangDianhua + ", likeishijian="
                + likeishijian + "}";
    }
}
