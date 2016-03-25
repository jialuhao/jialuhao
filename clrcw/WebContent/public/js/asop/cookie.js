function GetCookieVal(offset)
{
var endstr = document.cookie.indexOf (";", offset);
if (endstr == -1)
endstr = document.cookie.length;
//return unescape(document.cookie.substring(offset, endstr));
return decodeURIComponent(document.cookie.substring(offset, endstr));
}

function GetCookie(name)
{
var arg = name + "=";
var alen = arg.length;
var clen = document.cookie.length;
var i = 0;
while (i < clen)
{
var j = i + alen;
if (document.cookie.substring(i, j) == arg)
return GetCookieVal (j);
i = document.cookie.indexOf(" ", i) + 1;
if (i == 0) break;
}
return null;
}

// path, /
function DelCookie(name,path)
{
document.cookie =  name + "="  + ";path=" + path +";expires=Thu, 01-Jan-70 00:00:01 GMT";
}

function SetCookie(name,value,path)
{
document.cookie =  name + "=" + encodeURIComponent(value)  + ";path=" + path;
}
