angular.module( 'princess.about', [
	'ui.router',
	'placeholders',
	'ui.bootstrap'
])

.config(function config( $stateProvider ) {
	$stateProvider.state( 'app.about', {
		url: '/about',
		views: {
			"main": {
				controller: 'AboutCtrl',
				templateUrl: 'about/about.tpl.html'
			}
		},
		ncyBreadcrumb : {
			label : 'About',
			description : ''
		},
		data: { pageTitle: 'About' }
	});
})

.controller( 'AboutCtrl', function AboutCtrl( $scope ) {
	// This is simple a demo for UI Boostrap.
	$scope.dropdownDemoItems = [ 
	"The first choice!",
	"And another choice for you.",
	"but wait! A third!"
	];
  
});
