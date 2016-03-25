
		(
		 	function (){
				if(!window.ADS) window.ADS = {};
				function loading(func){
					if( typeof func != 'function' ) return false;
					if( window.attachEvent ) window.attachEvent( "onload" , func );
					else window.addEventListener( "load" , func ,false );
				}
				window['ADS']['loading'] = loading;
			}
		)();
		
		(function (){
			if( !window.ADS ) return false;
			
			function $(id) {
				if(!document.getElementById(id)) return false;
				else return document.getElementById(id);
			}		
			window['ADS']['$'] = $;
			
			function addEvent(type,node,fn){
				if(node.nodeType != 1 && node != document) return false;
				if(window.ActiveXObject){
					node['e' + type + fn] = fn;
					node[type + fn] = function (){
						node['e' + type + fn](window.event); 
						return false;
					}
					node.attachEvent('on' + type, node[type + fn]);
				}else{
					node.addEventListener(type, fn, false);
				}
			}
			window['ADS']['addEvent'] = addEvent;
			
			function removeEvent(type,node,fn){
				if(node.nodeType != 1 && node != document) return false;
				if(window.ActiveXObject){
					node.detachEvent("on" + type,node[type + fn]);
				}else if(node.removeEventListener){
					node.removeEventListener(type,fn,false);
				}
			}
			window['ADS']['removeEvent'] = removeEvent;
			
			function $$( tag , parent ){
				if(parent){
					if(parent.getElementsByTagName(tag)[0])
						return parent.getElementsByTagName(tag);
				}else if(document.getElementsByTagName(tag)[0])
					return document.getElementsByTagName(tag);
				else return false;
			}
			window['ADS']['$$'] = $$;
			
			function stopPropagation( e ){
				e = getEventObject(e);
				if(e.stopPropagetion){
					e.stopPropagetion();
				} else {
					e.cancelBubble = true;
				}
			}
			window['ADS']['stopPropagation'] = stopPropagation;
			
			function preventDefault( e ){
				if( e.preventDefault ){
					e.preventDefault();
				} else {
					return false;
				}
			}
			window['ADS']['preventDefault'] = preventDefault;
		})();