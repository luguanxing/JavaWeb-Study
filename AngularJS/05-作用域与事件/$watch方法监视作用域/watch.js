
angular.module("watchapp", [])
	.run(['$rootScope', function ($rootScope) {
		$rootScope.count = 0;
		$rootScope.name = "luguanxing";
		$rootScope.$watch('name', function () {
			$rootScope.count++;
		});
	}]);