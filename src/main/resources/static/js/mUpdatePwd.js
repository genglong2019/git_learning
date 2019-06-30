$(document).ready(function() {

    function getCookie(name){
        var reg = RegExp(name+'=([^;]+)');
        var arr = document.cookie.match(reg);
        if(arr){
            return arr[1];
        }else{
            return '';
        }
    };
    var usename=getCookie('user');

    $("#uname").val(usename);
    var upwd=getCookie('pwd');
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

    $("#mUForm").submit(function () {
        var newpwd = $("#newpwd").val();
        var adminers= {
            "adminername": usename,
            "adminerpwd": newpwd,
        };
        $.ajax({
            type: "get",
            url: "http://localhost:8082/manager/updateAdmins",
            async: false,
            data: adminers,
            success: function () {


                window.location.href = "managerlogin.html";
            }
        });
        return false;
    })
})