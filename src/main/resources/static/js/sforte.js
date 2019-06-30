$(document).ready(function(){
	function getUrlParam(name){
		//构造一个含有目标参数的正则表达式对象
		var reg=new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		//匹配目标参数
		var r=window.location.search.substr(1).match(reg);
		//返回参数值
		if(r!=null) return unescape(r[2]);return null;
	}
  var id=getUrlParam('id');
    var monthid=window.localStorage.getItem('monthid');
    var scores={
    	"id":id,
		"monthid":monthid,
	}

    $.ajax({
				type: "get",
				url: "http://localhost:8082/exams/showquestion",
				async: false,
				data:scores,
				success: function(data) {
					if(data != "{}") {
						var js = JSON.parse(data);
						for(var i = 0; i < js.doexame.length; i++) {
							var imges0="";
							var imges1="";
							var imges2="";
							var imges3="";
							var img="";
							if(js.doexame[i].judges=="1"){
								img="yes";
							}else{
								img="no";
							}
							
							if(js.doexame[i].listop[0].judge=="1"){
								imges0="y";
							}else{
								imges0="n";
							}
								if(js.doexame[i].listop[1].judge=="1"){
								imges1="y";
							}else{
								imges1="n";
							}
								if(js.doexame[i].listop[2].judge=="1"){
								imges2="y";
							}else{
								imges2="n";
							}
								if(js.doexame[i].listop[3].judge=="1"){
								imges3="y";
							}else{
								imges3="n";
							}
							var n = i + 1;
							var m = "<div>" + n + ". " + js.doexame[i].test + "<img src='img/"+img+".png' width='50px' height='50px'/><br /><br />A:" + js.doexame[i].listop[0].fouroption + "&nbsp;&nbsp; <img src='img/"+imges0+".png'/><br /><br />"+
							"B:" + js.doexame[i].listop[1].fouroption + "&nbsp;&nbsp; <img src='img/"+imges1+".png'/><br /><br />C:" + js.doexame[i].listop[2].fouroption +
								"&nbsp;&nbsp; <img src='img/"+imges2+".png'/><br /><br />D:" + js.doexame[i].listop[3].fouroption + "&nbsp;&nbsp; <img src='img/"+imges3+".png'/><br /><br /></div>";
								$("#showquestion").before(m);
						}

					}
				}

			});
  
  
  
  
  
  
})