package com.xiaoshu.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xiaoshu.common.base.BaseEntity;

/**
 * 作者: liuzhiting
 * 日期: 2019/4/11 10:41
 * 功能:
 */

@TableName("huahui")
public class Huahui extends BaseEntity<Huahui> {
    @TableField("title")
    private String title;
    @TableField("content")
    private String content;
    @TableField("type")
    private int type;
    @TableField("zhiding")
    private int zhiding;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getZhiding() {
        return zhiding;
    }

    public void setZhiding(int zhiding) {
        this.zhiding = zhiding;
    }
}
