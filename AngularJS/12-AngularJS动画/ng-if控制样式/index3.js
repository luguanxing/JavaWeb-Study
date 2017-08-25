var app = angular.module("myApp", ["ngAnimate"])
app.controller("MainController", function ($scope) {
	$scope.isShow = false;
});

//.showBox样式出现或消失时调用
app.animation('.showBox', function () {
	return {
		//.showBox样式出现
		enter: function (element, done) {
			console.log(".showBox出现_开始");
			element.css('display', 'none');
			$(element).fadeIn(500, function () {
				console.log(".showBox出现_结束");
				done();
			});
		},
		//.showBox样式消失
		leave: function (element, done) {
			console.log(".showBox消失_开始");
			$(element).fadeOut(500, function () {
				console.log("showBox消失_结束");
				done();
			});
		}
	}
})
