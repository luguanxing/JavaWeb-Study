var express = require('express');
var router = express.Router();
var http = require("http");
var fs = require("fs");
var url = require("url");
var path = require("path");
var querystring = require("querystring");
var moment = require("moment");

/* GET home page. */
router.get('/', function(req, res, next) {
  res.sendfile("index.html");
});

router.get('/comments', function(req, res, next) {
	fs.readFile("data/comment.txt", 'utf-8', function (error, data) {
		if (error) throw error;
		res.end(data);
	});	
})

router.post('/comment', function(req, res, next) {
	console.log("comment post");
	var text = req.body["text"];
	var name = req.body["name"];
	console.log("");
	console.log(">>>>>>>>>>>>>>>>收到评论POST请求<<<<<<<<<<<<<<");
				console.log("评论"+text);
				console.log("姓名"+name);	
	console.log(">>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<");
	console.log("");
	if (text.trim() == "" || text.length >200 || name.trim() == "" || name.length > 30 || text.trim() == undefined || name.trim() ==undefined ) {
		res.end("Format Error");
	} else {	
		fs.readFile("data/comment.txt", 'utf-8', function (error, data) {
			if (error) throw error;
			console.log("data!!!!!!!!!!\n");
			var comments = JSON.parse(data)["comments"];
			console.log("comments!!!!!!!!!!\n"+comments);
			var num = comments.length;
			var time = moment().utc().zone(-8).format("YYYY-MM-DD HH:mm:ss");
			var newcomment =  {
				'text':"",
				'name': ""
			};
			newcomment["text"] = text;
			newcomment["name"] = name + "   " + time;
			comments[num] = newcomment; 
			console.log("");
			console.log(">>>>>>>>>>>>>>>>检查已有评论<<<<<<<<<<<<<<");
						console.log(comments);
						console.log("数量"+num);	
			console.log(">>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<");
			console.log("");
			var data = {"comments":[]};
			data["comments"] = comments;
			fs.writeFile("data/comment.txt", JSON.stringify(data),  function (error) {
							if (error) throw error;
							res.end("success");
						})
		});		
	}
});

module.exports = router;
