
var app = angular.module("directiveModule", []);

app.directive("sayHello", function () {
	return {
		restrict : "AEC",
		replace : true,
		template : "<h1>hello,{{name}}</h1>"
	}
});

app.controller("MainController", function ($scope) {
	$scope.name = "lgx";
});