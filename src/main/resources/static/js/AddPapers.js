$(document).ready(function(){
    $("#addPapers_form").submit(function(){
        var test = $("#test").val();
        var firstopt  = $("#firstopt").val();
        var secondopt  = $("#secondopt").val();
        var thirdopt=$("#thirdopt").val();
        var fourthopt=$("#fourthopt").val();
        var whichright=$("#whichright").val();
        var testfrom=$("#testfrom").val();
        var testtype="";
        var obj=document.getElementsByName("testtype");
        for(var i=0;i<obj.length; i++){
            if(obj[i].checked){
                testtype=obj[i].value;
            }
        }


        var addquestions = {
            "test": test,
            "firstopt": firstopt,
            "secondopt":secondopt,
            "thirdopt":thirdopt,
            "whichright": whichright,
            "testfrom": testfrom,
            "fourthopt":fourthopt,
            "testtype":testtype,
        };
        $.ajax({
            type:"get",
            url:"http://localhost:8082/exams/addPaperInfo",
            async:true,
            data:addquestions,
            success:function () {

                    window.location.href="http://localhost:8082/updateTest.html";


            }

        });
        return false;

    });





})