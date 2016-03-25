//contentType="text/javascript; charset=UTF-8"
//isInt() isFloat() checkNumber()
//ltrim() rtrim() trim()
//goPage() setPage(n)

//is integer? 
function isInt(numberStr) {
	var num = parseInt(numberStr);
	return !(isNaN(num));
}
//is float? 
function isFloat(numberStr) {
	var num = parseFloat(numberStr);
	return !(isNaN(num));
}
//isInRange
function isInRange(numberStr,min,max){
	if(isInt(numberStr)){
		var num = parseInt(numberStr);
		if(num >=min && num<=max){
			return true;
		}
	}
	return false;
}
//check string only contains number char
function checkNumber(s){
   var num = "1234567890";
	for(var i=0;i<s.length;i++){
		if(num.indexOf(s.charAt(i))==-1){			
			return false;
		}
	}
	return true;
}
//parse String yyyy-MM-dd to Date()
function parseDate(dateStr){
	var re = /\b\d\d\d\d-\d\d-\d\d\b/;
	if(dateStr != null && dateStr.match(re)!=null){
		var result = new Date();
		var dateInfos = dateStr.split("-");
		result.setTime(0);
		result.setYear(parseInt(dateInfos[0],10));
		result.setMonth(parseInt(dateInfos[1],10)-1);
		result.setDate(parseInt(dateInfos[2],10));
		return result;
	}else{
		return null;
	}
}
//left trim string
function ltrim(s){
	if(s==null) return null;
	
	var i=0;
	while( i < s.length && s.charAt(i) == ' '){
	  i++;
	}
	if(i<=s.length){
	  s = s.substring(i,s.length);
	}
	return s;
}
//right trim string 
function rtrim(s){
	if(s==null) return null;
	
    var i=s.length - 1;
	while( i>=0 && s.charAt(i) == ' '){
	  i--;
	}
	if(i < 0){
	   s= "";
	}else{
	  s = s.substring(0,i+1);
	}
	return s;
}
//trim string
function trim(s){
   return ltrim(rtrim(s));
}
//select all
function selectAll(checkName,checkStatus){
	var checks = document.getElementsByName(checkName);
	if(checks!=null) {
		for(var i=0;i<checks.length;i++) {
			checks[i].checked=checkStatus;
		}
	}
}
//select count
function selectCount(checkName) {
	var checks = document.getElementsByName(checkName);
	var count=0;
	if(checks!=null) {
		for(var i=0;i<checks.length;i++) {
			if(checks[i].checked==true){
				count++;
			}
		}
	}
	return count;
}
function clearFields(form){
	if(form){
		var elements = form.getElementsByTagName("INPUT");
		for(var i = 0;i<elements.length;i++){
			var element = elements[i];
			if(element.type=="text")
				element.value="";
		}
	}
}