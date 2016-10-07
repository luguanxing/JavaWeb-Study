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

function isoperator(s) {
	if (!isNaN(s))
		return false;
	if (s == "(" || s == ")")
		return false;
	return true;
}

function check() {
	var string = document.getElementById("screen").value;
	if (string == "")
		return false;	
	else if (isNaN(string[0]) && string[0] != "(" && string[0] != "-")
		return false;
	else if (isNaN(string[string.length-1]) && string[string.length-1] != ")")
		return false;
	else {
		var leftbracket = 0, rightbracket = 0;
		for (var i = 0; i < string.length; i++) {
			if (i != 0 && isoperator(string[i]) && isoperator(string[i-1]))
				return false;
			if (string[i] == "(")
				leftbracket++;
			if (string[i] == ")")
				rightbracket++;			
		}
		if (leftbracket != rightbracket)
			return false;	
	}
	return true;
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
			if (check()) {
				var result = eval(document.getElementById("screen").value);
				if (MIN_INT < result && result < MAX_INT)
					showstring(parseFloat(result.toFixed(6)));
				else {
					alert("Overflow!");
					showstring("");
				}
			} else {
				alert("Error!");
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
