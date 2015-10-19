angular.module( 'princess', [
	'templates-app',
	'templates-common',
	'princess.home',
	'princess.about',
	'princess.user',
	'princess.profile',
	'princess.patients',
	'ngAnimate',
	'ngCookies',
	'ngResource',
	'ngSanitize',
	'ngTouch',
	'ngStorage',
	'ui.router',
	'ncy-angular-breadcrumb',
	'ui.bootstrap',
/*	'ui.utils',	*/
	'ngResource',
	'oc.lazyLoad',
	'ui.grid',
	'hateoas',
	'angular-hal'
])

.config( function myAppConfig ( $stateProvider, $urlRouterProvider, $breadcrumbProvider, $ocLazyLoadProvider, $httpProvider, $rootScopeProvider ) {
	
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
	
	$urlRouterProvider.otherwise( '/login' );
  
	$stateProvider.state('app', {
		abstract: true,
		views : {
			"main" : {
				templateUrl : 'core/layout.tpl.html',
				controller : 'AppCtrl'
			}
		},
		data:{ pageTitle: 'App', authenticated: false }
	});
	
	
	$breadcrumbProvider.setOptions({
        template: '<ul class="breadcrumb"><li><i class="fa fa-home"></i><a href="#">Home</a></li><li ng-repeat="step in steps" ng-class="{active: $last}" ng-switch="$last || !!step.abstract"><a ng-switch-when="false" href="{{step.ncyBreadcrumbLink}}">{{step.ncyBreadcrumbLabel}}</a><span ng-switch-when="true">{{step.ncyBreadcrumbLabel}}</span></li></ul>'
    });
	
	
	$ocLazyLoadProvider.config({
        debug: true,
        events: true,
        modules: [
            {
                name: 'toaster',
                files: [
                    'assets/lib/modules/angularjs-toaster/toaster.css',
                    'assets/lib/modules/angularjs-toaster/toaster.js'
                ]
            },
            {
                name: 'ui.select',
                files: [
                    'assets/lib/modules/angular-ui-select/select.css',
                    'assets/lib/modules/angular-ui-select/select.js'
                ]
            },
            {
                name: 'ngTagsInput',
                files: [
                    'assets/lib/modules/ng-tags-input/ng-tags-input.js'
                ]
            },
            {
                name: 'daterangepicker',
                files: [
                    'assets/lib/modules/angular-daterangepicker/moment.js',
                    'assets/lib/modules/angular-daterangepicker/daterangepicker.js',
                    'assets/lib/modules/angular-daterangepicker/angular-daterangepicker.js'
                ]
            },
            {
                name: 'vr.directives.slider',
                files: [
                    'assets/lib/modules/angular-slider/angular-slider.min.js'
                ]
            },
            {
                name: 'minicolors',
                files: [
                    'assets/lib/modules/angular-minicolors/jquery.minicolors.js',
                    'assets/lib/modules/angular-minicolors/angular-minicolors.js'
                ]
            },
            {
                name: 'textAngular',
                files: [
                    'assets/lib/modules/text-angular/textAngular-sanitize.min.js',
                    'assets/lib/modules/text-angular/textAngular-rangy.min.js',
                    'assets/lib/modules/text-angular/textAngular.min.js'
                ]
            },
            {
                name: 'ng-nestable',
                files: [
                    'assets/lib/modules/angular-nestable/jquery.nestable.js',
                    'assets/lib/modules/angular-nestable/angular-nestable.js'
                ]
            },
            {
                name: 'angularBootstrapNavTree',
                files: [
                    'assets/lib/modules/angular-bootstrap-nav-tree/abn_tree_directive.js'
                ]
            },
            {
                name: 'ui.calendar',
                files: [
                    'assets/lib/jquery/jquery-ui-1.10.4.custom.js',
                    'assets/lib/modules/angular-daterangepicker/moment.js',
                    'assets/lib/jquery/fullcalendar/fullcalendar.js',
                    'assets/lib/modules/angular-ui-calendar/calendar.js'
                ]
            },
            {
                name: 'ngGrid',
                files: [
                    'assets/lib/modules/ng-grid/ng-grid.min.js',
                    'assets/lib/modules/ng-grid/ng-grid.css'
                ]
            }
        ]
    });
  
})

.run( function run ($rootScope, $state, $stateParams) {
	$rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;  
    $rootScope.authenticated = false;
})

.controller( 'AppCtrl', function AppCtrl ( $rootScope, $location, $localStorage, $state, sessionService) {

	$rootScope.credentials = {};
	//$rootScope.authenticated = false;
	
	$rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
		if ( angular.isDefined( toState.data.pageTitle ) ) {
			$rootScope.pageTitle = toState.data.pageTitle + ' | princess' ;
		}
	});
	
	
	$rootScope.settings = {
            skin: '',
            color: {
                themeprimary: '#2dc3e8',
                themesecondary: '#fb6e52',
                themethirdcolor: '#ffce55',
                themefourthcolor: '#a0d468',
                themefifthcolor: '#e75b8d'
            },
            rtl: false,
            fixed: {
                navbar: false,
                sidebar: false,
                breadcrumbs: false,
                header: false
            }
        };
	
	
	if (angular.isDefined($localStorage.settings)){
		$rootScope.settings = $localStorage.settings;
	}
    else {
        $localStorage.settings = $rootScope.settings;
    }
	
	$rootScope.$watch('settings', function() {
		if ($rootScope.settings.fixed.header) {
			$rootScope.settings.fixed.navbar = true;
            $rootScope.settings.fixed.sidebar = true;
            $rootScope.settings.fixed.breadcrumbs = true;
        }
        if ($rootScope.settings.fixed.breadcrumbs) {
            $rootScope.settings.fixed.navbar = true;
            $rootScope.settings.fixed.sidebar = true;
        }
        if ($rootScope.settings.fixed.sidebar){
            $rootScope.settings.fixed.navbar = true;
        }
        
        $localStorage.settings = $rootScope.settings;
	}, true);
	
	
	$rootScope.$watch('settings.rtl', function () {
		if ($state.current.name != "persian.dashboard" && $state.current.name != "arabic.dashboard") {
			switchClasses("pull-right", "pull-left");
            switchClasses("databox-right", "databox-left");
            switchClasses("item-right", "item-left");
        }

        $localStorage.settings = $rootScope.settings;
    }, true);
	
	$rootScope.$on('$viewContentLoaded',
		function (event, toState, toParams, fromState, fromParams) {
			if ($rootScope.settings.rtl && $state.current.name != "persian.dashboard" && $state.current.name != "arabic.dashboard") {
				switchClasses("pull-right", "pull-left");
				switchClasses("databox-right", "databox-left");
				switchClasses("item-right", "item-left");
			}
			if ($state.current.name == 'error404') {
				$('body').addClass('body-404');
			}
			if ($state.current.name == 'error500') {
				$('body').addClass('body-500');
			}
	});
	
	
});

