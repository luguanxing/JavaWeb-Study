var pictures_hide;
var buttons_hide;
var difficulty;	//游戏难度
var score;	//游戏步数
var playing;	//游戏状态
var puzzle = [[0,1,2,3],[4,5,6,7],[8,9,10,11],[12,13,14,15]];	//模拟位置
var backgroundpicture = [" soliders", " tanks", " fieldpiece", " artillery", " cannon"];	//图片
var backgroundpictureponit	//图片指针

function hidepictures() {
	var pictures = document.getElementsByClassName("picture");
	var length = pictures.length;
	for (var i = 0; i < length; i++)
		pictures[0].className = "picture_hide";
	document.getElementById("pictures").id = "pictures_hide";
	pictures_hide = true;
	setbuttons();
	document.getElementById("soliders").onclick = null;
	document.getElementById("tanks").onclick = null;	
	document.getElementById("fieldpiece").onclick = null;
	document.getElementById("artillery").onclick = null;
	document.getElementById("cannon").onclick = null;
}

function showpictures() {
	var pictures = document.getElementsByClassName("picture_hide");
	var length = pictures.length;
	for (var i = 0; i < length; i++)
		pictures[0].className = "picture";
	document.getElementById("pictures_hide").id = "pictures";
	pictures_hide = false;
	setbuttons();
	document.getElementById("soliders").onclick = function () {
		backgroundpictureponit = 0;
		setpuzzle(backgroundpicture[backgroundpictureponit]);
		playing = false;
		score = 0;
		document.getElementById("score").value = score;		
	}
	document.getElementById("tanks").onclick = function () {
		backgroundpictureponit = 1;
		setpuzzle(backgroundpicture[backgroundpictureponit]);
		playing = false;
		score = 0;
		document.getElementById("score").value = score;		
		
	}	
	document.getElementById("fieldpiece").onclick = function ()  {
		backgroundpictureponit = 2;
		setpuzzle(backgroundpicture[backgroundpictureponit]);
		playing = false;
		score = 0;
		document.getElementById("score").value = score;				
	}
	document.getElementById("artillery").onclick = function ()  {
		backgroundpictureponit = 3;
		setpuzzle(backgroundpicture[backgroundpictureponit]);
		playing = false;
		score = 0;
		document.getElementById("score").value = score;				
	}
	document.getElementById("cannon").onclick = function ()  {
		backgroundpictureponit = 4;
		setpuzzle(backgroundpicture[backgroundpictureponit]);
		playing = false;
		score = 0;
		document.getElementById("score").value = score;				
	}
}

function hidedifficulty() {
	var buttons = document.getElementsByClassName("button2");
	var length = buttons.length;
	for (var i = 0; i < length; i++) {
		buttons[0].onclick = null;		
		if (buttons[0].className == "button2")
			buttons[0].className = "button_hide";
		else
			buttons[0].className = "button_hide" + " chosen";
	}
	document.getElementById("difficulty").id = "difficulty_hide";
	buttons_hide = true;
	setbuttons();
}

function showdifficulty() {
	var buttons = document.getElementsByClassName("button_hide");
	var length = buttons.length;
	for (var i = 0; i < length; i++) {
		if (buttons[0].className == "button_hide")
			buttons[0].className = "button2";
		else
			buttons[0].className = "button2" + " chosen";		
	}
	setdifficulty();
	document.getElementById("difficulty_hide").id = "difficulty";
	buttons_hide = false;
	setbuttons();
}

function setpuzzle(name) {
	var i, j;
	var pic, empty;
	var gamearea = document.createDocumentFragment();
	for (var i = 0; i < 4; i++)
		for (var j = 0; j < 4; j++)
			puzzle[i][j] = 4*i + j;
	for (i = 0; i < 15; i++) {
		pic = document.createElement("div");
		pic.className = "p " + name;
		pic.id = "p"+i;
		pic.setAttribute("num", i);			
		pic.setAttribute("y", Math.floor(i/4));
		pic.setAttribute("x", i%4);	
		gamearea.appendChild(pic);
		pic.onclick = function() {
			if (!playing)
				return;
			var y = parseInt(this.getAttribute("y"));
			var x = parseInt(this.getAttribute("x"));	
			swap(y,x);
		}
		pic.onmouseover = function() {
			var y = parseInt(this.getAttribute("y"));
			var x = parseInt(this.getAttribute("x"));
			if (difficulty == 0)
				return;
			if (moveable(y, x) && playing)
				this.className += " p_hover";
		}
		pic.onmouseout = function() {
			this.className = "p" + backgroundpicture[backgroundpictureponit];
		}		
	}
	var puzzlepics = document.getElementById("gamearea");
	while(puzzlepics.firstChild != null)
		puzzlepics.removeChild(puzzlepics.childNodes[0]);
	puzzlepics.appendChild(gamearea);
}

