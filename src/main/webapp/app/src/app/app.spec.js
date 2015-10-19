describe( 'AppCtrl', function() {
	describe( 'isCurrentUrl', function() {
		var AppCtrl, $location, $scope, $state, $localStorage;

		beforeEach( module( 'princess' ) );

		beforeEach( inject( function( $controller, $rootScope, _$location_, _$localStorage_, _$state_) {
			$location = _$location_;
			$scope = $rootScope.$new();
			$localStorage = _$localStorage_;
			$state = _$state_;
			AppCtrl = $controller( 'AppCtrl', { $rootScope: $scope, $location: $location, $localStorage: $localStorage, $state: $state });
		}));

		it( 'should pass a dummy test', inject( function() {
			expect( AppCtrl ).toBeTruthy();
		}));
	});
});
