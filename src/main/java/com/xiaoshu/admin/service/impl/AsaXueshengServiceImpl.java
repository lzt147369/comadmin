package com.xiaoshu.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoshu.admin.entity.AsaXuesheng;
import com.xiaoshu.admin.mapper.AsaXueshengMapper;
import com.xiaoshu.admin.service.AsaXueshengService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-27
 */
@Service
public class AsaXueshengServiceImpl
        extends
        ServiceImpl<AsaXueshengMapper, AsaXuesheng>
        implements
        AsaXueshengService {

    @Override
    public List<AsaXuesheng> selectAll() {
        QueryWrapper wrapper = new QueryWrapper();
        return baseMapper.selectList(wrapper);
    }

    @Override
    public void saveProduct(AsaXuesheng asaxuesheng) {
        baseMapper.insert(asaxuesheng);

    }

    @Override
    public AsaXuesheng selectProductById(String id) {
        Map<String, Object> map = new HashMap();
        map.put("id", id);
        return baseMapper.selectProductById(map);
    }

}
