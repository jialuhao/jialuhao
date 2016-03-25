
function CreateXMLDoc(xmlFilePath)
{
	if(window.ActiveXObject) 
	{ 
		
		var msXMLdom = new ActiveXObject('MSXML.DOMDocument'); 
		msXMLdom.async = false; 
		msXMLdom.load(xmlFilePath); 
		
		return msXMLdom;
	}
	else
	{
		var oXmlHttp = new XMLHttpRequest() ;
		oXmlHttp.open( "GET", xmlFilePath, false ) ;
		oXmlHttp.send(null) ;
		
		return oXmlHttp.responseXML;
	
	} 
}



function BuilderTree(nodeName,level)
{
	
	var indent=10;
	var temp="";
	level=level==null ? 0 : level;
	var nodes=nodeName.childNodes;
	for(var i=0;i<nodes.length;i++)
	{
		if(nodes[i].nodeType==1){		
		if(nodes[i].childNodes.length<1)
		{
	
		temp+="<div style='margin-left:"+level*indent+"px;cursor:hand;''>";
		temp+="<img src='../../images/list_icon.gif'/> ";
		var target=nodes[i].getAttribute("target")==null ? "" : "target='"+nodes[i].getAttribute("target")+"'";
		temp+="<a href='"+nodes[i].getAttribute("url")+"' "+target+">"+nodes[i].getAttribute("name")+"</a>";
		temp+="</div>";
		continue;
		}
		
		temp+="<div style='margin-left:"+level*indent+"px;cursor:hand;' onclick='show(this)'>";
		temp+="<img src='../../images/filebox.gif'/> <b>"+nodes[i].getAttribute("name")+"</b>";
		temp+="</div>";
		
		temp+="<div style='margin-left:"+indent+"px;cursor:hand;display:none'>";
		temp+=BuilderTree(nodes[i],level+1);
		temp+="</div>";
		}
	}
	return temp;
}


function show(obj)
{
	
	var nextNode=obj.nextSibling;
	
	var subNode=obj.firstChild;
	
	if(nextNode.nodeType==1)
	{
		with(eval(nextNode))
		{
			 if(style.display=="")
			 {
			  style.display="none";
			  //subNode.nodeValue="+";
			  
			 }else
			 {
			  style.display="";
			  //subNode.nodeValue="-";
			 }
		}
	}
}