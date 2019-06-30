$(document).ready(function() {
    function getUrlParam(name){
        //构造一个含有目标参数的正则表达式对象
        var reg=new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        //匹配目标参数
        var r=window.location.search.substr(1).match(reg);
        //返回参数值
        if(r!=null) return unescape(r[2]);return null;
    }
    var monthid=getUrlParam('monthid');
    window.localStorage.setItem('monthid',monthid);

			$.ajax({
				type: "get",
				url: "http://localhost:8082/exams/"+monthid+"/forGiByTechno",
				async: true,
				success: function(data) {
					if(data != "{}") {
						var js = JSON.parse(data);
						for(var i = 0; i < js.show1.length; i++) {
							var n = i + 1;
							var clo="";
							if(n%2==1){
								clo="warning";
							}else{
								clo="info";
							}
							var m="<tr class='"+clo+"'><td>"+n+"</td><td>"+js.show1[i].chiname+"</td>"+
							"<td>"+js.show1[i].scoress+"</td><td><a href='showQuePaperofte.html?id="+js.show1[i].id
								+"'>查看</a></td></tr>";
							$("#showexamrecond").before(m);
								

						}

					}
				}

			});

		})