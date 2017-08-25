
var animateApp = angular.module('animateApp', ['ngRoute', 'ngAnimate']);

animateApp.config(function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl: 'page-home.html',
			controller: 'MainController'
		})
		.when('/about', {
			templateUrl: 'page-about.html',
			controller: 'AboutController'
		})
		.when('/contact', {
			templateUrl: 'page-contact.html',
			controller: 'ContactController'
		});

});

animateApp.controller('MainController', function($scope) {
	$scope.pageClass = 'page-home';
});

animateApp.controller('AboutController', function($scope) {
	$scope.pageClass = 'page-about';
});

animateApp.controller('ContactController', function($scope) {
	$scope.pageClass = 'page-contact';
});

animateApp.animation('.page-home', function () {
	return {
		enter: function (element, done) {
			console.log(".page-home出现开始");
			element.css('display', 'none');
			$(element).fadeIn(500, function () {
				console.log(".page-home出现结束");
				done();
			});
		},
		leave: function (element, done) {
			console.log(".page-home消失开始");
			$(element).fadeOut(500, function () {
				console.log(".page-home消失结束");
				done();
			});
		}
	}
});

animateApp.animation('.page-about', function () {
	return {
		enter: function (element, done) {
			console.log(".page-about出现开始");
			element.css('display', 'none');
			$(element).fadeIn(500, function () {
				console.log(".page-about出现结束");
				done();
			});
		},
		leave: function (element, done) {
			console.log(".page-about消失开始");
			$(element).fadeOut(500, function () {
				console.log(".page-about消失结束");
				done();
			});
		}
	}
});

animateApp.animation('.page-contact', function () {
	return {
		enter: function (element, done) {
			console.log(".page-contact出现开始");
			element.css('display', 'none');
			$(element).fadeIn(500, function () {
				console.log(".page-contact出现结束");
				done();
			});
		},
		leave: function (element, done) {
			console.log(".page-contact消失开始");
			$(element).fadeOut(500, function () {
				console.log(".page-contact消失结束");
				done();
			});
		}
	}
});


