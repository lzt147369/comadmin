layui.use(['form', 'jquery', 'layer'], function () {
    var form = layui.form,
        $ = layui.jquery,
        layer = layui.layer;   //默认启用用户

    form.on("submit(addUser)", function (data) {
        var loadIndex = layer.load(2, {
            shade: [0.3, '#333']
        });
        //给角色赋值
        delete data.field["roles"];
        var selectRole = [];
        $('input[name="roles"]:checked').each(function () {
            selectRole.push({"id": $(this).val()});
        });
        data.field.roleLists = selectRole;

        //判断用户是否后台用户
        if (undefined !== data.field.adminUser && null != data.field.adminUser) {
            data.field.adminUser = true;
        } else {
            data.field.adminUser = false;
        }

        var aSum = data.field.aUnivalence * data.field.aQuantity;
        data.field.aSum = aSum
        if (data.field.xingming == null) {
            layer.msg("姓名不能为空");
            return false;
        }
        if (data.field.xuehao == null) {
            layer.msg("学号不能为空");
            return false;
        }
        if (data.field.banji == null) {
            layer.msg("班级不能为空");
            return false;
        }
        if (data.field.sushe == null) {
            layer.msg("宿舍不能为空");
            return false;
        }
        if (data.field.dianhua == null) {
            layer.msg("电话不能为空");
            return false;
        }
        if (data.field.huowu == null) {
            layer.msg("货物名称不能为空");
            return false;
        }
        if (data.field.chuliren == null) {
            layer.msg("处理人不能为空");
            return false;
        }
        if (data.field.churu == null) {
            layer.msg("货物进出不能为空");
            return false;
        }


        $.ajax({
            type: "POST",
            url: "/asaHuowu/add",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(data.field),
            success: function (res) {
                layer.close(loadIndex);
                if (res.success) {
                    parent.layer.msg("操作成功!", {time: 1500}, function () {
                        //刷新父页面
                        parent.location.reload();
                    });
                } else {
                    layer.msg(res.message);
                }
            }
        });
        return false;
    });

    form.on('switch(adminUser)', function (data) {
        $("#adminUser").val(data.elem.checked);
    });

    form.on('switch(locked)', function (data) {
        $("#locked").val(data.elem.checked);
    });

});