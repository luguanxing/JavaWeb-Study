
angular.module("watchapp", [])
	.run(['$rootScope', function ($rootScope) {
		$rootScope.count = 0;
		$rootScope.name = "luguanxing";
		var unBindWatcher = $rootScope
			.$watch('name', function (newValue, oldValue) {
			console.log("newValue="+newValue);
			console.log("oldValue="+oldValue);
			if (newValue == 'stop') {
				unBindWatcher();
				console.log("停止计数");
			}
			$rootScope.count++;
		});
	}]);