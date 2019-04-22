package com.xiaoshu.admin.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoshu.admin.entity.AsaHuowu;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-29
 */
public interface AsaHuowuService extends IService<AsaHuowu> {

    List<AsaHuowu> selectAll();

    void saveProduct(AsaHuowu asahuowu);

    AsaHuowu selectProductById(String id);

}
