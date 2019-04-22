package com.xiaoshu.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoshu.admin.entity.AsaCaichan;
import com.xiaoshu.admin.mapper.AsaCaichanMapper;
import com.xiaoshu.admin.service.AsaCaichanService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-27
 */
@Service
public class AsaCaichanServiceImpl
        extends
        ServiceImpl<AsaCaichanMapper, AsaCaichan>
        implements
        AsaCaichanService {

    @Override
    public AsaCaichan chaxun(String id) {
        Map<String, Object> map = new HashMap();
        map.put("id", id);
        return baseMapper.chaxun(map);
    }

    @Override
    public List<AsaCaichan> selectAll() {
        QueryWrapper wrapper = new QueryWrapper();
        return baseMapper.selectList(wrapper);
    }

    @Override
    public void saveProduct(AsaCaichan asacaichan) {
        baseMapper.insert(asacaichan);

    }

    @Override
    public AsaCaichan selectProductById(String id) {
        Map<String, Object> map = new HashMap();
        map.put("id", id);
        return baseMapper.selectProductById(map);
    }

}
