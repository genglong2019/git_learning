$(document).ready(function(){
function setCookie(cname,cvalue,exdays){
	var d = new Date();
	d.setTime(d.getTime()+(exdays*24*60*60*1000));
	var expires = "expires="+d.toGMTString();
	document.cookie = cname+"="+cvalue+"; "+expires;
}
	$("#login_form").submit(function(){ 
		var uname = $("#username").val();
		var upwd = $("#upwd").val();
		var userinfo = {
			"uname": uname,
			"upwd": upwd,
		};
		$.ajax({
			type:"get",
			url:"http://localhost:8082/manager/logins",
			async:false,
			data:userinfo,
			success: function(data) {

					var js=JSON.parse(data);
					if(js.msg=="1"){

                        alert("帐号和密码不一致，请重新登录")

                    }else if(js.msg=="0"){
                        alert("此用户名不存在！")

					} else {

						var id=js.msg.id;
						var userstate=js.msg.usestate;
						var selfImgs=js.msg.uimgs;
						var chiname=js.msg.chiname;
						var gid=js.msg.gid;
						var usestate=js.msg.usestate;
                        window.localStorage.setItem('id',id);
                        window.localStorage.setItem('img',selfImgs);
                        window.localStorage.setItem('uname',uname);
                        window.localStorage.setItem('chiname',chiname);
                        window.localStorage.setItem('upwd',upwd);
                        window.localStorage.setItem('gid',gid);
                        window.localStorage.setItem('ustate',usestate);
						if(userstate=="1"){
							window.location.href="main.html";
						}else if(userstate=="2"){
							window.location.href="technologyTe.html";
						}else {
							window.location.href="headTe.html";
						}
					}
			}
		});
		return false;
	});
})
