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
import com.xiaoshu.admin.entity.AsaCaichan;
import com.xiaoshu.admin.service.AsaCaichanService;
import com.xiaoshu.common.annotation.SysLog;
import com.xiaoshu.common.base.PageData;
import com.xiaoshu.common.util.Msg;
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
@RequestMapping("/asaCaichan")
public class AsaCaichanController {

    @Autowired
    AsaCaichanService asacaichanService;

    @GetMapping("list")
    @SysLog("跳转系统用户列表页面")
    public String list() {
        return "admin/asacaichan/list";
    }

    @RequiresPermissions("sys:asacaichan:list")
    @PostMapping("list")
    @ResponseBody
    public PageData<AsaCaichan> list(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            ServletRequest request) {
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        PageData<AsaCaichan> asacaichanPageData = new PageData<>();
        QueryWrapper<AsaCaichan> asacaichanWrapper = new QueryWrapper<>();
        if (!map.isEmpty()) {
            String type = (String) map.get("type");
            if (StringUtils.isNotBlank(type)) {
                asacaichanWrapper.eq("is_admin",
                        "admin".equals(type) ? true : false);
            }
            String keys = (String) map.get("key");
            if (StringUtils.isNotBlank(keys)) {
                asacaichanWrapper
                        .and(wrapper -> wrapper.like("xuesheng_id", keys).or()
                                .like("personal_name", keys));
            }
        }
        IPage<AsaCaichan> asacaichanPage = asacaichanService
                .page(new Page<>(page, limit), asacaichanWrapper);

        asacaichanPageData.setCount(asacaichanPage.getTotal());
        asacaichanPageData.setData(asacaichanPage.getRecords());
        return asacaichanPageData;
    }

    @GetMapping("add")
    public String add(ModelMap modelMap) {
        List<AsaCaichan> asacaichanList = asacaichanService.selectAll();
        modelMap.put("asacaichanList", asacaichanList);
        return "admin/asacaichan/add";
    }

    @RequiresPermissions("sys:asacaichan:add")
    @PostMapping("add")
    @ResponseBody
    @SysLog("保存学生数据")
    public ResponseEntity add(@RequestBody AsaCaichan asacaichan) {
        if (StringUtils.isBlank(asacaichan.getXueshengId())) {
            return ResponseEntity.failure("学号不能为空");
        }
        if (StringUtils.isBlank(asacaichan.getPersonalName())) {
            return ResponseEntity.failure("姓名不能为空");
        }
        if (StringUtils.isBlank(asacaichan.getRemark())) {
            return ResponseEntity.failure("财产描述不能为空");
        }

        asacaichanService.saveProduct(asacaichan);
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:asacaichan:delete")
    @PostMapping("deleteSome")
    @ResponseBody
    @SysLog("删除资产数据(多个)")
    public ResponseEntity deleteSome(@RequestBody List<AsaCaichan> asacaichan) {
        if (asacaichan == null || asacaichan.size() == 0) {
            return ResponseEntity.failure("请选择要删除的资产");
        }
        for (AsaCaichan a : asacaichan) {
            asacaichanService.removeById(a.getId());
        }
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:asacaichan:delete")
    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除资产数据(单个)")
    public ResponseEntity delete(
            @RequestParam(value = "id", required = false) String id) {
        if (StringUtils.isBlank(id)) {
            return ResponseEntity.failure("参数错误");
        }
        asacaichanService.removeById(id);
        return ResponseEntity.success("操作成功");
    }

    @GetMapping("edit")
    public String edit(String id, ModelMap modelMap) {
        AsaCaichan asacaichan = asacaichanService.selectProductById(id);
        modelMap.put("localuser", asacaichan);
        return "admin/asacaichan/edit";
    }

    @RequiresPermissions("sys:asacaichan:edit")
    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存资产编辑数据")
    public ResponseEntity edit(@RequestBody AsaCaichan asacaichan) {
        if (StringUtils.isBlank(asacaichan.getXueshengId())) {
            return ResponseEntity.failure("学号不能为空");
        }
        if (StringUtils.isBlank(asacaichan.getPersonalName())) {
            return ResponseEntity.failure("姓名不能为空");
        }
        if (StringUtils.isBlank(asacaichan.getRemark())) {
            return ResponseEntity.failure("财产描述不能为空");
        }

        asacaichanService.updateById(asacaichan);
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:asaxuesheng:caichan")
    @PostMapping("caichan")
    @ResponseBody
    public Msg dizhi(String id) {
        AsaCaichan asacaichan = asacaichanService.chaxun(id);
        String address = asacaichan.getRemark();
        System.err.println("查询===" + address);
        return Msg.success().add("address", address);
    }

}
