/*判断是否是正整数*/
function isPlusInteger(str){
  return (new RegExp(/^[0-9]*[1-9][0-9]*$/)).test(str);
}

/*判断是邮件是否合法*/
function isMail(mail){
  return (new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)).test(mail);
}

/*判断是否是钱数*/
function isMoney(str){
  return (new RegExp(/^\d{1,10}$|\.\d{1,6}$/).test(str));
	//return (new RegExp(/\d+\.?\d{2}/).test(str));
}

/*判断是否是浮点数*/
function isFloat(str){
	return (new RegExp(/^\d{1,10}$|\.\d{1,6}$/).test(str));
}

/*判断是否是数字*/
 function isNumber(str){
    var digits = "0123456789";
    var i = 0;
    var sLength = str.length;
    while (i < sLength){
      var c = str.charAt(i);
      if (digits.indexOf(c) == -1) return false;
      i++;
    }
    return true;
}

/*去左空格*/
function ltrim(s){
 return s.replace( /^\s*/, "");
}

/*去右空格*/
function rtrim(s){
 return s.replace( /\s*$/, "");
}

/*去左右空格*/
function trim(s){
 return rtrim(ltrim(s));
}

/*是否为空值*/
function isEmpty(s){
 var tmp_str = trim(s);
 return tmp_str.length == 0;
}

