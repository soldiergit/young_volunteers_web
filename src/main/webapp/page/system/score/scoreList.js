layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        url : '../../../biz/volunteersignup_findAllVolunteerSignUp.action',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 20,
        id : "userListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'signUpId', title: '签到编号', align:'center'},
            {field: 'signIn', title: '是否签到', minWidth:100, align:'center',templet:function(d){
                    return d.signIn==1?'已签到':'未签到';
                }},
            // {field: 'volunteerId', title: '志愿者ID', minWidth:200, align:'center'},
            // {field: 'activityId', title: '活动ID', minWidth:200, align:'center'},
            {field: 'volunteerName', title: '志愿者姓名', minWidth:200, align:'center'},
            {field: 'volunteerScore', title: '获得分数', minWidth:200, align:'center'},
            {field: 'activityContent', title: '活动内容', minWidth:200, align:'center'},
            {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            var index = layer.msg('查询中,请稍候...',{icon: 16,time:false,shade:0})
            setTimeout(function(){
                table.reload("userListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            });
            layer.close(index);
        },800)
        } else{
            layer.msg("请输入搜索的内容");
        }
    });

    //添加用户
    function addUser(edit, updateFlag){
        var index = layui.layer.open({
            title : "添加",
            type : 2,
            content : "scoreAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".Id").val(edit.signUpId);
                    body.find(".volunteerId").val(edit.volunteerId);
                    body.find(".activityId").val(edit.activityId);
                    body.find(".signIn").val(edit.signIn);
                    body.find(".volunteerName").val(edit.volunteerName);
                    body.find(".activityContent").val(edit.activityContent);
                    body.find(".volunteerScore").val(edit.volunteerScore);
                    body.find(".updateFlag").val(updateFlag);//更新
                    form.render();
                }
            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    $(".addNews_btn").click(function(){
        addUser();
    })

    //批量删除
    // $(".delAll_btn").click(function(){
    //     var checkStatus = table.checkStatus('userListTable'),
    //         data = checkStatus.data,
    //         newsId = [];
    //     if(data.length > 0) {
    //         for (var i in data) {
    //             newsId.push(data[i].activityId);
    //         }
    //         layer.confirm('确定删除选中记录？', {icon: 3, title: '提示信息'}, function (index) {
    //             $.post("../../../biz/activity_deleteAllVolunteerActivity.action",{
    //                 ids : newsId.join(',') //将需要删除的newsId作为参数传入
    //             },function(data){
    //                 if (data.code===0){
    //                     layer.msg("删除成功");
    //                 }else {
    //                     layer.msg("删除失败");
    //                 }
    //             tableIns.reload();
    //             layer.close(index);
    //             })
    //         })
    //     }else{
    //         layer.msg("请选择需要删除的用户");
    //     }
    // })

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addUser(data, 0);
        }else if(layEvent === 'scoring'){ //评分
            addUser(data, 1);
            // layer.confirm('确定打分此活动？',{icon:3, title:'提示信息'},function(index){
            //     $.get("../../../biz/volunteersignup_saveVolunteerSignUp.action",{
            //         activityId : data.activityId,  //将需要打分的newsId作为参数传入
            //         userId : window.sessionStorage.getItem("userId")
            //     },function(data){
            //         if (data.code === 0){
            //             layer.msg("报名成功");
            //         }else {
            //             layer.msg("报名失败");
            //         }
            //         tableIns.reload();
            //         layer.close(index);
            //     })
            // });
        }
        // }else if(layEvent === 'del'){ //删除
        //     layer.confirm('确定删除此记录？',{icon:3, title:'提示信息'},function(index){
        //         $.get("../../../biz/volunteersignup_saveVolunteerSignUp.action",{
        //             activityId : data.activityId  //将需要删除的newsId作为参数传入
        //         },function(data){
        //             if (data.code === 0){
        //                 layer.msg("删除成功");
        //             }else {
        //                 layer.msg("删除失败");
        //             }
        //             tableIns.reload();
        //             layer.close(index);
        //         })
        //     });
        // }
    });

})
