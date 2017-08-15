
function firstController($scope) {
	$scope.text1 = "text1";
}

function secondController($scope) {
	$scope.text2 = "text2";
}

var app = angular.module("myapp", []);
app.controller("firstController", firstController);
app.controller("secondController", secondController);