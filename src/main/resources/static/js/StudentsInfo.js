$(document).ready(function(){

  	$.ajax({
			type:"get",
			url:"http://localhost:8082/manager/showUsers",
			async:true,
			success:function(data){
				js = JSON.parse(data);
				             

			             	
				
				if("" != js){
					for(var i=0;i<js.books.length;i++){
			                       var m= "<div class='new_prod_box' ><a href='details.html?id="+js.books[i].id
			                 +"'>"+js.books[i].uname
			                        +"</a>  <div class='new_prod_bg'> <a href='details.html?id="+js.books[i].id
			                        +"'><img src="+'img/'+js.books[i].uimgs
			                      	+ " height='90px' width='60px'/></a> </div></div>";
			                      		 $("#new_products").append(m);
						}
				}
			},
			error:function(data){
				console.log("出错了");
			}
	});


})