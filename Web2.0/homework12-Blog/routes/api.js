var fs = require("fs");
var moment = require("moment");
/*
 * Serve JSON to our AngularJS client
 */

// For a real app, you'd make database requests here.
// For this example, "data" acts like an in-memory "database"

// GET
exports.posts = function (req, res) {
	fs.readFile("data/data.txt", 'utf-8', function (error, data) {
		if (error) throw error;
		data = JSON.parse(data);
		  var posts = [];
		  var sum = data.posts.length;
		  console.log("评论数量:"+data.posts.length);
		  
		  for (var i=sum-1; i>=0; i--) {
				var post = data.posts[i];
				var mytext, name, mytitle;
				mytext = post.text;
				if (mytext == undefined)
					mytext = "什么都没留下...";
				else
					if (mytext.length > 50)
						mytext = post.text.substr(0, 50) + '...';
				if (post.title == undefined)
					mytitle = "无题";
				else
					mytitle = post.title;
				posts.push({
				  id: i,
				  title: mytitle,
				  text: mytext,
				  author: post.author
				});
		  }
		  res.json({
			posts: posts
		  });
	});
};

exports.post = function (req, res) {
	var id = req.params.id;
	fs.readFile("data/data.txt", 'utf-8', function (error, data) {
		if (error) throw error;
			data = JSON.parse(data);
		if (id >= 0 && id < data.posts.length) {
			res.json({
			post: data.posts[id]
			});
				} else {
			res.json(false);
			}
	});
};

// POST

exports.addPost = function (req, res) {
	fs.readFile("data/data.txt", 'utf-8', function (error, data) {	
		if (error) throw error;
		data = JSON.parse(data);
		var name, title, text;
		if (req.session.user == undefined) {
			name = "匿名网友";
			if (req.body.title == undefined) {
				title = "无题";
				req.body.title = title;
			}	
			if (req.body.text == undefined) {
				text = "什么都没留下...";
				req.body.text  = text ;
			}
		} else
			name = req.session.user.username;
		var time = moment().format("YYYY-MM-DD HH:mm:ss");
		req.body.author = name+"  \t  "+time;
		data.posts.push(req.body);
		fs.writeFile("data/data.txt", JSON.stringify(data),  function (error) {
			if (error) throw error;
			res.json(req.body);
		})
	});
};

// PUT

exports.editPost = function (req, res) {
  var id = req.params.id;
	fs.readFile("data/data.txt", 'utf-8', function (error, data) {
			if (error) throw error;
			data = JSON.parse(data);		
		  if (id >= 0 && id < data.posts.length) {
			data.posts[id] = req.body;		
			fs.writeFile("data/data.txt", JSON.stringify(data),  function (error) {
				if (error) throw error;
				res.json(true);
			})			
		  } else {
			fs.writeFile("data/data.txt", JSON.stringify(data),  function (error) {
				if (error) throw error;
				res.json(false);
			})		
		  }	
	});
};

// DELETE

exports.deletePost = function (req, res) {
  var id = req.params.id;
	fs.readFile("data/data.txt", 'utf-8', function (error, data) {	
		if (error) throw error;
		data = JSON.parse(data);
		  if (id >= 0 && id < data.posts.length) {
			data.posts.splice(id, 1);
			fs.writeFile("data/data.txt", JSON.stringify(data),  function (error) {
				if (error) throw error;
				res.json(true);
			})	
		  } else {
			fs.writeFile("data/data.txt", JSON.stringify(data),  function (error) {
				if (error) throw error;
				res.json(false);
			})	
		  }
  	});
};