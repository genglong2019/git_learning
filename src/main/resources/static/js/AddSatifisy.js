$(document).ready(function(){
    $("#addSf_form").submit(function(){
        var sfhead = $("#sfhead").val();

        var sftype="";
        var obj=document.getElementsByName("sftype");
        for(var i=0;i<obj.length; i++){
            if(obj[i].checked){
                sftype=obj[i].value;
            }
        }


        var satifies = {
            "sfhead": sfhead,
            "sftype": sftype,

        };
        $.ajax({
            type:"get",
            url:"http://localhost:8082/exams/addSfInfo",
            async:true,
            data:satifies,
            success:function () {

                    window.location.href="http://localhost:8082/satifisies.html";


            }

        });
        return false;

    });





})