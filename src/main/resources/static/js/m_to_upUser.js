$(document).ready(function() {
    $("#register_form").submit(function () {
        var gid=$("#gid").val();
        var email = $("#email").val();
        var ids = $("#id").val();
        var state;
        var obj = document.getElementsByName("usestate");
        for (var i = 0; i < obj.length; i++) {
            if (obj[i].checked) {
                state = obj[i].value;
            }
        }


        var userinfo = {
           "gid":gid,
            "email": email,
            "usestate": state,
            "id": ids,
        };
        $.ajax({
            type: "get",
            url: "http://localhost:8082/manager/updateUserInfo",
            async: false,
            data: userinfo,
            success: function () {
                window.location.href = "updateStudent.html";
            }
        });
        return false;
    })
})