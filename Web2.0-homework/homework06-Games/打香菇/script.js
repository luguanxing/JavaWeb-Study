var score;
var time;
var clock;
var playing; 	//游戏状态

function sethole() {	//设置洞穴
	var i;
	var hole;
	var gamearea = document.getElementById("gamearea");
	for (i = 1; i <= 15; i++) {
		hole = document.createElement("div");
		hole.className = "hole";
		hole.onclick = wrong;
		gamearea.appendChild(hole);
	}
}

function newxianggu() {		//香菇状态
	var place = Math.round(Math.random()*998)%15;
	var holes = document.getElementsByClassName("hole");
	holes[place].setAttribute("id", "xianggu");
	holes[place].onclick = beaten;
}

function beaten() {
	xianggu = document.getElementById("xianggu");
	xianggu.setAttribute("id","xianggu2");
	xianggu.onclick = wrong;
	setTimeout(gg, 500);
}

function wrong() {
	if (!playing)
		return;
	score--;
	document.getElementById("score").value = score;
}

function gg() {
	var xianggu = document.getElementById("xianggu2");
	xianggu.setAttribute("id","");
	if (playing) {
		newxianggu();
		score++;
		document.getElementById("score").value = score;
	}
}

function start() {	//控制台功能
	if (playing)
		return;
	score = 0;
	time = 30;
	playing = true;
	document.getElementById("status").innerHTML = "游戏中";
	newxianggu();
	document.getElementById("score").value = score;
	document.getElementById("time").value = time;
	clock = window.setInterval(subtime, 1000);
}


function subtime() {
	if (time > 0) {
		time--;
		document.getElementById("time").value = time;
	} else {
		playing = false;
		document.getElementById("status").innerHTML = "未开始";
		clearInterval(clock);
		beaten();
	}
}

function stop() {
	if (!playing)
		return;
	time = 0;
	playing = false;
	document.getElementById("status").innerHTML = "未开始";
	beaten();
	clearInterval(clock);
	document.getElementById("time").value = time;
	freeze();	/*防止同步问题*/
}

function freeze() {
	document.getElementById("start").onclick = "";
	setTimeout(unfreeze, 500);
}

function unfreeze() {
	document.getElementById("start").onclick = start;
}

function setbuttons() {
	document.getElementById("start").onclick = start;
	document.getElementById("stop").onclick = stop;
}

window.onload = function() {	//加载游戏
	playing = false;
	sethole();
	setbuttons();
}