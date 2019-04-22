package com.xiaoshu.admin.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoshu.admin.entity.AsaHuowu;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-29
 */
public interface AsaHuowuMapper extends BaseMapper<AsaHuowu> {

    AsaHuowu selectProductById(Map<String, Object> map);

}
