var express = require('express');
var router = express.Router();
var http = require("http");
var fs = require("fs");
var url = require("url");
var path = require("path");
var querystring = require("querystring");
var data_manager = require('../controllers/data_manager');

router.get('/', function(req, res, next) {
	console.log("");
	var queryusername = querystring.parse(url.parse(req.url).query).username;
	if (queryusername != undefined) {	//有查询
		console.log(req.session.user + "试图查询用户" + queryusername);
		if (req.session.user == undefined) {	//判断是否登录
			console.log("未登陆就试图查询,失败");
			res.sendfile("./views/signin.html");
		} else {
			if (queryusername == req.session.user["username"]) {	//查询自己
				console.log("登陆情况下查询自己");
				data_manager.showuserinfo(req, res, queryusername, true);
			} else {
				console.log("登陆情况下查询别人");
				data_manager.showuserinfo(req, res, req.session.user["username"], false);
			}
		}
	} else {	//未查询
		console.log("无查询操作");
		if (req.session.user == undefined) {	//判断是否为登录用户	
			console.log("进入登录界面");
			res.sendfile("./views/signin.html");
		} else {
			data_manager.showuserinfo(req, res, req.session.user["username"], true);
		}
	}
});

router.get('/regist', function(req, res, next) {
	if (req.session.user != undefined) {	//已经登录
		console.log("已登录下进入注册页面");
		data_manager.showuserinfo(req, res, req.session.user["username"], true);
	} else {
		console.log("进入注册界面");
		res.sendfile("./views/signup.html");
	}
});

router.post('/logout', function(req, res, next) {	//退出登录
	req.session.user = undefined;
	console.log("用户退出");
	res.end("成功退出");
})

router.post('/checksigin', function(req, res, next) {	//登录:检验姓名、密码正确性
	data_manager.check_signin(req.body, req, res);
});

router.post('/checksigup', function(req, res, next) {	//注册:检验姓名、学号、电话、邮箱重复性
	data_manager.check_signup(req.body, req, res);
});

module.exports = router;


