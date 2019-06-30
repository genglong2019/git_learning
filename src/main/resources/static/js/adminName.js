$(document).ready(function(){
var n=getCookie('user');
var m='<span class="hidden-sm hidden-xs">'+n+'</span>';
$("#names").after(m);



    function getCookie(name){
        var reg = RegExp(name+'=([^;]+)');
        var arr = document.cookie.match(reg);
        if(arr){
            return arr[1];
        }else{
            return '';
        }
    };

})