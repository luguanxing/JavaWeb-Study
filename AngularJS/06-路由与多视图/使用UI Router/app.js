
var routeModule = angular.module('routeModule', ['ui.router']);

routeModule.config(function ($stateProvider, $urlRouterProvider) {
	
	//其它情况跳转到根目录
	$urlRouterProvider.otherwise("/");

	//自定义状态(标签)
	$stateProvider.state("home", {
		url: "/home",
		templateUrl: "template/home.html",
		controller: function ($scope) {
			$scope.books = ["《Java编程思想》", "《AngularJS入门与进阶》", "《Java网络编程》"];
		}
	});

	$stateProvider.state("about", {
		url: "/about",
		templateUrl: "template/about.html",
		controller: function ($scope) {
			$scope.name = "Luguanxing";
		}

	});

	$stateProvider.state("contact", {
		url: "/contact",
		templateUrl: "template/contact.html"
	});
});