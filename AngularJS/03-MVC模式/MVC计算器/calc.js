
// 控制器对象，用于实例化
function calcController($scope) {
	$scope.price = 10;
	$scope.number = 1;
	$scope.getSum = function () {
		return $scope.price * $scope.number;
	}
}

// 绑定到ng-app，注意module名和ng-app名称一致，这里为""myapp"
var app = angular.module("myapp", []);
app.controller("calcController", calcController);

