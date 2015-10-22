angular.module( 'princess.user', [
	'ui.router',
	'placeholders',
	'ui.bootstrap',
	'ngResource'
])

.config(function config($stateProvider){
	
	$stateProvider.state( 'app.login', {
		url: '/login',
		views: {
			"main": {
				controller: 'LoginCtrl',
				templateUrl: 'user/login.tpl.html'
			}
		},
		ncyBreadcrumb : {
			label : 'Login',
			description : ''
		},
		data: {pageTitle: 'Login' }
	})
	.state( 'app.register', {
		url: '/register',
		views: {
			"main": {
				controler: 'RegisterCtrl',
				templateUrl: 'user/register.tpl.html'
			}
		},
		ncyBreadcrumb : {
			label : 'Register',
			description : ''
		},
		data: { pageTitle: 'Register'}
	});
})

.factory('sessionService', function($rootScope, $http, $location){
	
	var session = {};
	
	session.credentials = {};

/*
	session.logged = function(){
		$http.get('/user', )
	};
*/


	session.authenticate = function(credentials, callback){
		
		var headers = {'Authorization': "Basic " + btoa(credentials.name + ":" + credentials.password)};
		
		$http.get('/user', {
			headers : headers
		}).success(function(data){
			if(data.name){
				$rootScope.authenticated = true;
				console.log("$rootScope.authenticated: " + $rootScope.authenticated);
			}else{
				$rootScope.authenticated = false;
				console.log("session.authenticated =  false");
			}
			callback();
		}).error(function(){
			$rootScope.authenticated = false;
			console.log("session.authenticated =  false");
			callback(); 
		});
		
	};
	
	session.login = function(credentials){
		
		session.authenticate(credentials, function(){
			
			if($rootScope.authenticated){
				console.log("Login suceeded");
				$location.path("/home");
				session.error = false;
				console.log("session.error: " + session.error);
				$rootScope.authenticated = true;
			}else{
				console.log("Login failed");
				$location.path("/login");
				$rootScope.error = true;
				console.log("session.error: " + session.error);
				$rootScope.authenticated = false;
			}
			
		});
		
	};
	
	session.logout = function(){
		
		$http.post('/logout', {}).success(function(){
			
			$rootScope.authenticated = false;
			$location.path("/login");
			console.log("Logout successful");
		}).error(function(data){
			
			console.log("Logout failed");
			$rootScope.authenticated = false;
			
		});
	
	};	
	
	return session;

})

.controller('LoginCtrl', function LoginCtrl($scope, $rootScope, $state, sessionService){
	
	$rootScope.login = function(){
		sessionService.login($rootScope.credentials);
		$rootScope.credentials = {};
	};
	
	$rootScope.logout = function(){
		sessionService.logout();
	};
	
})

.controller('RegisterCtrl', function RegisterCtrl($scope, $state, sessionService){
	
});