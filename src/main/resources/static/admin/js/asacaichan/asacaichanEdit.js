var index = parent.layer.getFrameIndex(window.name); //当前窗口索引
layui.use(['form', 'jquery', 'layer'], function () {
    var form = layui.form,
        $ = layui.jquery,
        layer = layui.layer;

    form.on("submit(editUser)", function (data) {
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
        if (data.field.xueshengId == null) {
            layer.msg("学号不能为空");
            return false;
        }
        if (data.field.personalName == null) {
            layer.msg("姓名不能为空");
            return false;
        }
        if (data.field.remark == null) {
            layer.msg("个人财物描述不能为空");
            return false;
        }


        $.ajax({
            type: "POST",
            url: "/asaCaichan/edit",
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