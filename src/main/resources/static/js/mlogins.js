$(document).ready(function() {
    var p=getCookie('pswd');
    var u=getCookie('user');
    $("#user").val(u);
    $("#pswd").val(p);
    $("#loginForm").submit(function(){
        var oUser =$("#user").val();
        var oPswd = $("#pswd").val();

        var adminers= {
            "adminername": oUser,
            "adminerpwd": oPswd,
        };
        var state="";
        var obj=document.getElementsByName("checkBox");
        for(var i=0;i<obj.length; i++){
            if(obj[i].checked){
                state=obj[i].value;
            }
        }
        if(state==""){
            delCookie('user');
            delCookie('pswd');
        }else{
            setCookie('user',oUser,7); //保存帐号到cookie，有效期7天
            setCookie('pswd',oPswd,7); //保存密码到cookie，有效期7天
        }


        $.ajax({
            type:"get",
            url:"http://localhost:8082/manager/mlogins",
            async:false,
            data:adminers,
            success: function(data) {

                var js=JSON.parse(data);
                if(js.msg=="1"){
                    setCookie('user',oUser,7);
                    setCookie('pwd',oPswd,7);
                    alert("登录成功！")
                    window.location.href="managersSys.html";

                }else{

                    alert("帐号和密码不一致，请重新登录")
                }
            }

        });

        return false;
    })

    //设置cookie
    function setCookie(name,value,day){
        var date = new Date();
        date.setDate(date.getDate() + day);
        document.cookie = name + '=' + value + ';expires='+ date;
    };
    //获取cookie
    function getCookie(name){
        var reg = RegExp(name+'=([^;]+)');
        var arr = document.cookie.match(reg);
        if(arr){
            return arr[1];
        }else{
            return '';
        }
    };
    //删除cookie
    function delCookie(name){
        setCookie(name,null,-1);
    };

})