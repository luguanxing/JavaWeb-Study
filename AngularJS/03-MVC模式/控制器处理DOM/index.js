
// 控制器对象，用于实例化
function clickController($scope) {
	$scope.clicknum = 0;
	$scope.clickbutton = function () {
		$scope.clicknum++;
	}
}

// 绑定到ng-app，注意module名和ng-app名称一致，这里为""myapp"
angular.module("myapp", []).controller("clickController", clickController);

