package com.xiaoshu.admin.controller;

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
import com.xiaoshu.admin.entity.AsaXuesheng;
import com.xiaoshu.admin.service.AsaCaichanService;
import com.xiaoshu.admin.service.AsaXueshengService;
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
@RequestMapping("/asaXuesheng")
public class AsaXueshengController {

    @Autowired
    AsaXueshengService asaxueshengService;
    @Autowired
    AsaCaichanService asacaichanService;

    @GetMapping("list")
    @SysLog("跳转系统用户列表页面")
    public String list() {
        return "admin/asaxuesheng/list";
    }

    @RequiresPermissions("sys:asaxuesheng:list")
    @PostMapping("list")
    @ResponseBody
    public PageData<AsaXuesheng> list(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            ServletRequest request) {
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        PageData<AsaXuesheng> asaxueshengPageData = new PageData<>();
        QueryWrapper<AsaXuesheng> asaxueshengWrapper = new QueryWrapper<>();
        if (!map.isEmpty()) {
            String type = (String) map.get("type");
            if (StringUtils.isNotBlank(type)) {
                asaxueshengWrapper.eq("is_admin",
                        "admin".equals(type) ? true : false);
            }
            String keys = (String) map.get("key");
            if (StringUtils.isNotBlank(keys)) {
                asaxueshengWrapper.and(wrapper -> wrapper.like("name", keys)
                        .or().like("sno", keys).or().like("banji", keys).or()
                        .like("dorm", keys));
            }
        }
        IPage<AsaXuesheng> asaxueshengPage = asaxueshengService
                .page(new Page<>(page, limit), asaxueshengWrapper);

        asaxueshengPageData.setCount(asaxueshengPage.getTotal());
        asaxueshengPageData.setData(asaxueshengPage.getRecords());
        return asaxueshengPageData;
    }

    @GetMapping("add")
    public String add(ModelMap modelMap) {
        List<AsaXuesheng> asaxueshengList = asaxueshengService.selectAll();
        modelMap.put("asaxueshengList", asaxueshengList);
        return "admin/asaxuesheng/add";
    }

    @RequiresPermissions("sys:asaxuesheng:add")
    @PostMapping("add")
    @ResponseBody
    @SysLog("保存学生数据")
    public ResponseEntity add(@RequestBody AsaXuesheng asaxuesheng) {
        if (StringUtils.isBlank(asaxuesheng.getName())) {
            return ResponseEntity.failure("姓名不能为空");
        }
        if (StringUtils.isBlank(asaxuesheng.getSno())) {
            return ResponseEntity.failure("学号不能为空");
        }
        if (StringUtils.isBlank(asaxuesheng.getBanji())) {
            return ResponseEntity.failure("班级不能为空");
        }
        if (StringUtils.isBlank(asaxuesheng.getPhone())) {
            return ResponseEntity.failure("电话不能为空");
        }
        if (StringUtils.isBlank(asaxuesheng.getDorm())) {
            return ResponseEntity.failure("宿舍不能为空");
        }

        asaxueshengService.saveProduct(asaxuesheng);
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:asaxuesheng:delete")
    @PostMapping("deleteSome")
    @ResponseBody
    @SysLog("删除资产数据(多个)")
    public ResponseEntity deleteSome(
            @RequestBody List<AsaXuesheng> asaxuesheng) {
        if (asaxuesheng == null || asaxuesheng.size() == 0) {
            return ResponseEntity.failure("请选择要删除的资产");
        }
        for (AsaXuesheng a : asaxuesheng) {
            asaxueshengService.removeById(a.getId());
        }
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:asaxuesheng:delete")
    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除资产数据(单个)")
    public ResponseEntity delete(
            @RequestParam(value = "id", required = false) String id) {
        if (StringUtils.isBlank(id)) {
            return ResponseEntity.failure("参数错误");
        }
        asaxueshengService.removeById(id);
        return ResponseEntity.success("操作成功");
    }

    @GetMapping("edit")
    public String edit(String id, ModelMap modelMap) {
        AsaXuesheng asaxuesheng = asaxueshengService.selectProductById(id);
        modelMap.put("localuser", asaxuesheng);
        return "admin/asaxuesheng/edit";
    }

    @RequiresPermissions("sys:asaxuesheng:edit")
    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存资产编辑数据")
    public ResponseEntity edit(@RequestBody AsaXuesheng asaxuesheng) {
        if (StringUtils.isBlank(asaxuesheng.getName())) {
            return ResponseEntity.failure("姓名不能为空");
        }
        if (StringUtils.isBlank(asaxuesheng.getSno())) {
            return ResponseEntity.failure("学号不能为空");
        }
        if (StringUtils.isBlank(asaxuesheng.getBanji())) {
            return ResponseEntity.failure("班级不能为空");
        }
        if (StringUtils.isBlank(asaxuesheng.getPhone())) {
            return ResponseEntity.failure("电话不能为空");
        }
        if (StringUtils.isBlank(asaxuesheng.getDorm())) {
            return ResponseEntity.failure("宿舍不能为空");
        }

        asaxueshengService.updateById(asaxuesheng);
        return ResponseEntity.success("操作成功");
    }

}
