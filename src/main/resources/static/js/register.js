$(function(){
	//变量初始化
	
		//1.用户名以大小写字母开头，后面跟着3-15位大小写字母或者数字
			var regUser=/^[a-zA-Z][a-zA-Z0-9]{3,15}$/;
		/*	var use=$("#oneput").val();*/
		
		//2.密码仅允许大小写字母数字，4到10位；不能用\w会匹配下划线
	/*		var pwd = $("#twoput").val();*/
			var regPwd = /^[a-zA-Z0-9]{4,10}$/;
			
		//3.邮箱变量
		/*	var email = $("#threeput").val();*/
			var regEmail =/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
			
		//4.手机号码只能是1开头的11位数字
	/*		var mobile = $("#tel").val();*/
			var regMobile = /^1\d{10}$/;	
			
		//生日的年份为1900～2016
	/*		var birth = $("#birth").val();*/
			var regBirth = /^((19\d{2})|(200\d)|(201[0-6]))-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2]\d|3[0-1])$/;
			
			
			
	//认证方法
	function checkRegister(reg,use){
		if(reg.test(use)==false){
			return true;
		}	
		return false;
	}
	
	
	//用户名认证
	
	
	$("#oneput").blur(function () {
		var use=$("#oneput").val();
		if (checkRegister(regUser,use)) {
			alert("用户名输入错误");
			return true;
		}
	
		
	});

	

	//密码验证
	$("#twoput").blur(function () {
		var pwd = $("#twoput").val();
		
		if (checkRegister(regPwd,pwd)){
			alert("密码不能含有非法字符，长度在4-10之间");
			return true;
		}

	});
	$("#twoput1").blur(function () {
		var pwd =$("#twoput").val();
		var repwd = $("#twoput1").val();

		if (pwd == repwd) {
		
			return false;
		}
			alert("两次输入的密码不一致");
		return true;
	});
		
	
	//验证邮箱
	$("#threeput").blur(function () {
			var email = $("#threeput").val();
		if (checkRegister(regEmail,email)) {
			alert("Email格式不正确");
			return false;
		}
	
		return true;
	});
	//验证手机号码
	$("#tel").blur(function () {
		var mobile = $("#tel").val();
		if (checkRegister(regMobile,mobile)) {
		alert("电话号码格式不正确");
			return false;
		}
		
		return true;
	});
		//生日验证
	$("#birth").blur(function () {
		var birth = $("#birth").val();
		if (checkRegister(regBirth,birth)) {
			$("#birth_prompt").html("生日格式不正确");
			return false;
		}
		$("#birth_prompt").html("");
		return true;
	});	
		
	
	//注册认证
    $("#addUsers_form").submit(function(){
        var use = $("#oneput").val();
        var pwd  = $("#twoput").val();
        var email=$("#threeput").val();
        var grandid=$("#grandid").val();
        var state;
        var obj=document.getElementsByName("usestate");
        for(var i=0;i<obj.length; i++){
            if(obj[i].checked){
                state=obj[i].value;
            }
        }


        var userinfo = {
            "uname": use,
            "upwd": pwd,
            "email":email,
			"gid":grandid,
            "usestate":state,
        };
        $.ajax({
            type:"post",
            url:"http://localhost:8082/manager/addUserInfo",
            async:false,
            data:userinfo,
            success: function() {
            	window.location.href="updateStudent.html";
            }
        });
        return false;
    });


});