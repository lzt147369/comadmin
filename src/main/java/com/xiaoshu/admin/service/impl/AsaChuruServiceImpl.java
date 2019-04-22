package com.xiaoshu.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoshu.admin.entity.AsaChuru;
import com.xiaoshu.admin.mapper.AsaChuruMapper;
import com.xiaoshu.admin.service.AsaChuruService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-27
 */
@Service
public class AsaChuruServiceImpl extends ServiceImpl<AsaChuruMapper, AsaChuru>
        implements
        AsaChuruService {

    @Override
    public List<AsaChuru> selectAll() {
        QueryWrapper wrapper = new QueryWrapper();
        return baseMapper.selectList(wrapper);
    }

    @Override
    public void saveProduct(AsaChuru asachuru) {
        baseMapper.insert(asachuru);

    }

    @Override
    public AsaChuru selectProductById(String id) {
        Map<String, Object> map = new HashMap();
        map.put("id", id);
        return baseMapper.selectProductById(map);
    }

}
