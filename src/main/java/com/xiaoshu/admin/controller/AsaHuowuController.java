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
import com.xiaoshu.admin.entity.AsaHuowu;
import com.xiaoshu.admin.service.AsaHuowuService;
import com.xiaoshu.common.annotation.SysLog;
import com.xiaoshu.common.base.PageData;
import com.xiaoshu.common.util.ResponseEntity;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author shen-ke
 * @since 2019-03-29
 */
@Controller
@RequestMapping("/asaHuowu")
public class AsaHuowuController {
    @Autowired
    AsaHuowuService asahuowuService;

    @GetMapping("list")
    @SysLog("跳转系统用户列表页面")
    public String list() {
        return "admin/asahuowu/list";
    }

    @RequiresPermissions("sys:asahuowu:list")
    @PostMapping("list")
    @ResponseBody
    public PageData<AsaHuowu> list(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            ServletRequest request) {
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        PageData<AsaHuowu> asahuowuPageData = new PageData<>();
        QueryWrapper<AsaHuowu> asahuowuWrapper = new QueryWrapper<>();
        if (!map.isEmpty()) {
            String type = (String) map.get("type");
            if (StringUtils.isNotBlank(type)) {
                asahuowuWrapper.eq("is_admin",
                        "admin".equals(type) ? true : false);
            }
            String keys = (String) map.get("key");
            if (StringUtils.isNotBlank(keys)) {
                asahuowuWrapper.and(wrapper -> wrapper.like("name", keys).or()
                        .like("sno", keys).or().like("banji", keys).or()
                        .like("dorm", keys));
            }
        }
        IPage<AsaHuowu> asahuowuPage = asahuowuService
                .page(new Page<>(page, limit), asahuowuWrapper);

        asahuowuPageData.setCount(asahuowuPage.getTotal());
        asahuowuPageData.setData(asahuowuPage.getRecords());
        return asahuowuPageData;
    }

    @GetMapping("add")
    public String add(ModelMap modelMap) {
        List<AsaHuowu> asahuowuList = asahuowuService.selectAll();
        modelMap.put("asahuowuList", asahuowuList);
        return "admin/asahuowu/add";
    }

    @RequiresPermissions("sys:asahuowu:add")
    @PostMapping("add")
    @ResponseBody
    @SysLog("保存学生数据")
    public ResponseEntity add(@RequestBody AsaHuowu asahuowu) {
        if (StringUtils.isBlank(asahuowu.getXingming())) {
            return ResponseEntity.failure("姓名不能为空");
        }
        if (StringUtils.isBlank(asahuowu.getXuehao())) {
            return ResponseEntity.failure("学号不能为空");
        }
        if (StringUtils.isBlank(asahuowu.getBanji())) {
            return ResponseEntity.failure("班级不能为空");
        }
        if (StringUtils.isBlank(asahuowu.getSushe())) {
            return ResponseEntity.failure("宿舍不能为空");
        }
        if (StringUtils.isBlank(asahuowu.getDianhua())) {
            return ResponseEntity.failure("电话不能为空");
        }
        if (StringUtils.isBlank(asahuowu.getHuowu())) {
            return ResponseEntity.failure("货物名称不能为空");
        }
        if (StringUtils.isBlank(asahuowu.getChuliren())) {
            return ResponseEntity.failure("处理人不能为空");
        }
        DateTimeFormatter df = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse(localTime, df);
        asahuowu.setShijian(ldt);
        asahuowuService.saveProduct(asahuowu);
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:asahuowu:delete")
    @PostMapping("deleteSome")
    @ResponseBody
    @SysLog("删除资产数据(多个)")
    public ResponseEntity deleteSome(@RequestBody List<AsaHuowu> asahuowu) {
        if (asahuowu == null || asahuowu.size() == 0) {
            return ResponseEntity.failure("请选择要删除的资产");
        }
        for (AsaHuowu a : asahuowu) {
            asahuowuService.removeById(a.getId());
        }
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:asahuowu:delete")
    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除资产数据(单个)")
    public ResponseEntity delete(
            @RequestParam(value = "id", required = false) String id) {
        if (StringUtils.isBlank(id)) {
            return ResponseEntity.failure("参数错误");
        }
        asahuowuService.removeById(id);
        return ResponseEntity.success("操作成功");
    }

    @GetMapping("edit")
    public String edit(String id, ModelMap modelMap) {
        AsaHuowu asahuowu = asahuowuService.selectProductById(id);
        modelMap.put("localuser", asahuowu);
        return "admin/asahuowu/edit";
    }

    @RequiresPermissions("sys:asahuowu:edit")
    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存资产编辑数据")
    public ResponseEntity edit(@RequestBody AsaHuowu asahuowu) {
        if (StringUtils.isBlank(asahuowu.getXingming())) {
            return ResponseEntity.failure("姓名不能为空");
        }
        if (StringUtils.isBlank(asahuowu.getXuehao())) {
            return ResponseEntity.failure("学号不能为空");
        }
        if (StringUtils.isBlank(asahuowu.getBanji())) {
            return ResponseEntity.failure("班级不能为空");
        }
        if (StringUtils.isBlank(asahuowu.getSushe())) {
            return ResponseEntity.failure("宿舍不能为空");
        }
        if (StringUtils.isBlank(asahuowu.getDianhua())) {
            return ResponseEntity.failure("电话不能为空");
        }
        if (StringUtils.isBlank(asahuowu.getHuowu())) {
            return ResponseEntity.failure("货物名称不能为空");
        }
        if (StringUtils.isBlank(asahuowu.getChuliren())) {
            return ResponseEntity.failure("处理人不能为空");
        }
        DateTimeFormatter df = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse(localTime, df);
        asahuowu.setShijian(ldt);
        asahuowuService.updateById(asahuowu);
        return ResponseEntity.success("操作成功");
    }

}
