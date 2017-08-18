
var routeMoudle = angular.module('routeModule', ['ngRoute']);

routeMoudle.config(['$routeProvider',
	function ($routeProvider) {
		$routeProvider.
		when('/showOrder/:orderId', {
			templateUrl: 'views/show-detail.html',
			controller: 'ShowOrdersController'
		})
	}
]);

routeMoudle.controller("ShowOrdersController", function ($scope, $routeParams) {
	$scope.orderId = $routeParams.orderId;
});