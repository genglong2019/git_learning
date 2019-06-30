$(document).ready(function(){
    var ustate=window.localStorage.getItem('ustate');
    var gid=window.localStorage.getItem('gid');
    var chiname=window.localStorage.getItem('chiname');
    var userinfo={
        "gid":gid,
        "usestate":ustate,
    }
    $.ajax({
        type:"get",
        url:"http://localhost:8082/exams/TeSeeSfresult",
        async:true,
        data:userinfo,
        success:function(data) {
            js = JSON.parse(data);
            if ("" != js) {
                var m = "<div><h3>你好, "+chiname+"老师</h3><p>本月份，学生对您满意度的分数为："+js.sfr.tescores+"分，感谢您对学生的孜孜教诲!</p>" +
                    "</div>";
                $("#sfresult").after(m);
            }
        }
    });



})