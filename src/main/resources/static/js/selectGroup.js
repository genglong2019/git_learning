$(document).ready(function(){
		$.ajax({
			type:"get",
			url:"http://localhost:8082/exams/modiyPapers",
			async:true,
			success:function(data){
				var js=JSON.parse(data);
				for(var i=0;i<js.books.length;i++) {
                    var p = "";

                    if (js.books[i].testtype == '1') {
                        p = "学生试题";
                    } else if (js.books[i].testtype == '2') {
                        p = "教员试题";
                    } else {
                        p = "班主任试题";
                    }
                    var num=i+1;
                    var m = "<tr><td><a href='#'>"+num
                        + "</a></td><td>" + js.books[i].test + "</td><td>" + p+ "</td>"
                        + "<td>" +js.books[i].testfrom+ "</td><td style='font-size: 15px" +
                        "'><a href='selectGroupByM.html?userid=" + js.books[i].testid + "'><img src='img/addQ.png' width='45px' height='45px'/></a></td></tr>";

                    $("#discounts").before(m);



                	}

				}
		});
})