$(document).ready(function() {

    var usestate="1";
    var gid=window.localStorage.getItem('gid');
    var userinfo={
    	"usestate":usestate,
		"gid":gid,
	}
			$.ajax({
				type: "get",
				url: "http://localhost:8082/manager/showUsersByhete",
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
							var m="<tr class='"+clo+"' style='line-height: 25px;text-align: center'><td>"+n+"</td><td><img src='img/"+js.show1[i].uimgs+"' width='40px' height='35px'/></td><td>"+js.show1[i].chiname+"</td>"+
							"<td>研发"+js.show1[i].gid+"</td><td>"+js.show1[i].email+"</td><td>学生</td></tr>";
							$("#showexamrecond").before(m);
								

						}

					}
				}

			});

		})