function setbuttons() {
	if (pictures_hide == false)
		document.getElementById("changepictures").onclick = hidepictures;
	else
		document.getElementById("changepictures").onclick = showpictures;
	if (buttons_hide == false)
		document.getElementById("changedifficulty").onclick = hidedifficulty;
	else
		document.getElementById("changedifficulty").onclick = showdifficulty;
}

function setdifficulty() {
	for (var i = 1; i <= 6; i++) {
		document.getElementById("difficulty" + i).setAttribute("difficulty", i);
		document.getElementById("difficulty" + i).onclick = function () {
			if (difficulty != 0)
				document.getElementById("difficulty" + difficulty).className = "button2";			
			var newdifficulty = this.getAttribute("difficulty");
			difficulty = newdifficulty;
			this.className += " chosen";
		}
	}		
}

function checkwin() {	//检查模拟位置
	var puzzlepics = document.getElementById("gamearea");
	for (var i = 0; i <= 14; i++)
		if (puzzle[Math.floor(i/4)][i%4] != i)
			return false;
	return true;
}

function moveable(y1, x1) {	//检查x1,y1周围有无空格
		var y2;		
		var x2;
		for (var i = 0; i < 4; i++)
			for (var j = 0; j < 4; j++)
				if (puzzle[i][j] == 15) {
					y2 = i;
					x2 = j;
					break;
				}
		if (y1==y2+1 && x1==x2)	//可向上
			return 1;
		if (y1==y2-1 && x1==x2)	//可向下
			return 2;			
		if (y1==y2 && x1==x2+1)	//可向左
			return 3;			
		if (y1==y2 && x1==x2-1)	//可向右		
			return 4;
	return 0;
}

function swap(y,x) {	//同时改变DOM位置和模拟位置(Y,X)
	var y1 = parseInt(y);
	var x1 = parseInt(x);
	if (y1<0 || y1>3 || x1<0 || x1>3)
		return;
	var num = puzzle[y1][x1];
	if (difficulty == 0)
		return;
	var direction = moveable(y1, x1);
		if (direction == 0)
			return;
	var puzzlepics = document.getElementById("gamearea");
	var before =  puzzlepics.childNodes[num];		
	if (direction == 1)	{
		puzzle[y1-1][x1] = puzzle[y1][x1];
		puzzle[y1][x1] = 15;
		before.id = "p" + (4*(y1-1)+x1);
		before.setAttribute("y", y1-1);
		before.setAttribute("x", x1);			
	} else if (direction == 2)	{
		puzzle[y1+1][x1] = puzzle[y1][x1];
		puzzle[y1][x1] = 15;
		before.id = "p" + (4*(y1+1)+x1);
		before.setAttribute("y", y1+1);
		before.setAttribute("x", x1);			
	} else if (direction == 3)	{
		puzzle[y1][x1-1] = puzzle[y1][x1];
		puzzle[y1][x1] = 15;
		before.id = "p" + (4*y1+x1-1);	
		before.setAttribute("y", y1);
		before.setAttribute("x", x1-1);			
	} else if (direction == 4)	{
		puzzle[y1][x1+1] = puzzle[y1][x1];
		puzzle[y1][x1] = 15;
		before.id = "p" + (4*y1+x1+1);	
		before.setAttribute("y", y1);
		before.setAttribute("x", x1+1);			
	}
	if (checkwin() && playing) {
		alert("you win!");
		playing = false;
	}
	if (playing) {
		score++;
		document.getElementById("score").value = score;
	}
}

function findempty() {
	for (var i = 0; i < 4; i++)
		for (var j = 0; j < 4; j++)
			if (puzzle[i][j] == 15)
				return (4*i+j);
}

function stage1() {
	var r = Math.random();
	if (r <= 0.5)
		swap(2,3);
	else
		swap(3,2);	
}

