layui.use(['form','layer','laydate'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#volunteerJoinTime' ,//指定元素
        type: 'date',
        done: function(value, date, endDate){
    }

});

    form.on("submit(addUser)",function(data){
        //新增,更新
        var updateFlag = $(".updateFlag").val().valueOf();//0:添加 1:更新
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        // 实际使用时的提交信息
        $.post(updateFlag==='0'?"../../../biz/volunteer_saveVolunteer.action":"../../../sysJson/volunteer_updateVolunteer.action",{//
            volunteerId : updateFlag==='0'?null:$(".Id").val(),//id
            volunteerCode : $(".volunteerCode").val(),  //登录名
            volunteerClass : $(".volunteerClass").val(),  //邮箱
            volunteerCollege : $(".volunteerCollege").val(),
            volunteerJoinTimes : $(".volunteerJoinTime").val(),
            volunteerEmail : $(".volunteerEmail").val(),
            volunteerName : $(".volunteerName").val(),
            volunteerPhone : $(".volunteerPhone").val(),
            volunteerSex : $(".volunteerSex").val(),
        },function(res){
            if (res.code === 0){
                top.layer.close(index);
                top.layer.msg(updateFlag==='0'?"添加活动！":"修改成功");
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            }else {
                top.layer.close(index);
                top.layer.msg("操作失败！");
            }
        })
        return false;
    })
    function dateToStringForLayui(dateObj) {
        var FullYear = dateObj.year;
        var Month = dateObj.month;
        var Day = dateObj.date;
        var Hours = dateObj.hours;
        var Minutes = dateObj.minutes;
        var Seconds = dateObj.seconds;
        return FullYear + "-" + Month + "-" + Day + " " + Hours + ":" + Minutes + ":" + Seconds
    }
        //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());

})