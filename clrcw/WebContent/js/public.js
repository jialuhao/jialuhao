// JavaScript Document

/* 输入框控制 */
window.onload=function() {
	offsetInput()
}
var allInputText=new Array
var allInputTextValue=new Array;
function offsetInput(){
	var allInput=document.getElementsByTagName("input");
	var inputNumber=0;
	for(var i=0;i<allInput.length;i++){
		if(allInput[i].getAttribute("type")=="text"||allInput[i].getAttribute("type")=="password"){
			allInputText[inputNumber]=allInput[i];
			allInputTextValue[inputNumber]=allInput[i].getAttribute("value");
			inputNumber++;
		}
	}
}
function clearInput(inputFlag){
	var thisInputValue;
	for(var i=0;i<allInputText.length;i++){
		if(allInputText[i]==inputFlag){
			thisInputValue=allInputTextValue[i];
		}
	}
	if(inputFlag.getAttribute("value")==thisInputValue){
		inputFlag.setAttribute("value","");
	}
}
function returnInput(inputFlag){
	var thisInputValue;
	for(var i=0;i<allInputText.length;i++){
		if(allInputText[i]==inputFlag){
			thisInputValue=allInputTextValue[i];
		}
	}
	if(inputFlag.getAttribute("value")==null||inputFlag.getAttribute("value")==""){
		inputFlag.setAttribute("value",thisInputValue);
	}
}
function openTag(mainBoxId,mainBoxClass){
	if(mainBoxId&&mainBoxClass&&document.getElementById(mainBoxId)){document.getElementById(mainBoxId).className = mainBoxClass;}
}
