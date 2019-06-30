$(document).ready(function() {


    var chiname=window.localStorage.getItem('chiname');
    var uname=window.localStorage.getItem('uname')
    var id=window.localStorage.getItem('id');
    var upwd=window.localStorage.getItem('upwd');
    var m="<div style='text-align: center;color: white;font-size: 20px; margin-top:10px ;'>"+chiname+"</div>" +
        "<div style='text-align: center;color: white;font-size: 20px;'>UID:"+id+"</div>";
    $("#imgs").after(m);
    $("#uname").val(uname);

    $("#oldpwd").blur(function () {
        var pwd =$("#oldpwd").val();
        if (pwd == upwd) {
            return false;
        }
        alert("输入的旧密码不一致");
        return true;
    });

    $("#configpwd").blur(function () {
        var pwd =$("#newpwd").val();
        var repwd = $("#configpwd").val();

        if (pwd == repwd) {

            return false;
        }
        alert("两次输入的密码不一致");
        return true;
    });

    $("#UForm").submit(function () {
        var newpwd = $("#newpwd").val();
        var userinfo= {
            "id": id,
            "upwd": newpwd,
        };
        $.ajax({
            type: "get",
            url: "http://localhost:8082/manager/updateUPwd",
            async: false,
            data: userinfo,
            success: function () {


                window.location.href = "switchs.html";
            }
        });
        return false;
    })
})