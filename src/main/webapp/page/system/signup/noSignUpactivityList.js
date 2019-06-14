layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        url : '../../../biz/activity_findAllVolunteerNojoinActivity.action',
        //url地址参数  -where
        where: {userId: window.sessionStorage.getItem("userId")},
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 20,
        id : "userListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'activityCode', title: '活动编号', align:'center'},
            {field: 'activityTitle', title: '活动标题', minWidth:100, align:"center"},
            {field: 'activityContent', title: '活动内容', minWidth:200, align:'center'},
            {field: 'activityLeader', title: '活动负责人', minWidth:200, align:'center'},
            {field: 'activityPeopleNum', title: '活动人数', minWidth:200, align:'center'},
            {field: 'activityStartTime', title: '活动开始时间', minWidth:200, align:'center'},
            {field: 'activityEndTime', title: '活动结束时间', minWidth:200, align:'center'},
            {field: 'activitySignStartTime', title: '活动报名开始时间', minWidth:200, align:'center'},
            {field: 'activitySignEndTime', title: '活动报名结束时间', minWidth:200, align:'center'},
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

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('userListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].activityId);
            }
            layer.confirm('确定删除选中记录？', {icon: 3, title: '提示信息'}, function (index) {
                $.post("../../../biz/activity_deleteAllVolunteerActivity.action",{
                    ids : newsId.join(',') //将需要删除的newsId作为参数传入
                },function(data){
                    if (data.code===0){
                        layer.msg("删除成功");
                    }else {
                        layer.msg("删除失败");
                    }
                tableIns.reload();
                layer.close(index);
                })
            })
        }else{
            layer.msg("请选择需要删除的用户");
        }
    })

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
         if(layEvent === 'signup'){
            layer.confirm('确定报名此活动？',{icon:3, title:'提示信息'},function(index){
                $.get("../../../biz/volunteersignup_saveVolunteerSignUp.action",{
                    activityId : data.activityId,  //将需要报名的newsId作为参数传入
                    activityContent : data.activityContent,  //活动内容
                    userId : window.sessionStorage.getItem("userId"),
                    userName : window.sessionStorage.getItem("userName"),
                },function(data){
                    if (data.code === 0){
                        layer.msg("报名成功");
                    }else {
                        layer.msg("报名失败");
                    }
                    tableIns.reload();
                    layer.close(index);
                })
            });
        }
    });

})
