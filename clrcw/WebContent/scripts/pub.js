		(function (){
		
			var _this;
			function showImg(){
				_this = this;
				this.div = ADS.$('showImg_1');
				this.arrA = ADS.$$('a', this.div);
				this.img = ADS.$$('img', this.div)[0];
				this.p = ADS.$$('p', this.div)[0];
				this.li = ADS.$$('li', this.div)[0];
				this.addEvent();
				this.setTimes();
			}
			showImg.prototype = {
				j : 0,
				addEvent : function (){
					for(var i=0; i<this.arrA.length; i++){
						ADS.addEvent('click', this.arrA[i], this.show);
						ADS.addEvent('focus', this.arrA[i], this.show);
					}
				},
				show : function (){
					this.id ? clearTimeout(this.id) : '';
					var src = this.getAttribute('rel'),
						con = this.getAttribute('con');
					_this.append(this, src, con);
				},
				setTimes : function (){
					this.id ? clearTimeout(this.id) : '';
					var src = this.arrA[this.j].getAttribute('rel'),
						con = this.arrA[this.j].getAttribute('con');
					this.append(this.arrA[this.j++], src, con);
					this.id = setTimeout((function (t){
						return function (){
							t.setTimes();
						}
					})(this), 2000);
				},
				append : function (a, src, con){
					if(this.j > 3) this.j = 0;
					_this.li.className = '';
					_this.img.setAttribute('src', src);
					a.setAttribute('title', con);
					a.parentNode.className = 'color';
					_this.p.innerHTML = '<span></span>' + '<em>' + con + '</em>';
					a.className = 'color';
					_this.li = a.parentNode;	
				}
			}
			window['ADS']['showImg'] = showImg;
			
		})();
		
		ADS.loading(function (){
			new ADS.showImg();					  
		});
		
		
		
		
		ADS.loading(function (){
			var obj;
			obj = ADS.$('o1');
			var a1 = ADS.$('a1');
			var a2 = ADS.$('a2');
			ADS.addEvent('mouseover', a1, t);
			ADS.addEvent('focus', a1, t);
			ADS.addEvent('focus', a2, t);
			ADS.addEvent('mouseover', a2, t);
			function t(){
				obj.className = '';
				this.parentNode.className = 'block';
				obj = this.parentNode;
			}
		});
		
		ADS.loading(function (){
			var obj;
			obj = ADS.$('i1');
			var a1 = ADS.$('i11');
			var a2 = ADS.$('i12');
			ADS.addEvent('mouseover', a1, t);
			ADS.addEvent('focus', a1, t);
			ADS.addEvent('focus', a2, t);
			ADS.addEvent('mouseover', a2, t);
			function t(){
				obj.className = '';
				this.parentNode.className = 'block';
				obj = this.parentNode;
			}
		});
		
		ADS.loading(function (){
			var obj;
			obj = ADS.$('o2');
			var a1 = ADS.$('a3');
			var a2 = ADS.$('a4');
			ADS.addEvent('mouseover', a1, t);
			ADS.addEvent('focus', a1, t);
			ADS.addEvent('focus', a2, t);
			ADS.addEvent('mouseover', a2, t);
			function t(){
				obj.className = '';
				this.parentNode.className = 'block';
				obj = this.parentNode;
			}
		});
		
		ADS.loading(function (){
			var obj;
			obj = ADS.$('o3');
			var a1 = ADS.$('a5');
			var a2 = ADS.$('a6');
			ADS.addEvent('mouseover', a1, function (){
				obj.className = '';
				this.parentNode.className = 'block';
				obj = this.parentNode;
			});
			ADS.addEvent('mouseover', a2, function (){
				obj.className = '';
				this.parentNode.className = 'block';
				obj = this.parentNode;
			});
		});
		ADS.loading(function (){
			var obj;
			obj = ADS.$('c1');
			var a1 = ADS.$('c11');
			var a2 = ADS.$('c12');
			var a3 = ADS.$('c13');
			ADS.addEvent('mouseover', a1, t1);
			ADS.addEvent('mouseover', a2, t1);
			ADS.addEvent('mouseover', a3, t1);
			ADS.addEvent('focus', a1, t1);
			ADS.addEvent('focus', a2, t1);
			ADS.addEvent('focus', a3, t1);
			function t1(){
				obj.className = '';
				this.parentNode.className = 'display';
				obj = this.parentNode;
			}
		});
		
		ADS.loading(function (){
		
			var input = ADS.$('dtfw_search_text'),
				val = input.value;
			ADS.addEvent('focus', input, func);
			ADS.addEvent('blur', input, func);
			
			function func(e){
				e = e || window.event;
				e.type == 'focus' ? this.value = '' : this.value = val;
			}
		
		});