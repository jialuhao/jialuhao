// JavaScript Document

/* Í¼Æ¬ÂÖ»» */
window.onload = function(){
	voluntaryRotate();
}
var allBox,nowBoxNum=0,nextBoxNum=1,scrolling,alphaBoxNum,alphaNum=100,boxAmount,scrollState=true;
function rotateimg(tagFlag){
	if(!scrollState){return;}
	scrollState = false;
	for(var a=0;a<boxAmount;a++){
		if(a==nowBoxNum){allBox[a].style.zIndex=14;}
		else if(a==tagFlag){allBox[a].style.zIndex=13;}
		else{allBox[a].style.zIndex=11;}
	}
	var alpha = window.setInterval(function(){
		alphaNum = alphaNum-10;
		//alphaStyle(allBox[nowBoxNum],alphaNum);
		if(alphaNum<=0){
			alphaNum = 100;
			window.clearInterval(alpha);
		}
	},40);
	for(var i=0;i<boxAmount;i++){document.getElementById("imgtag"+i).className = "";}
	document.getElementById("imgtag"+tagFlag).className = "scrolltagon";
	//window.setTimeout(function(){						   
		allBox[nowBoxNum].style.cssText = null;
		for(var i=0;i<boxAmount;i++){allBox[i].style.zIndex=11;}
		allBox[tagFlag].style.zIndex = 14;
		nowBoxNum = tagFlag;
		nextBoxNum = nowBoxNum+1;
		if(nextBoxNum==boxAmount){nextBoxNum=0;}
		scrollState = true;
		window.clearInterval(alpha);
	//},700);
}
function changeImg(boxNum){
	rotateimg(boxNum);
	window.clearInterval(scrolling);
	voluntaryRotate();
}
function voluntaryRotate(){
	allBox = document.getElementById("scrollimg").getElementsByTagName("dl");
	boxAmount = allBox.length;
	allBox[nowBoxNum].style.zIndex = 14;
	scrolling=setInterval(function(){rotateimg(nextBoxNum)},5000);
}

function alphaStyle(element,alphaSetNum){
	if(!element){return;}
	var browser = {};
	var ua = navigator.userAgent.toLowerCase();
	var s;
	(s = ua.match(/msie ([\d.]+)/)) ? browser.ie = s[1] :
	(s = ua.match(/firefox\/([\d.]+)/)) ? browser.firefox = s[1] :
	(s = ua.match(/chrome\/([\d.]+)/)) ? browser.chrome = s[1] :
	(s = ua.match(/opera.([\d.]+)/)) ? browser.opera = s[1] :
	(s = ua.match(/version\/([\d.]+).*safari/)) ? browser.safari = s[1] : 0;
	if(browser.ie){element.style.filter = "Alpha(Opacity="+alphaSetNum+")";}
	else{
		var floatNum = alphaSetNum/100;
		element.style.opacity = floatNum;
	}
}
function otherControl(value){
	var nextBoxNum = value?nowBoxNum+1:nowBoxNum-1;
	if(nextBoxNum<0){nextBoxNum=3;}
	if(nextBoxNum>3){nextBoxNum=0;}
	changeImg(nextBoxNum);
}