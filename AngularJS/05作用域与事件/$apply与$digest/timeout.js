
angular.module("showapp", [])
	.controller("showController", function ($scope, $timeout) {		// 注意要注入$timeout
		$scope.show = function () {
			$timeout(function () {
				$scope.message = "显示了";
				console.log("显示了");
			}, 1000);
		}
	});