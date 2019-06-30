$(document).ready(function(){
		$.ajax({
        type:"get",
        url:"http://localhost:8082/exams/satifisy",
        async:true,
        success:function(data){
            var js=JSON.parse(data);
            for(var i=0;i<js.books.length;i++) {
                var p = "";

                if (js.books[i].sftype == '2') {
                    p = "教员调查表";
                } else {
                    p = "班主任调查表";
                }
                var num=i+1;
                var m = "<tr><td><a href='#'>"+num
                    + "</a></td><td>" + js.books[i].sfhead + "</td><td>" + p+ "</td>"
                    + "<td><a id='modal-385697' href='#modal-container-"+js.books[i].satifiyid+"' role='button' class='btn' data-toggle='modal'><img src='img/delePapers.png' width='45px' height='45px'/></a></td></tr>";

                $("#discounts").before(m);


                var n="<div class='modal fade' id='modal-container-"+js.books[i].satifiyid+"' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>"
                    +"<div class='modal-dialog'><div class='modal-content'><div class='modal-header'>"
                    +"<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>×</button>"
                    +"<h4 class='modal-title' id='myModalLabel'>题干:"+js.books[i].sfhead+"&nbsp;&nbsp;&nbsp;类型:"+p+"</h4></div>"
                    +"<div class='modal-body' style='color: red;font-size: 20px;'>确认是否删除此用户信息</div>"
                    +"<div class='modal-footer'> <button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>"
                    +"<a href='delSatifiy.html?userid="+js.books[i].satifiyid+"'><button  class='btn btn-primary'>删除</button></a></div>	</div></div></div>";
                $("#t_s").after(n);
            }

        }
    });
})