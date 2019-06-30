$(document).ready(function() {

    var usestate="1";
    var gid=window.localStorage.getItem('gid');
    var userinfo={
    	"usestate":usestate,
		"gid":gid,
	}
			$.ajax({
				type: "get",
				url: "http://localhost:8082/exams/TeSeeSRu",
				async: true,
				data:userinfo,
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
							var m="<tr class='"+clo+"'><td>研发"+gid+"</td><td>"+js.show1[i].monthss+"</td><td>"+js.show1[i].maxru+"</td>"+
							"<td>"+js.show1[i].minru+"</td><td>"+js.show1[i].avgru+"</td><td><a href='forGidByTechno.html?monthid="+js.show1[i].monthid+"'>查看</a></td></tr>";
							$("#showexamrecond").before(m);
								

						}

					}
				}

			});

		})