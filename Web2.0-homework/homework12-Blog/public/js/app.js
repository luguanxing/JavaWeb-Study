'use strict';

// Declare app level module which depends on filters, and services
angular.module('myApp', ['myApp.filters', 'myApp.services', 'myApp.directives']).
  config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
    $routeProvider.
      when('/', {
        templateUrl: '../partials/profile',
        controller: ShowProfile
      }).
      when('/signin', {
        templateUrl: '../partials/signin',
        controller: SignIn
      }).
      when('/signup', {
        templateUrl: '../partials/signup',
        controller: SignUp
      }).
      when('/info', {
        templateUrl: '../partials/info',
        controller: Info
      }).
      when('/profile', {
        templateUrl: '../partials/profile',
        controller: ShowProfile
      }).
      when('/projects', {
        templateUrl: '../partials/projects',
        controller: ShowProjects
      }).
      when('/projects2', {
        templateUrl: '../partials/projects2',
        controller: ShowProjects2
      }).
      when('/addPost', {
        templateUrl: '../partials/addPost',
        controller: AddPostCtrl
      }).
      when('/readPost/:id', {
        templateUrl: '../partials/readPost',
        controller: ReadPostCtrl
      }).
      when('/editPost/:id', {
        templateUrl: '../partials/editPost',
        controller: EditPostCtrl
      }).
      when('/deletePost/:id', {
        templateUrl: '../partials/deletePost',
        controller: DeletePostCtrl
      }).
      when('/getPosts/', {
        templateUrl: '../partials/index',
        controller: IndexCtrl
      }). 	  
      otherwise({
        redirectTo: '../'
      });
    $locationProvider.html5Mode(true);
  }]);