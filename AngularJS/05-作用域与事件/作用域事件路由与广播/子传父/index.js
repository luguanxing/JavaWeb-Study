
var app = angular.module("myapp", []);

app.controller("grandController", function ($scope) {
	$scope.$on("MyEventName", function (event, data) {
		console.log("爷作用域收到MyEventName事件");
		console.log(event);
		$scope.value = data;
	});
});

app.controller("parentController", function ($scope) {
	$scope.$on("MyEventName", function (event, data) {
		console.log("父作用域收到MyEventName事件");
		console.log(event);
		$scope.value = data;
		// 可利用event的方法阻止向上传递（只能向上）
		// event.stopPropagation();
	});
});

app.controller("childController", function ($scope) {
	$scope.clickbutton = function () {
		console.log("子作用域发送MyEventName事件");
		$scope.$emit("MyEventName", {name:"haha", age:123});
	}
});
