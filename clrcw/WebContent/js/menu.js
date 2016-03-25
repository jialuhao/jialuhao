var boxState;
function subScriptRun(){  
    if(openListNum!=""){leftListControl(openListNum);}	
}
function leftListControl(boxFlag){
    for(var i=1;i<5;i++){
		document.getElementById("leftlist"+i).className = "";
		document.getElementById("lefttitle"+i).className = "";
	}
    if(boxState!=boxFlag){
        document.getElementById("leftlist"+boxFlag).className = "leftlistopen";
		document.getElementById("lefttitle"+boxFlag).className = "lefttitleopen";
        boxState=boxFlag;
    }else{
        document.getElementById("leftlist"+boxFlag).className = "";
		document.getElementById("lefttitle"+boxFlag).className = "";
        boxState=0;
    }
}
window.onload = function(){
    try{subScriptRun()}catch(e){}
}