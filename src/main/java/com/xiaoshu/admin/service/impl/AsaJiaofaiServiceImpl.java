package com.xiaoshu.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoshu.admin.entity.AsaJiaofai;
import com.xiaoshu.admin.mapper.AsaJiaofaiMapper;
import com.xiaoshu.admin.service.AsaJiaofaiService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-27
 */
@Service
public class AsaJiaofaiServiceImpl
        extends
        ServiceImpl<AsaJiaofaiMapper, AsaJiaofai>
        implements
        AsaJiaofaiService {

    @Override
    public List<AsaJiaofai> selectAll() {
        QueryWrapper wrapper = new QueryWrapper();
        return baseMapper.selectList(wrapper);
    }

    @Override
    public void saveProduct(AsaJiaofai asajiaofai) {
        baseMapper.insert(asajiaofai);

    }

    @Override
    public AsaJiaofai selectProductById(String id) {
        Map<String, Object> map = new HashMap();
        map.put("id", id);
        return baseMapper.selectProductById(map);
    }

}
