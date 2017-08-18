
var loginModule = angular.module("loginModule", []);
loginModule.controller("UserController", function ($scope, $log) {
	$scope.username = "loginModule";
	$scope.password = "password";
	$scope.login = function () {
		alert("点击了登录按钮！");
	}
})

var registerModule = angular.module("registerModule", []);
registerModule.controller("UserController", function ($scope, $log) {
	$scope.username = "registerModule";
	$scope.password = "password";
	$scope.login = function () {
		alert("点击了注册按钮！");
	}
})