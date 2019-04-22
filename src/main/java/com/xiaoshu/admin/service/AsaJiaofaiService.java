package com.xiaoshu.admin.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoshu.admin.entity.AsaJiaofai;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-27
 */
public interface AsaJiaofaiService extends IService<AsaJiaofai> {

    List<AsaJiaofai> selectAll();

    void saveProduct(AsaJiaofai asajiaofai);

    AsaJiaofai selectProductById(String id);

}
