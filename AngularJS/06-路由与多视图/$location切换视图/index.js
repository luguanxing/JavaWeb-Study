
var routeModule = angular.module('routeModule',['ngRoute']);

routeModule.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
		when('/view1', {
			templateUrl: '/view1.html'
		}).
		when('/view2', {
			templateUrl: '/view2.html'
		})
	}]);

routeModule.controller("viewController", 
	function ($scope, $location) {
	// 使用$location在hashbang模式下修改"#"后的内容实现更换视图
		$scope.goView1 = function () {
			$location.path("/view1");
		};
		$scope.goView2 = function () {
			$location.path("/view2");
		}
	}
);