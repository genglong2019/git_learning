$(document).ready(function(){
    var cname="";
    var gid=window.localStorage.getItem('gid');
    var imgss="";

    var id=window.localStorage.getItem('id');

    $.ajax({
        type:"get",
        url:"http://localhost:8082/manager/"+id+"/selByid",
        async:true,
        success:function(data){
            var js = JSON.parse(data);
                cname=js.users.chiname;
                imgss=js.users.uimgs;

            var m="<div>参考班级：研发"+gid+"</div>";
            var n="<div>参考人姓名:"+cname+"</div>";
            $("#gidm").after(m);
            $("#chinamem").after(n);
            var imgsss="<div ><img src='img/"+imgss+"' width='50px' height='50px' /></div>";
            $("#imgs").after(imgsss);
            var chiname="<div>"+cname+"</div>";
            $("#username").after(chiname);

        }
    });




})