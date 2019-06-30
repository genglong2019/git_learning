$(document).ready(function(){

 


		
		$.ajax({
			type:"get",
			url:"http://localhost:8082/manager/showUsers",
			async:true,
			success:function(data){
				var js=JSON.parse(data);
				for(var i=0;i<js.books.length;i++) {
                    var p = "";

                    if (js.books[i].usestate == '1') {
                        p = "学生";
                    } else if (js.books[i].usestate == '2') {
                        p = "教员";
                    } else {
                        p = "班主任";
                    }
                    var m = "<tr><td><a href='#'><img src='img/" + js.books[i].uimgs
                        + "' alt='' title='' border='0' class='cart_thumb' height='40px' width='35px'/>"
                        + "</a></td><td>" + js.books[i].uname + "</td><td>" + js.books[i].gid + "</td>"
                        + "<td>" + p + "</td><td style='font-size: 15px" +
                        "'><a href='updateUsers.html?userid=" + js.books[i].id + "'><img src='img/updateUser.png'/></a></td><td><a id='modal-385697' href='#modal-container-"+js.books[i].id+"' role='button' class='btn' data-toggle='modal'><img src='img/DeleteUser.png'/></a></td></tr>";

                    $("#discounts").after(m);


                    var n="<div class='modal fade' id='modal-container-"+js.books[i].id+"' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>"
                        +"<div class='modal-dialog'><div class='modal-content'><div class='modal-header'>"
                        +"<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>×</button>"
                        +"<h4 class='modal-title' id='myModalLabel'>用户:"+js.books[i].uname+"&nbsp;&nbsp;&nbsp;类型:"+p+"</h4></div>"
                        +"<div class='modal-body' style='color: red;font-size: 20px;'>确认是否删除此用户信息</div>"
                        +"<div class='modal-footer'> <button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>"
                        +"<a href='delUser.html?userid="+js.books[i].id+"'><button  class='btn btn-primary'>删除</button></a></div>	</div></div></div>";
                    $("#t_s").after(n);
                	}

				}
		});
})