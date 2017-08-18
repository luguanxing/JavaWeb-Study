
function firstController($scope, $log) {
	$scope.text1 = "text1";
	$log.info($scope);
}

function secondController($scope, $log) {
	$scope.text2 = "text2";
	$log.info($scope);
}

var app = angular.module("myapp", []);
app.controller("firstController", firstController);
app.controller("secondController", secondController);