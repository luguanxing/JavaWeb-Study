
function firstController($scope, $log) {
	$scope.text = "text";
	$log.info($scope);
}

function secondController($scope, $log) {
	$log.info($scope);
}

var app = angular.module("myapp", []);
app.controller("firstController", firstController);
app.controller("secondController", secondController);