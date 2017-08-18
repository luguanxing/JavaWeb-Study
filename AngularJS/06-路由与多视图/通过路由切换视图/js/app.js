
var routeMoudle = angular.module('routeModule', ['ngRoute']);

routeMoudle.config(['$routeProvider',
	function ($routeProvider) {
		$routeProvider.
		when('/showOrders', {
			templateUrl: 'views/show-orders.html',
			controller: 'ShowOrdersController'
		}).
		when('/addOrder', {
			templateUrl: 'views/add-order.html',
			controller: 'AddOrderController'
		}).
		otherwise({
			redirectTo: '/showOrders'
		});
	}
]);