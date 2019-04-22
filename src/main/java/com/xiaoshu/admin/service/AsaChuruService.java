package com.xiaoshu.admin.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoshu.admin.entity.AsaChuru;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-27
 */
public interface AsaChuruService extends IService<AsaChuru> {

    List<AsaChuru> selectAll();

    void saveProduct(AsaChuru asachuru);

    AsaChuru selectProductById(String id);

}
