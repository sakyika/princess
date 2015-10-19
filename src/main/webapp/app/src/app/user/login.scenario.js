
var loginPage = require('./login.page');

describe('Login page', function() {
	it('Should be able to login and get to home page', function() {
		loginPage.signIn('admin', 'password');
	});
});