
var Injector = {
	
	//容器组，里面包含可能需要依赖的服务对象
   container: {},
	
	//把依赖的实例加入容器组
   add : function(index, obj){
      this.container[index] = obj; 
   },
	
	//获取依赖并注入生成目标方法实例后返回
   get : function(func){
      var obj = {};
      var dependencies = this.resolveDependencies(func);
      func.apply(obj, dependencies);
      return obj;
   },
	
	//根据参数从容器组中获得依赖
   resolveDependencies : function(func) {
      var args = this.getArguments(func);
      var dependencies = [];
      for ( var i = 0; i < args.length; i++) {
         dependencies.push(this.container[args[i]]);
      }
      return dependencies;
   },
	
	//获得参数的方法
   getArguments : function(func) {
      var FN_ARGS = /^function\s*[^\(]*\(\s*([^\)]*)\)/m;
      var args = func.toString().match(FN_ARGS)[1].split(',');
      return args;
   }
};