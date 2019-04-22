package com.xiaoshu.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoshu.admin.entity.AsaHuowu;
import com.xiaoshu.admin.mapper.AsaHuowuMapper;
import com.xiaoshu.admin.service.AsaHuowuService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-29
 */
@Service
public class AsaHuowuServiceImpl extends ServiceImpl<AsaHuowuMapper, AsaHuowu>
        implements
        AsaHuowuService {

    @Override
    public List<AsaHuowu> selectAll() {
        QueryWrapper wrapper = new QueryWrapper();
        return baseMapper.selectList(wrapper);
    }

    @Override
    public void saveProduct(AsaHuowu asahuowu) {
        baseMapper.insert(asahuowu);

    }

    @Override
    public AsaHuowu selectProductById(String id) {
        Map<String, Object> map = new HashMap();
        map.put("id", id);
        return baseMapper.selectProductById(map);
    }

}
