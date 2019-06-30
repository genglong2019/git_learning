$(document).ready(function(){

var canvas,ctx;
var clockImage;
var clockRadius=100;

$(function(){
 canvas=document.getElementById("canvas");
 ctx=canvas.getContext("2d");
 clockImage=new Image();
 clockImage.src="img/time2.jpg";
 setInterval(drawClock,1000);
});
function drawClock(){
 ctx.clearRect(0,0,ctx.canvas.width,ctx.canvas.height);
 var date=new Date();
 var hours=date.getHours();
 var minutes=date.getMinutes();
 var seconds=date.getSeconds();
 hours=hours>12?hours-12:hours;
 var hour=hours+minutes/60;
 var minute=minutes+seconds/60;
 
 ctx.save(); 
 ctx.drawImage(clockImage,0,0,200,200);
 ctx.translate(canvas.width/2,canvas.height/2);
 ctx.beginPath();
 ctx.font="20px Arial";
 ctx.fillStyle="#000";
 ctx.textAlign="center";
 ctx.textBaseline="middle";
 for(var n=1;n<=12;n++){
  var theta=(n-3)*2*Math.PI/12;
  var x=clockRadius*0.7*Math.cos(theta);
  var y=clockRadius*0.7*Math.sin(theta);
  ctx.closePath();
  ctx.fillText(n,x,y);
  }
 
 
 ctx.save();
 var theta=(hour-3)*2*Math.PI/12;
 ctx.rotate(theta);
 ctx.beginPath();
 ctx.moveTo(-15,-5);
 ctx.lineTo(-15,5);
 ctx.lineTo(clockRadius*0.5,1);
 ctx.lineTo(clockRadius*0.5,-1);
 ctx.closePath();
 ctx.fill();
 ctx.restore();
 
 ctx.save();
 var theta=(minute-15)*2*Math.PI/60;
 ctx.rotate(theta);
 ctx.beginPath();
 ctx.moveTo(-15,-4);
 ctx.lineTo(-15,4);
 ctx.lineTo(clockRadius*0.7,1);
 ctx.lineTo(clockRadius*0.7,-1);
 ctx.closePath();
 ctx.fill();
 ctx.restore();
 
 ctx.save();
 var theta=(seconds-15)*2*Math.PI/60;
 ctx.rotate(theta);
 ctx.beginPath();
 ctx.moveTo(-15,-3);
 ctx.lineTo(-15,3);
 ctx.lineTo(clockRadius*0.9,1);
 ctx.lineTo(clockRadius*0.9,-1);
 ctx.fillStyle="#f00";
 ctx.closePath();
 ctx.fill();
 ctx.restore();
 
 ctx.restore();
}
})