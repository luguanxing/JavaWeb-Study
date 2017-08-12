var status;		//-2未开始,-1输或赢,0开始,1-5各自不同阶段
var onpath;		//在道路上为true，不在为false
var clock;

function show() {		//设置提示信息
	document.getElementById("tips").style.opacity = 1;
}

function clear() {
	document.getElementById("tips").style.opacity = 0;
}

function changetext(string) {
	clearTimeout(clock);
	document.getElementById("tips").innerHTML = string;
	show();
	clock = setTimeout(clear, 1000);
}

function fixtext(string) {
	clearTimeout(clock);
	document.getElementById("tips").innerHTML = string;
	show();
}

function lose() {		//设置游戏函数
	status = -1;
	document.getElementById("maze").style.backgroundColor = "red";		
	setTimeout("alert(\"You Lose!\")", 350);
}

function goback() {
	alert("You Lose!");
	status = -1;
	fixtext("历史发展没有回头路！");
}

function setpath() {	//设置迷宫道路
	var paths = document.getElementsByClassName("path");
	for(i = 0; i < paths.length; i++) {
		paths[i].onmouseover = function(){onpath = true;};
		paths[i].onmouseout = function(){onpath = false;};
	}
}

function setwall() {	//设置迷宫墙壁
	document.getElementById("maze").onmouseover = function(){
		if (0 <= status && !onpath) {
			if (status == 0)
				fixtext("你被野蛮人打倒了");
			if (status == 1)
				fixtext("你被封建势力打倒了");
			if (status == 2)
				fixtext("你被帝国主义打倒了");
			if (status == 3)
				fixtext("你被法西斯主义打倒了");	
			if (status == 4)
				fixtext("你被黑恶势力打倒了");
			lose();
		}
	};
	document.getElementById("maze").onmouseout = function(){
			document.getElementById("maze").style.backgroundColor = "#CCC";
	};	
}

function setstage() {	//设置迷宫阶段
	for (var i = "1"; i <= "6"; i++) {
		document.getElementById("stage" + i).setAttribute("stage", i);
		document.getElementById("stage"+i).onmouseout = function(){
			var t = this.getAttribute("stage");
			document.getElementById("stage" + t).className = "stage";				
		}	
	}
	document.getElementById("stage1").onmouseover = function(){	
		if (status == -1 || status == -2) {
			status = 0;
			changetext("你从原始社会开始了");
			document.getElementById("maze").style.backgroundColor = "#CCC";
			document.getElementById("stage1").className = "stage_onmouse";				
		} else if (status >= 1)
			goback();
	}
	document.getElementById("stage2").onmouseover = function(){	
		if (status == 0) {
			status++;
			changetext("你进入了封建社会");
			document.getElementById("stage2").className = "stage_onmouse";				
		} else if (status > 1)
			goback();
	}
	document.getElementById("stage3").onmouseover = function(){	
		if (status == 1) {
			status++;
			changetext("你进入了半殖民地半封建社会");
			document.getElementById("stage3").className = "stage_onmouse";				
		} else if (status > 2)
			goback();
	}
	document.getElementById("stage4").onmouseover = function(){	
		if (status == 2) {
			status++;
			changetext("你进入了当代资本主义社会");
			document.getElementById("stage4").className = "stage_onmouse";				
		} else if (status > 3)
			goback();			
	}
	document.getElementById("stage5").onmouseover = function(){	
		if (status == 3) {
			status++;
			changetext("你进入了现代资本主义社会");
			document.getElementById("stage5").className = "stage_onmouse";				
		} else if ((status > 4))
			goback();			
	}
	document.getElementById("stage6").onmouseover = function(){	
		if (status == 4) {
			alert("You Win!");
			fixtext("恭喜！你进入了社会主义新时代！");
			document.getElementById("stage6").className = "stage_onmouse";				
			status = -1;
		} else if (status != -1) {
			alert("Don't cheat, you should start form the 'S' and move to the 'E' inside the maze!");
			status = -1;
			fixtext("不能跨阶段实现社会主义！");
		}
	}		
}

window.onload = function() {	//加载游戏主体
	status = -2;
	setwall();
	setpath();
	setstage();
}
