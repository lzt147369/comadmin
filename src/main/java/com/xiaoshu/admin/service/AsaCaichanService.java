package com.xiaoshu.admin.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoshu.admin.entity.AsaCaichan;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-27
 */
public interface AsaCaichanService extends IService<AsaCaichan> {

    AsaCaichan chaxun(String id);

    List<AsaCaichan> selectAll();

    void saveProduct(AsaCaichan asacaichan);

    AsaCaichan selectProductById(String id);

}
