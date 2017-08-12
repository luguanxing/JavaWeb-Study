MAX_INT = 9007199254740992;
MIN_INT = -9007199254740992;

function showstring(result) {
	document.getElementById("screen").value	= result;
	document.getElementById("screen").scrollLeft = document.getElementById("screen").scrollWidth;	
}

function addstring(result) {
	document.getElementById("screen").value += result;
	document.getElementById("screen").scrollLeft = document.getElementById("screen").scrollWidth;
}

function backstring() {
	var result = document.getElementById("screen").value;
	result = result.substring(0, result.length-1);
	document.getElementById("screen").value = result;
}

function setbutton() {
	var but=document.getElementsByClassName("button");
	for(i = 0; i <= 17; i++) {
		if (i == 14)
			continue;
		but[i].onclick = function(){
			addstring(this.getAttribute("id"));
		}
	}
	document.getElementById("←").onclick = function () {
		backstring();
	}
	document.getElementById("CE").onclick = function () {
		showstring("");
	}
	document.getElementById("=").onclick = function() {
		try {
			var result = eval(document.getElementById("screen").value);
			if (MIN_INT < result && result < MAX_INT)
				showstring(parseFloat(result.toFixed(6)));
			else {
				alert("Overflow!");
				showstring("");
			}
		} catch (error) {
			alert("Error!!");
			showstring("");
		}
	}
}

window.onload = function() {
	showstring("");	
	setbutton();
}
