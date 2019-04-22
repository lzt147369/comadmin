package com.xiaoshu.admin.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoshu.admin.entity.AsaXuesheng;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-27
 */
public interface AsaXueshengMapper extends BaseMapper<AsaXuesheng> {

    AsaXuesheng selectProductById(Map<String, Object> map);

}
