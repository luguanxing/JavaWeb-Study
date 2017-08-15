
function firstController($scope) {
	$scope.text = "text";
}

function secondController($scope) {
	
}

var app = angular.module("myapp", []);
app.controller("firstController", firstController);
app.controller("secondController", secondController);