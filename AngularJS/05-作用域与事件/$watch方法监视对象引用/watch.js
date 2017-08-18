
angular.module("watchapp", [])
	.run(['$rootScope', function ($rootScope) {
		$rootScope.count = 0;
		$rootScope.items = [
			{"value" : 1},
			{"value" : 2},
			{"value" : 3},
		];
		$rootScope.$watch('items', function () {
			$rootScope.count++;
		}, true);
		// 第三个参数为true是监视整个对象（深复制），而不是监视引用
	}]);