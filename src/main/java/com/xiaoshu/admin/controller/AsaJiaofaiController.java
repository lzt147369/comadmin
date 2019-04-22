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
import com.xiaoshu.admin.entity.AsaJiaofai;
import com.xiaoshu.admin.service.AsaJiaofaiService;
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
@RequestMapping("/asaJiaofai")
public class AsaJiaofaiController {

    @Autowired
    AsaJiaofaiService asajiaofaiService;

    @GetMapping("list")
    @SysLog("跳转系统用户列表页面")
    public String list() {
        return "admin/asajiaofai/list";
    }

    @RequiresPermissions("sys:asajiaofai:list")
    @PostMapping("list")
    @ResponseBody
    public PageData<AsaJiaofai> list(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            ServletRequest request) {
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        PageData<AsaJiaofai> asajiaofaiPageData = new PageData<>();
        QueryWrapper<AsaJiaofai> asajiaofaiWrapper = new QueryWrapper<>();
        if (!map.isEmpty()) {
            String type = (String) map.get("type");
            if (StringUtils.isNotBlank(type)) {
                asajiaofaiWrapper.eq("is_admin",
                        "admin".equals(type) ? true : false);
            }
            String keys = (String) map.get("key");
            if (StringUtils.isNotBlank(keys)) {
                asajiaofaiWrapper.and(wrapper -> wrapper.like("sushehao", keys)
                        .or().like("jiaofaileixing", keys).or()
                        .like("jiaofairen", keys).or().like("chuliren", keys));
            }
        }
        IPage<AsaJiaofai> asajiaofaiPage = asajiaofaiService
                .page(new Page<>(page, limit), asajiaofaiWrapper);

        asajiaofaiPageData.setCount(asajiaofaiPage.getTotal());
        asajiaofaiPageData.setData(asajiaofaiPage.getRecords());
        return asajiaofaiPageData;
    }

    @GetMapping("add")
    public String add(ModelMap modelMap) {
        List<AsaJiaofai> asajiaofaiList = asajiaofaiService.selectAll();
        modelMap.put("asajiaofaiList", asajiaofaiList);
        return "admin/asajiaofai/add";
    }

    @RequiresPermissions("sys:asajiaofai:add")
    @PostMapping("add")
    @ResponseBody
    @SysLog("保存学生数据")
    public ResponseEntity add(@RequestBody AsaJiaofai asajiaofai) {
        if (StringUtils.isBlank(asajiaofai.getSushehao())) {
            return ResponseEntity.failure("宿舍号不能为空");
        }
        if (StringUtils.isBlank(asajiaofai.getJiaofaileixing())) {
            return ResponseEntity.failure("缴费类型不能为空");
        }
        if (StringUtils.isBlank(asajiaofai.getJiaofaijine())) {
            return ResponseEntity.failure("缴费金额不能为空");
        }
        if (StringUtils.isBlank(asajiaofai.getJiaofairen())) {
            return ResponseEntity.failure("缴费人不能为空");
        }
        if (StringUtils.isBlank(asajiaofai.getChuliren())) {
            return ResponseEntity.failure("处理人不能为空");
        }

        DateTimeFormatter df = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse(localTime, df);
        asajiaofai.setJiaofaishijian(ldt);

        asajiaofaiService.saveProduct(asajiaofai);
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:asajiaofai:delete")
    @PostMapping("deleteSome")
    @ResponseBody
    @SysLog("删除资产数据(多个)")
    public ResponseEntity deleteSome(@RequestBody List<AsaJiaofai> asajiaofai) {
        if (asajiaofai == null || asajiaofai.size() == 0) {
            return ResponseEntity.failure("请选择要删除的资产");
        }
        for (AsaJiaofai a : asajiaofai) {
            asajiaofaiService.removeById(a.getId());
        }
        return ResponseEntity.success("操作成功");
    }

    @RequiresPermissions("sys:asajiaofai:delete")
    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除资产数据(单个)")
    public ResponseEntity delete(
            @RequestParam(value = "id", required = false) String id) {
        if (StringUtils.isBlank(id)) {
            return ResponseEntity.failure("参数错误");
        }
        asajiaofaiService.removeById(id);
        return ResponseEntity.success("操作成功");
    }

    @GetMapping("edit")
    public String edit(String id, ModelMap modelMap) {
        AsaJiaofai asajiaofai = asajiaofaiService.selectProductById(id);
        modelMap.put("localuser", asajiaofai);
        return "admin/asajiaofai/edit";
    }

    @RequiresPermissions("sys:asajiaofai:edit")
    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存资产编辑数据")
    public ResponseEntity edit(@RequestBody AsaJiaofai asajiaofai) {
        if (StringUtils.isBlank(asajiaofai.getSushehao())) {
            return ResponseEntity.failure("宿舍号不能为空");
        }
        if (StringUtils.isBlank(asajiaofai.getJiaofaileixing())) {
            return ResponseEntity.failure("缴费类型不能为空");
        }
        if (StringUtils.isBlank(asajiaofai.getJiaofaijine())) {
            return ResponseEntity.failure("缴费金额不能为空");
        }
        if (StringUtils.isBlank(asajiaofai.getJiaofairen())) {
            return ResponseEntity.failure("缴费人不能为空");
        }
        if (StringUtils.isBlank(asajiaofai.getChuliren())) {
            return ResponseEntity.failure("处理人不能为空");
        }

        DateTimeFormatter df = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse(localTime, df);
        asajiaofai.setJiaofaishijian(ldt);

        asajiaofaiService.updateById(asajiaofai);
        return ResponseEntity.success("操作成功");
    }

}