/*是否是电话号码*/
function isPhone(phoneNum){
	return (new RegExp(/^((\(\d{3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,10}(-\d{0,4})?$/)).test(phoneNum);
}

/*是否是手机号码*/
function isMobile(mobileNum){
	return (new RegExp(/^((\(\d{3}\))|(\d{3}\-))?(13\d{9}|15\d{9})$/)).test(mobileNum);
}

/*是否是合法的url*/
function isURL(u){
	//var partn = /(^https:\/\/)|(^http:\/\/)|[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
	var partn = /((^http:\/\/)|(^https:\/\/))+(([A-Za-z0-9]+\.)*)+(([\.\/\?=%\-&_~`@\[\]\':+!]|[A-Za-z0-9])*)$/;
	return partn.test(u);
       // var temp=new RegExp("((^http:\/\/)|(^https:\/\/)|(^\.\.\/))(\\w)+\.(\\w)+");
        //return temp.test(u);
}

/*是否是合法的邮政编码*/
function isZipCode(zipCode){
	return (new RegExp(/^[1-9]\d{5}$/)).test(zipCode);
}

/*是否是中文*/
function isChinese(chinese){
	return (new RegExp(/^[\u0391-\uFFE5]+$/)).test(chinese);
}

/*是否是英文*/
function isEnglish(english){
	return (new RegExp(/^[A-Za-z]+$/)).test(english);
}

function isDate(str) {
	var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
	if(r==null)return false;
	var d= new Date(r[1], r[3]-1, r[4]);

	return (r[1].length==4 && d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]);
}

function Str2Date(str){
	if(str==null || str==""){
		return null;
	}
	var strarray = str.split("-");
	date = new Date();
	date.setYear(strarray[0]);
	date.setMonth(strarray[1]-1);
	date.setDate(strarray[2]);
	return date;
}

function Date2Str(date){
  if(date==null){
  	return "";
  }
	var str = "";
	str+=date.getYear();
	str+="-";
	month = date.getMonth()+1;
	strMonth = month.toString();
	if(strMonth.length<2){
		strMonth = "0"+strMonth;
	}
	str+=(strMonth);
	str+="-";
	day = date.getDate();
	strDay = day.toString();
	if(strDay.length<2){
	  strDay = "0"+strDay
	}

	str+=strDay;
	return str;
}
function tooLong(s,max){
    var i = 0;
    var sLength = s.length;
    while (i < sLength){
      var c = s.charAt(i);
      //alert(c);
      if (sLength>max) return true;
      i++;
    }
    return false;
  }

function isIncludeQuotes(s){
	 var digits = "\"“”";
         var i = 0;
         while(i<s.length){
         	var c = s.charAt(i);
                if(digits.indexOf(c)>=0) return true;
         }
         return false;
}

/*登录名是否合法*/
function isfalseLoginName(name){
	if(isEmpty(name.value)||isRightString(name.value)){
  	alert("请输入正确的登录名！登录名只能由20位英文字母(a-z)或(A-Z), 数字(0-9)和下划线(_)组成，第一个字符必须是字母或者数字！");
    return true;
  }else return false;
}

function isRightString(s){
var patrn=/^[a-zA-Z0-9]{1}([a-zA-Z0-9]|[_]){0,19}$/;
if (!patrn.test(s)) return true;
return false;
}

/*对于只能输入字母、数字、下划线的限制*/
function isfalseString(name){
	if(isEmpty(name.value)||tooLong(name.value,25)||isRightString(name.value)){
    return true;
  }else return false;
}
/*ID是否合法,英文字母(a-z)或(A-Z), 数字(0-9)和下划线(_)组成，第一个字符必须是字母或者数字*/
function isID(name,s,n){
	if(isEmpty(name.value)||tooLong(name.value,n)||isRightString(name.value)){
  	alert(s);
    return true;
  }else return false;
}

/*密码是否合法*/
function isfalsePwd(pwd){
	if(isEmpty(pwd.value)||pwd.value.length<4||tooLong(pwd.value,20)){
  	alert("请输入正确的密码！密码长度为4-20位！");
    return true;
  }else return false;
}

/*名称是否合法*/
function isfalseName(name,s){
  	var patrn = /^[\u4e00-\u9fa5a-zA-Z0-9_]+$/;
	if(isEmpty(name.value)||tooLong(name.value,25)||!patrn.test(name.value)){
  	alert(s);
    return true;
  }else return false;
}



function isfalseCalendarTitle(name,s){
  	var patrn = /^[\u4e00-\u9fa5a-zA-Z0-9]|[_]+$/;
	if(isEmpty(name.value)||tooLong(name.value,250)||!patrn.test(name.value)){
  	alert(s);
    return true;
  }else return false;
}




/*标题名称是否合法*/
function isFalseTitle(name,s){
	if(isEmpty(name.value)||tooLong(name.value,100)||trim(name.value).length==0)
	{
          alert(s);
          return true;
     }else return false;
}

/*url是否合法(不查空)*/
function isfalseUrl(name,s){
  if(!isEmpty(name.value)){
	 if(!isURL(name.value)||tooLong(name.value,50)){
  		alert(s);
    	return true;
  	}else return false;
  }else return false;
}
/*url是否合法(查空)*/
function isfalseURL(name,s){
	if(isEmpty(name.value)||!isURL(name.value)||tooLong(name.value,100)){
  	alert(s);
    return true;
  }else return false;
}
/*排序号是否合法*/
function isfalseIndex(index,s){
	if(isEmpty(index.value)||!isNumber(index.value)||tooLong(index.value,4)||index.value<0){
  	alert(s);
    return true;
  }else return false;
}
/*是否是数字,长度为3(单位编码)*/
function is3Number(input,s){
  var sLength = input.value.length;
	if(isEmpty(input.value)||!isNumber(input.value)|| sLength!=3){
  	alert(s);
    return true;
  }else return false;
}
/*屏蔽右键*/
//document.attachEvent("oncontextmenu",new Function("return false"));

/* 查询条件是否包含特殊字符*/
function isSpecialCharacter(){
   var isSCh= /^[^ \s~!@#$%\^\&\*\(\)_\+|\-\=\/\?:;'"\[\{\]\}`\.>,<\\]+$/;
   var length = arguments.length;
   for(i=0;i<length;i++){
   if(arguments[i].value.length > 0 && !isSCh.test(arguments[i].value)){
     	alert("查询条件不能包括特殊字符!");
        return true;
//	  return arguments[i];
   	}else if(arguments[i].value.length > 500){
   		alert("查询条件长度不能大于500!");
        return true;
   	}
   }
}

/*查询字符串是否包含特殊字符,包含返回True不包含返回False*/
function hasSpecialCharacter(String){
   var isSCh= /^[^~!@#$%\^\&\*\(\)_\+|\-\=\/\?:;'"\[\{\]\}`\.>,<\\]+$/;
   if(String==""){
   	 return false;
   }else{
     if(!isSCh.test(String)){
   	   return true;
     }else{
   	   return false;
     }
   }
}
