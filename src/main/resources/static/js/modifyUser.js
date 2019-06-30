$(document).ready(function(){
	function getUrlParam(name){
		//构造一个含有目标参数的正则表达式对象
		var reg=new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		//匹配目标参数
		var r=window.location.search.substr(1).match(reg);
		//返回参数值
		if(r!=null) return unescape(r[2]);return null;
	}
  var userid=getUrlParam('userid');
  

	$.ajax({
			type:"get",
			url:"http://localhost:8082/manager/"+userid+"/selByid",
			async:true,
			success:function(data){
				var js=JSON.parse(data);
				$("#id").val(js.users.id);
				$("#uname").val(js.users.uname);
				$("#gid").val(js.users.gid);
				$("#email").val(js.users.email);
				
				
			}
			
		})
	
	
})
