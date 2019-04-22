package com.xiaoshu.admin.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoshu.admin.entity.AsaChuru;
import com.xiaoshu.admin.service.AsaChuruService;
import com.xiaoshu.common.annotation.SysLog;
import com.xiaoshu.common.base.PageData;
import com.xiaoshu.common.util.ResponseEntity;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-27
 */
@Controller
@RequestMapping("/asaChuru")
public class AsaChuruController {
    @Autowired
    AsaChuruService asachuruService;

    @GetMapping("list")
    @SysLog("跳转系统用户列表页面")
    public String list() {
        return "admin/asachuru/list";
    }

    @RequiresPermissions("sys:asachuru:list")
    @PostMapping("list")
    @ResponseBody
    public PageData<AsaChuru> list(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            ServletRequest request) {
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        PageData<AsaChuru> asachuruPageData = new PageData<>();
        QueryWrapper<AsaChuru> asachuruWrapper = new QueryWrapper<>();
        if (!map.isEmpty()) {
            String type = (String) map.get("type");
            if (StringUtils.isNotBlank(type)) {
                asachuruWrapper.eq("is_admin",
                        "admin".equals(type) ? true : false);
            }
            String keys = (String) map.get("key");
            if (StringUtils.isNotBlank(keys)) {
                asachuruWrapper.and(wrapper -> wrapper.like("name", keys).or()
                        .like("sno", keys).or().like("banji", keys).or()
                        .like("dorm", keys));
            }
        }
        IPage<AsaChuru> asachuruPage = asachuruService
                .page(new Page<>(page, limit), asachuruWrapper);

        asachuruPageData.setCount(asachuruPage.getTotal());
        asachuruPageData.setData(asachuruPage.getRecords());
        return asachuruPageData;
    }

    @GetMapping("add")
    public String add(ModelMap modelMap) {
        List<AsaChuru> asachuruList = asachuruService.selectAll();
        modelMap.put("asachuruList", asachuruList);
        return "admin/asachuru/add";
    }

    @RequiresPermissions("sys:asachuru:add")
    @PostMapping("add")
    @ResponseBody
    @SysLog("保存学生数据")
    public ResponseEntity add(@RequestBody AsaChuru asachuru) {
        if (StringUtils.isBlank(asachuru.getLaifangName())) {
            return ResponseEntity.failure("来访人姓名不能为空");
        }
        if (StringUtils.isBlank(asachuru.getLaifangYuanyin())) {
            return ResponseEntity.failure("来访原因不能为空");
        }
        if (StringUtils.isBlank(asachuru.getLaifangDianhua())) {
            return ResponseEntity.failure("来访人电话不能为空");
        }
        if (StringUtils.isBlank(asachuru.getBeifangName())) {
            return ResponseEntity.failure("被访人姓名不能为空");
        }
        if (StringUtils.isBlank(asachuru.getBeifangSushehao())) {
            return ResponseEntity.failure("被访人宿舍不能为空");
        }
        if (StringUtils.isBlank(asachuru.getBeifangBanji())) {
            return ResponseEntity.failure("被访人班级不能为空");
        }
        if (StringUtils.isBlank(asachuru.getBeifangDianhua())) {
            return ResponseEntity.failure("被访人电话不能为空");
        }

        DateTimeFormatter df = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse(localTime, df);
        asachuru.setLaifangShijian(ldt);

        asachuruService.saveProduct(asachuru);
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:asachuru:delete")
    @PostMapping("deleteSome")
    @ResponseBody
    @SysLog("删除资产数据(多个)")
    public ResponseEntity deleteSome(@RequestBody List<AsaChuru> asachuru) {
        if (asachuru == null || asachuru.size() == 0) {
            return ResponseEntity.failure("请选择要删除的资产");
        }
        for (AsaChuru a : asachuru) {
            asachuruService.removeById(a.getId());
        }
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:asachuru:delete")
    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除资产数据(单个)")
    public ResponseEntity delete(
            @RequestParam(value = "id", required = false) String id) {
        if (StringUtils.isBlank(id)) {
            return ResponseEntity.failure("参数错误");
        }
        asachuruService.removeById(id);
        return ResponseEntity.success("操作成功");
    }

    @GetMapping("edit")
    public String edit(String id, ModelMap modelMap) {
        AsaChuru asachuru = asachuruService.selectProductById(id);
        modelMap.put("localuser", asachuru);
        return "admin/asachuru/edit";
    }

    @RequiresPermissions("sys:asachuru:edit")
    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存资产编辑数据")
    public ResponseEntity edit(@RequestBody AsaChuru asachuru) {
        if (StringUtils.isBlank(asachuru.getLaifangName())) {
            return ResponseEntity.failure("来访人姓名不能为空");
        }
        if (StringUtils.isBlank(asachuru.getLaifangYuanyin())) {
            return ResponseEntity.failure("来访原因不能为空");
        }
        if (StringUtils.isBlank(asachuru.getLaifangDianhua())) {
            return ResponseEntity.failure("来访人电话不能为空");
        }
        if (StringUtils.isBlank(asachuru.getBeifangName())) {
            return ResponseEntity.failure("被访人姓名不能为空");
        }
        if (StringUtils.isBlank(asachuru.getBeifangSushehao())) {
            return ResponseEntity.failure("被访人宿舍不能为空");
        }
        if (StringUtils.isBlank(asachuru.getBeifangBanji())) {
            return ResponseEntity.failure("被访人班级不能为空");
        }
        if (StringUtils.isBlank(asachuru.getBeifangDianhua())) {
            return ResponseEntity.failure("被访人电话不能为空");
        }

        DateTimeFormatter df = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse(localTime, df);
        asachuru.setLaifangShijian(ldt);
        asachuruService.updateById(asachuru);
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:asachuru:edits")
    @PostMapping("edits")
    @ResponseBody
    @SysLog("保存资产编辑数据")
    public ResponseEntity edits(String id) {
        System.err.println(id);
        AsaChuru asachuru = new AsaChuru();
        DateTimeFormatter df = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse(localTime, df);
        asachuru.setLikeishijian(ldt);
        asachuru.setId(id);
        asachuruService.updateById(asachuru);
        return ResponseEntity.success("操作成功");
    }

}
