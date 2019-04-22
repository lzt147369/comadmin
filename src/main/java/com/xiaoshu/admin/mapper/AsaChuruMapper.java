package com.xiaoshu.admin.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoshu.admin.entity.AsaChuru;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-27
 */
public interface AsaChuruMapper extends BaseMapper<AsaChuru> {

    AsaChuru selectProductById(Map<String, Object> map);

}
