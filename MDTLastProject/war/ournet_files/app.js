
 function init() {


	var q = new createjs.LoadQueue(true);
	q.loadManifest(
		[
			'/ict/view/images/ground.jpg',
			'/ict/view/images/bg.png',
			'/ict/view/images/bg_black.png',
			'/ict/view/images/light.png',
			'/ict/view/images/ring.png'
		]
	);

	q.addEventListener('complete', function(e){
		$("body").animate({ "opacity": 1 }, 400);

		var m = new Main();
		 m.init();

		changeIcon()
		IconTxtCay()

		// ldDisp("/ict/view/gadget/user.html" , loadLoginComp);
		loadUserComp()


	})



	// 開始！
	function first(){
		$("#menu").css("visibility","visible");
		$("#crossMenu").css("visibility","visible")
		$("#listmenu").css("visibility","visible")
		$("#etcMenu").css("visibility","visible")
		$("#footR").css("visibility","visible")
		$("#headR").css("visibility","visible")
		ges()
	}


	var menuNames=["My Navigator","Calendar","Document","Conference","Medicare note"];

	// 現パネルID
 	var _cID = 0;

 	function getCID(){
 		return _cID;
 	}


 	function setCID( _c ){
 		_cID =_c;
 		// id変更時に切り替える
 		switch(_cID){
			case 0: 	changeIcon();

						crossList[0].on()
						crossList[1].on()
						crossList[2].on()
						crossList[3].on()
						break;
			case 1: 	// console.log("_0")
						changeHomeIcon(0,2)
						crossList[0].on()
//						console.log("_1")
						changeHomeIcon(1,0)
						crossList[1].on()
//						console.log("_2")
						changeHomeIcon(2,3)
						crossList[2].on()
//						console.log("_3")
						changeHomeIcon(3,4)
						crossList[3].on()
						break;
			case 2: 	// console.log("_0")
						changeHomeIcon(0,1)
						crossList[0].on()
//						console.log("_1")
						changeHomeIcon(1,2)
						crossList[1].on()
//						console.log("_2")
						changeHomeIcon(2,0)
						crossList[2].on()
//						console.log("_3")
						changeHomeIcon(3,3)
						crossList[3].on()
						break;
			case 3: 	// console.log("_0")
						changeHomeIcon(0,0)
						crossList[0].on()
//						console.log("_1")
						changeHomeIcon(1,1)
						crossList[1].on()
//						console.log("_2")
						changeHomeIcon(2,3)
						crossList[2].on()
//						console.log("_3")
						changeHomeIcon(3,4)
						crossList[3].on()
						break;
			case 4: 	// console.log("_0")
						changeHomeIcon(0,1)
						crossList[0].on()
//						console.log("_1")
						changeHomeIcon(1,2)
						crossList[1].on()
//						console.log("_2")
						changeHomeIcon(2,4)
						crossList[2].on()
//						console.log("_4")
						changeHomeIcon(3,0)
						crossList[3].on()
						break;
 		}
 	}


 	function changeIcon(){
		for (var i = 0; i < 5; i++) {
			var fl="/ict/view/images/ic_"+(i+1)+".png"
			var o= $("#crossMenu div")[i]
			$(o).css('background-image', "url('"+fl+"')")
		}

		var ls= $("#crossMenu span");
		for (var i = 0; i < 4; i++) {
			$(ls[i]).text(menuNames[i+1])
		};
 	}

 	function changeHomeIcon(n,m){
 		var fl="/ict/view/images/ic_"+m+".png"
		var o= $("#crossMenu div")[n]
		$(o).css('background-image', "url('"+fl+"')")
		var ls= $("#crossMenu span");
		$(ls[n]).text(menuNames[m])
 	}


	function IconTxtCay(){
		var ls= $("#crossMenu span")
		$(ls[1]).css('margin-top',"-19px");
		$(ls[2]).css('margin-left',"10px").css('margin-top',"93px");
		$(ls[3]).css('margin-left',"-12px").css('margin-top',"93px");
	}




 	var fx=0;
 	var fy=0;
 	var cPos = [1,1];
 	var posMap=[
	 					[9,1,9],
	 					[4,0,2],
	 					[9,3,9]
 					]


// 画面サイズ再描画
	var SW=0;
	var SH=0;

	$(window).on('load resize', resize );
	function resize(){
		SW = window.innerWidth ? window.innerWidth : $(window).width();
	      SH = window.innerHeight ? window.innerHeight : $(window).height();
	      $("#menuGp").stop().css({ "left":fx*SW  , "top":fy*SH });

	}
	resize();


	// cross menuの設定
	// up down left right
	var crossList =[]
	for (var i = 0; i < 4; i++) {
		console.log($("#crossMenu div")[i]);
		crossList.push( new CrossMenu($("#crossMenu div")[i]) );
	};


	// menu switch
	var menuMode =false;	//t:open
	$("#menu").css({ opacity: "1"});
	$("#listmenu").css({  "height":0 ,"marginTop":0 })

	// changeListMode()


	$("#menu").css({"visibility":"hidden" } )
	$("#crossMenu").css({"visibility":"hidden" } )
	$("#listmenu").css({"visibility":"hidden" } )
	$("#etcMenu").css({"visibility":"hidden" } )
	$("#footR").css({"visibility":"hidden" } )
	$("#headR").css({"visibility":"hidden" } )



	$("#menuSwitch").click(function(){
		menuMode=!menuMode;
		changeListMode()
	})


	// menuへのイメージ設定
	var ls=$(".menuGr")
	for (var i = 0; i < 5; i++) {
		var o= $(ls[i])
		$(o).css('background-image', "url('"+$(o).attr("path")+"')")
	};



	// 	メニューモード切り替え
	function  changeListMode(){

		// open / close
		if(menuMode){
			$("#listmenu").css("visibility","visible")
			$("#menuSwitch").css('backgroundPosition', '0 21px');
			$("#crossMenu").hide(400);

			$("#menu").stop().animate(
					{ "opacity":0  },
					{
						'duration':400,
						'easing':'easeInOutQuart'
			})

			$("#listmenu").stop()
				.animate(
					{  "height":600 , "marginTop":-300  },
					{
						'duration':400,
						'easing':'easeInOutQuart'
			})
		}

		else{
			$("#menuSwitch").css('backgroundPosition', '0 0');
			$("#crossMenu").show(400);

			$("#menu").stop().animate(
					{ "opacity":1  },
					{
						'duration':400,
						'easing':'easeInQuart'
			})

			$("#listmenu").stop()
				.animate(
					{ "height":0 ,"marginTop":-0 },
					{
						'duration':400,
						'complete': listComp,
						'easing':'easeInOutQuart'
			})
		}
	}




	function listComp(){
		$("#listmenu").css("visibility","hidden")
	}
	listComp();



	// 移動管理
	function motion( _x , _y){
//		alert("x="+_x);alert("y="+_y);
		// 配列内の移動用
		var py = cPos[0];
//		alert("cPos="+cPos);
		var px = cPos[1];
		px+=-_x;
		py+=-_y;
//		alert("py="+py);alert("px="+px);

		cPos[0] =py;
		cPos[1] =px;

		var np = posMap[ py ][ px ];

		// cIDの設定
		setCID(np);


		if(_x != 0){
			fx+=_x;
			$("#menuGp").stop()
						.animate(
							{ "left": fx*SW },
							{
								'duration':300,
								'complete': motionComplete,
								'easing':'easeInOutQuart'
							})
		}

		if(_y != 0){
			fy+=_y;
			$("#menuGp").stop()
						.animate(
							{ "top":fy*SH },
							{
								'duration':300,
								'complete': motionComplete,
								'easing':'easeInOutQuart'
							})
		}
	}


	function motionComplete(){
		var y= parseInt($("#menuGp").css("top"))
		var x= parseInt($("#menuGp").css("left"))
		// $("#dView").text(getCID())
	}


	var contLeft = 0;
	var contRight = 0;
	var contUp = 0;
	var contDown = 0;

	// 上下左右
	$("#crossMenu div").click(function(){
		var idx= $(this).attr("id");
		var name= $(this).children("span").text();
		switch (idx) {
			case "left":	if(contLeft == 0){
								contLeft++;
								if(contRight != 0 || contUp != 0 || contDown != 0){
									cPos = [1,1];
									init();
								}
								motion(1 , 0);
							}else if(contLeft == 1){
								contLeft++;
								cPos = [1,0];
								motion( -2 ,  0);
							}else{
								contLeft = 0;
								init();
								motion(-1 , 0);
							}
							break;

			case "right": 	if(contRight == 0){
								contRight++;
								if(contLeft != 0 || contUp != 0 || contDown != 0){
									cPos = [1,1];
									init();
								}
								motion(-1 , 0);
							}else if(contRight == 1){
								contRight++;
								cPos = [1,2];
								motion( 2 ,  0);
							}else{
								contRight = 0;
								init();
								motion(1 , 0);
							}
							break;

			case "up": 		if(contUp == 0){
								contUp++;
								if(contLeft != 0 || contRight != 0 || contDown != 0){
									cPos = [1,1];
									init();
								}
								motion( 0 ,  1);
							}else if(contUp == 1){
								contUp++;
								cPos = [0,1];
								motion( 0 ,  -2);
							}else{
								contUp = 0;
								init();
								motion( 0 , -1);
							}
							break;

			case "down": 	if(contDown == 0){
								contDown++;
								if(contLeft != 0 || contRight != 0 || contUp != 0){
									cPos = [1,1];
									init();
								}
								motion( 0 ,  -1);
							}else if(contDown == 1){
								contDown++;
								cPos = [2,1];
								motion( 0 ,  2);
							}else{
								contDown = 0;
								init();
								motion( 0 , 1);
							}
							break;

			default : break;
		}
	})



	function changeCID(){
	}
	changeCID();



	$("#menuTap").click(function(){
		var src;
		switch (getCID()){
		case 0: src="/ict/view/gadget/nav.html?seqFlg=110000001";
			break;
		case 1: src="/ict/view/gadget/servCalender.html?seqFlg=140000001";
			break;
		case 2: src="/ict/view/gadget/medicareGadget.html?seqFlg=120000001";
			break;
		case 3: src="/ict/view/gadget/doc.html?seqFlg=130000001";
			break;
		case 4: src="/ict/view/gadget/conference.html?seqFlg=150000001";
			break;

		}
		// console.log("menu tap!" ,  $($("#menuGp li")[getCID()]).attr("path",src) )
		window.location.href = src;
	})



	var pd = new PdMenu("#infoMenu" , "#infoTtl")
	var pd2 = new PdMenu("#todayMenu" , "#todayTtl")
	pd.change(true)
	pd2.change(true)

	$("#infoMenu > .prsBox").click(function(){
		pd.change(null)
	})

	$("#todayMenu > .prsBox").click(function(){
		pd2.change(null)
	})





 // 	// /////////////////////////////////////////////////////////////////////////////
 // 	//	menu


	var gage = 60;
	function ges(){
		var gObj = document.getElementById('wrapper');
		var mc = new Hammer( gObj );
		mc.get('swipe').set({ direction: Hammer.DIRECTION_ALL   });
		mc.on("swipeleft swiperight swipeup swipedown",function (e) {
			var nx = Math.abs(e.deltaX)
			var ny = Math.abs(e.deltaY)

			var c=getCID();
			if( nx>gage || ny>gage){
				if( e.type=="swipeleft"){
					if(c==0 || c==4) motion(-1 , 0);
				}
				if( e.type=="swiperight") {
					if(c==0 || c==2) motion(1 , 0);
				}
				if( e.type=="swipeup")	{
					if(c==0 || c==1) motion(0 , -1);
				}
				if( e.type=="swipedown") {
					if(c==0 || c==3) motion(0 , 1);
				}
			}
		})

	}




	// ターゲットヘッダ
//	function ldDisp(f , c) {
//		$('#popInfoBox').ready(function(){
//			$.ajax({
//				type: 'GET',
//				url: f,
//				dataType: 'html',
//				success: function(data) {
//					$("#popInfoBox").html(data);
//					c();
//				}
//
//			});
//		});
//	}




	// 仮の遷移機能

//		function  loadLoginComp(){
//			$("#userSearch  .cBtn").click(function(){
//				ldDisp("user2.html",loadUserComp)
//			})
//		}


		function  loadUserComp(){
//			$("#userSearch  .cBtn").click(function(){
				$("#popInfoBox").remove()
				first()

				setTimeout( function(){
					pd.change(false)
				},1050)

				setTimeout( function(){
					pd2.change(false)
				},1000)

//			})
		}



}







