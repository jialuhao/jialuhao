function checkform(frm){
	if(trim(frm.password.value)==""){
		alert("请输入密码;");
		frm.password.focus();
		return false;
	}
	if(trim(frm.newPassword.value)==""){
		alert("请输入新密码;");
		frm.newPassword.focus();
		return false;
	}
	if(trim(frm.newPassword.value)!=trim(frm.newPassword2.value)){
		alert("新密码不一致，请确认;");
		frm.newPassword.focus();
		return false;
	}
	if(trim(frm.newPassword.value).length<6){
		alert("密码长度不能小于6;");
		frm.newPassword.focus();
		return false;
	}
	return true;
}
