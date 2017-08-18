
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