
angular.module("showapp", [])
	.controller("showController", function ($scope) {
		$scope.show = function () {
			setTimeout(function () {
				$scope.$apply(function () {
					//$apply()方法触发$digest()触发watcher更新View里的DOM内容
					$scope.message = "显示了";
					console.log("显示了");
				});
			}, 1000);
		}
	});