function stage2() {
	var r = Math.random();
	if (r <= 0.33) {
		swap(2,3);
		swap(2,2);
		swap(3,2);
	} else if (r <= 0.66) {
		swap(3,2);
		swap(2,2);
		swap(2,3);
		swap(3,3);				
		swap(3,2);				
		swap(2,2);
	} else {
		swap(3,2);				
		swap(2,2);				
		swap(2,3);
	}
}

function stage3() {
	var steps = Math.round(Math.random()*30)+50;
	for (var i = 0; i < steps; i++) {
		var e = findempty();
		var y = Math.floor(e/4);
		var x = Math.floor(e%4);
		if (y == 2) {
			var r = Math.random();
			if (r <= 0.33) {
				swap(y,x-1);
			} else if (r <= 0.66) {
				swap(y+1,x);
			} else {
				swap(y,x+1);
			}					
		} else if (y == 3) {
			var r = Math.random();
			if (r <= 0.33) {
				swap(y,x-1);
			} else if (r <= 0.66) {
				swap(y-1,x);
			} else {
				swap(y,x+1);
			}						
		}
	}
}
function stage4() {
	var steps = Math.round(Math.random()*50)+50;
	for (var i = 0; i < steps; i++) {
		var e = findempty();
		var y = Math.floor(e/4);
		var x = Math.floor(e%4);
		if (y == 1) {
			var r = Math.random();
			if (r <= 0.33) {
				swap(y,x-1);
			} else if (r <= 0.66) {
				swap(y+1,x);
			} else {
				swap(y,x+1);
			}					
		} else if (y == 2) {
			var r = Math.random();
			if (r <= 0.25) {
				swap(y,x-1);
			} else if (r <= 0.5) {
				swap(y-1,x);
			}  else if (r <= 0.75) {
				swap(y+1,x);
			} else {
				swap(y,x+1);
			}						
		} else if (y == 3) {
			var r = Math.random();
			if (r <= 0.33) {
				swap(y,x-1);
			} else if (r <= 0.66) {
				swap(y-1,x);
			} else {
				swap(y,x+1);
			}						
		}
	}
}

function stage5() {
	var steps = Math.round(Math.random()*80)+80;
	for (var i = 0; i < steps; i++) {
		var e = findempty();
		var y = Math.floor(e/4);
		var x = Math.floor(e%4);
		if (y == 0) {
			var r = Math.random();
			if (r <= 0.33)
				swap(y,x-1);
			else if (r <= 0.66)
				swap(y+1,x);
			else 
				swap(y,x+1);		
		} else if (y == 1) {
			var r = Math.random();
			if (r <= 0.25)
				swap(y,x-1);
			else if (r <= 0.5)
				swap(y-1,x);
			else if (r <= 0.75)
				swap(y+1,x);
			else
				swap(y,x+1);						
		} else if (y == 2) {
			var r = Math.random();
			if (r <= 0.25)
				swap(y,x-1);
			else if (r <= 0.5)
				swap(y-1,x);
			else if (r <= 0.75)
				swap(y+1,x);
			else
				swap(y,x+1);					
		} else if (y == 3) {
			var r = Math.random();
			if (r <= 0.33)
				swap(y,x-1);
			else if (r <= 0.66)
				swap(y-1,x);
			else
				swap(y,x+1);					
		}
	}

}
function stage6() {
	stage5();
	stage4();
	stage3();
}

function start() {
	playing = false;
	score = 0;
	document.getElementById("score").value = score;
	setpuzzle(backgroundpicture[backgroundpictureponit]);
	var i;
	switch(parseInt(difficulty)) {
		case 0: {
			alert("请先选择难度!");
		}
			break;
			
		case 1: {
			stage1();
		}
			break;
			
		case 2: {
			stage2();
		}
			break;
			
		case 3: {
			stage3();
			while (checkwin())
				stage3();
		}
			break;
			
		case 4: {
			stage4();
			while (checkwin())
				stage4();
		}
			break;
			
		case 5: {
			stage5();
			while (checkwin())
				stage5();
		}
			break;
			
		case 6: {
			stage6();
			while (checkwin())
				stage6();			
		}
			break;			
		default: {
			
		}
	}
	playing = true;
}

window.onload = function() {	//加载游戏
	pictures_hide = true;
	buttons_hide = true;
	difficulty = 0;
	playing = false;
	backgroundpictureponit = 0;
	setpuzzle(backgroundpicture[backgroundpictureponit]);	
	setbuttons();
	document.getElementById("start").onclick = start;
}
