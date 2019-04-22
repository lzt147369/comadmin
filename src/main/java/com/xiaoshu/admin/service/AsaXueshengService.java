package com.xiaoshu.admin.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoshu.admin.entity.AsaXuesheng;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-27
 */
public interface AsaXueshengService extends IService<AsaXuesheng> {

    List<AsaXuesheng> selectAll();

    void saveProduct(AsaXuesheng asaxuesheng);

    AsaXuesheng selectProductById(String id);

}
