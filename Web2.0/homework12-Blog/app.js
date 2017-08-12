var express = require('express');
var data_manager = require('./controllers/data_manager');
var favicon = require('serve-favicon');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var session = require('express-session');
var FileStore = require('session-file-store')(session);
var cookieSession = require("cookie-session");
var logger = require('morgan');
/**
 * Module dependencies.
 */

var routes = require('./routes'),
  api = require('./routes/api');

var app = module.exports = express.createServer();

// Configuration

app.use(session({
  store: new FileStore(),
  resave: false,
  saveUninitialized: false,
  secret: 'luguanxing',
cookie: {maxAge: 30*60*1000}
}));
  
app.configure(function(){
  app.set('views', __dirname + '/views');
  app.set('view engine', 'jade');
  app.set('view options', {
    layout: false
  });
  app.use(logger('dev'));
  app.use(express.bodyParser());
  app.use(express.methodOverride());
  app.use(express.static(__dirname + '/public'));
  app.use(express.static(__dirname + '/views'));
  app.use(app.router);

});


app.configure('development', function(){
  app.use(express.errorHandler({ dumpExceptions: true, showStack: true }));
});

app.configure('production', function(){
  app.use(express.errorHandler());
});

// Routes

app.get('/', routes.index);
app.get('/partials/:name', routes.partials);


//////////////////////////////////////////////////////////////////////////////////


app.get('/regist', function(req, res, next) {
	console.log("》》》》》》》确认req:"+req);
	console.log("》》》》》》》确认req.session:"+req.session);	
	if (req.session.user != undefined) {	//已经登录
		console.log("已登录下进入注册页面");
		data_manager.showuserinfo(req, res, req.session.user["username"], true);
	} else {
		console.log("进入注册界面");
		res.end("gg");
	}
});

app.post('/logout', function(req, res, next) {	//退出登录
	req.session.user = undefined;
	console.log("用户退出");
	res.end("成功退出");
})

app.post('/checksigin', function(req, res, next) {	//登录:检验姓名、密码正确性
	data_manager.check_signin(req.body, req, res);
});

app.post('/checksigup', function(req, res, next) {	//注册:检验姓名、学号、电话、邮箱重复性
	data_manager.check_signup(req.body, req, res);
});




/////////////////////////////////////////////////////////////////////////////////////






// JSON API

app.get('/api/posts', api.posts);

app.get('/api/post/:id', api.post);
app.post('/api/post', api.addPost);
app.put('/api/post/:id', api.editPost);
app.delete('/api/post/:id', api.deletePost);

// redirect all others to the index (HTML5 history)
app.get('*', routes.index);

// Start server

app.listen(3000, function(){
  console.log("Express server listening on port %d in %s mode", app.address().port, app.settings.env);
});
