/**
 * Tests sit right alongside the file they are testing, which is more intuitive
 * and portable than separating `src` and `test` directories. Additionally, the
 * build process will exclude all `.spec.js` files from the build
 * automatically.
 */
describe( 'home section', function() {
  beforeEach( module( 'princess.home' ) );

  it( 'should have a dummy test', inject( function() {
    expect( true ).toBeTruthy();
  }));
});

/*

describe( 'HomeCtrl ', function() {
	
	var HomeCtrl, $scope;
	
	beforeEach( module( 'princess.home' ) );
	
	beforeEach(inject(function($controller, $rootScope){
		
		var appScope = $rootScope.$new();
		
		$controller('AppCtrl', {$scope:appScope});
		
		var homeScope = appScope.$new();
		
		$controller('HomeCtrl', {$scope:homeScope});
		
	}));
	
	it('It should have buttons on the side', )
	
});

*/