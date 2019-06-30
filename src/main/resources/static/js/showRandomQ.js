$(document).ready(function() {

	$.ajax({
		type: "get",
		url: "http://localhost:8082/exams/showMyRandonQ",
		async: false,
		success: function(data) {
			if(data != "{}") {
				var js = JSON.parse(data);
				for(var i = 0; i < js.doexame.length; i++) {
					var imges0 = "";
					var imges1 = "";
					var imges2 = "";
					var imges3 = "";

					if(js.doexame[i].listop[0].judge == "1") {
						imges0 = "y";
					} else {
						imges0 = "n";
					}
					if(js.doexame[i].listop[1].judge == "1") {
						imges1 = "y";
					} else {
						imges1 = "n";
					}
					if(js.doexame[i].listop[2].judge == "1") {
						imges2 = "y";
					} else {
						imges2 = "n";
					}
					if(js.doexame[i].listop[3].judge == "1") {
						imges3 = "y";
					} else {
						imges3 = "n";
					}
					var n = i + 1;

					var m = "<div class='panel panel-default'><div class='panel-heading'>" +
						"<a class='panel-title collapsed' data-toggle='collapse' data-parent='#panel-635452' href='#panel-element-"+js.doexame[i].testid+"'>" + n + ". " + js.doexame[i].test + "</a>" +
						"</div><div id='panel-element-" + js.doexame[i].testid + "' class='panel-collapse collapse'><div class='panel-body'>" +
						"A:" + js.doexame[i].listop[0].fouroption + "&nbsp;&nbsp; <img src='img/" + imges0 + ".png'/><br /><br />" +
						"B:" + js.doexame[i].listop[1].fouroption + "&nbsp;&nbsp; <img src='img/" + imges1 + ".png'/><br /><br />" +
						"C:" + js.doexame[i].listop[2].fouroption + "&nbsp;&nbsp; <img src='img/" + imges2 + ".png'/><br /><br />" +
						"D:" + js.doexame[i].listop[3].fouroption + "&nbsp;&nbsp; <img src='img/" + imges3 + ".png'/><br /><br /></div></div></div>";

					$("#showquesitonss").before(m);
				}

			}
		}

	});

})