$(document).ready(function() {
			$.ajax({
				type: "get",
				url: "http://localhost:8082/exams/createExame",
				async: true,
				success: function(data) {
					if(data != "{}") {
						var js = JSON.parse(data);
						for(var i = 0; i < js.doexame.length; i++) {
							var n = i + 1;
							var m = "<div>" + n + ". " + js.doexame[i].test + "<br /><br />A:" + js.doexame[i].listop[0].fouroption + "<br /><br />B:" + js.doexame[i].listop[1].fouroption + "<br /><br />C:" + js.doexame[i].listop[2].fouroption +
								"<br /><br />D:" + js.doexame[i].listop[3].fouroption + "<br /><br />" +
								"<ol>A&nbsp;&nbsp;<input type='radio' name='Q" + n + "' value='" + js.doexame[i].listop[0].judge + "'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; B&nbsp;&nbsp;" +
								"<input type='radio' name='Q" + n + "' value='" + js.doexame[i].listop[1].judge + "'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; C&nbsp;&nbsp;" +
								"<input type='radio' name='Q" + n + "' value='" + js.doexame[i].listop[2].judge + "'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; D&nbsp;&nbsp;" +
								"<input type='radio' name='Q" + n + "' value='" + js.doexame[i].listop[3].judge + "'></ol></div>";
								$("#examing").before(m);
						}
					}
				}
			});
    alertSet('考试倒计时');

    var f="";
    var state ="";
    function alertSet(e) {
        document.getElementById("js-alert-box").style.display = "block",
            document.getElementById("js-alert-head").innerHTML = e;
        var t = 300,
            n = document.getElementById("js-sec-circle");
        document.getElementById("js-sec-text").innerHTML = t,
            setInterval(function() {
                    if(0 == t) {
                        location.href = "#"; //#时间到后跳转地址
                    } else {
                        t -= 1,
                            document.getElementById("js-sec-text").innerHTML = t;
                        var e = Math.round(t / 10 * 735);
                        n.style.strokeDashoffset = e - 735
                    }
                },
                970);
    }
})