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
			url:"http://localhost:8082/exams/"+userid+"/selQueByid",
			async:true,
			success:function(data){
				var js=JSON.parse(data);
				$("#testid").val(js.que.testid);
                $("#test").val(js.que.test);
                $("#firstopt").val(js.que.listop[0].fouroption);
				$("#secondopt").val(js.que.listop[1].fouroption);
				$("#thirdopt").val(js.que.listop[2].fouroption);
				$("#fourthopt").val(js.que.listop[3].fouroption);
				$("#testfrom").val(js.que.testfrom);
				
				
			}
			
		})
	
	
})
