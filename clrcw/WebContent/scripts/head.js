// JavaScript Document
if(window.attachEvent){
window.attachEvent("onload",ss);
}else{
window.addEventListener('load',ss,false);
}
function ss(){
	var aa = document.getElementById('aa'),
		b = document.body;
	aa.onclick=function(e){
		e = e || window.event;
		if(aa.title=="开启辅助工具条"){
			aa.firstChild.nodeValue="关闭辅助工具条";
			aa.title = "关闭辅助工具条";
			toolbar.Function.show.mainMethod();	
			document.body.className = 'wlBj_on';
		}else{
			aa.firstChild.nodeValue="开启辅助工具条";
			aa.title = "开启辅助工具条";
			toolbar.Function.show.mainMethod();
			document.body.className = 'wlBj_off';
		}
		ADS.preventDefault(e);
	}
}


