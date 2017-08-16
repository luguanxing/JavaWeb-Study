
var app = angular.module("myapp", []);

app.controller("parentController", function ($scope) {
	$scope.clickbutton = function () {
		console.log("父作用域发送MyEventName事件");
		$scope.$broadcast("MyEventName", {name:"haha", age:123});
	}
});

app.controller("child1Controller", function ($scope) {
	$scope.$on("MyEventName", function (event, data) {
		console.log("子作用域1收到MyEventName事件");
		console.log(event);
		$scope.value = data;
	});
});

app.controller("child2Controller", function ($scope) {
	$scope.$on("MyEventName", function (event, data) {
		console.log("子作用域2收到MyEventName事件");
		console.log(event);
		$scope.value = data;
	});
});