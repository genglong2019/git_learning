$(document).ready(function() {

    var ss=window.localStorage.getItem('id');
			$.ajax({
				type: "get",
				url: "http://localhost:8082/exams/"+ss+"/showExamRecond",
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
							var m="<tr class='"+clo+"'><td>"+n+"</td><td>模拟"+n+"</td><td>"+js.show1[i].sdateing+"</td>"+
							"<td>"+js.show1[i].scoress+"</td><td>模拟考试</td><td><a href='showQuePaperforte.html?eid="+js.show1[i].monthid+"'>查看</a></td></tr>";
							$("#showexamrecond").before(m);
								

						}

					}
				}

			});

		})