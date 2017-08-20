
var app = angular.module("directiveModule",[]);

app.directive("watchTest",function(){
	return {
		restrict:'AEC',
		replace:true,
		templateUrl:'watchtest.html',
		link : function (scope, elem, attrs) {
			scope.$watch('message', function (newValue, oldValue) {
				console.log(oldValue + '->' + newValue);
			});
			scope.clearMessage = function () {
				scope.message = "";
			}
		}
	}
});

app.controller("MainController", function ($scope) {
	$scope.message = "lgx";
});