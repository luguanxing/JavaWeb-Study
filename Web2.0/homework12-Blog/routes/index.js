var express = require('express');
var fs = require("fs");
var url = require("url");
var path = require("path");
var querystring = require("querystring");
var data_manager = require('../controllers/data_manager');
/*
 * GET home page.
 */

exports.index = function(req, res){
	console.log("》》》》》》》》》》》》》》》》》》》》》》》》》主页判断是否登录");
	if (req.session.user == undefined) {	//判断是否登录
		console.log("》》》》》未登陆");
		res.end(__dirname + '../index.html');
	} else {
		console.log("》》》》》"+req.session.user.username+"已登陆");
		res.end(__dirname + '../index.html');
	}
};

exports.partials = function (req, res) {
	console.log("》》》》》》》》》》》》》》》》》》》》》》》》》分页判断是否登录");
	if (req.session.user == undefined) {	//判断是否登录
		var name = req.params.name;
		console.log("》》》》》未登陆，试图获取"+name);
		if (name == "info")
			res.render('partials/info');
		else
			res.render('partials/' + name);
	} else {
		console.log("》》》》》已登陆，试图获取"+name);
		var user = req.session.user;
		console.log("》》》》》已登陆jade"+user);
		var name = req.params.name;
		if (name == "info")
			res.render('partials/info_sign', {user: user});
		else if (name == "signin")
			res.render('partials/info_sign', {user: user});
		else if (name == "signup")
			res.render('partials/info_sign', {user: user});
		else if (name == "index" && user.username == "geping")
			res.render("partials/index_admin");
		else
			res.render('partials/' + name);
	}
};