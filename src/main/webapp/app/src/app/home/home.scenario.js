describe('Home', function() {
  it('Home buttons should be present', function() {
    browser.get('/princess/app/index.html');

    element(by.model('credentials.name')).sendKeys('admin');
    
    element(by.model('credentials.password')).sendKeys('password');
    
    var loginButton = element(by.css('[value="Login"]'));
    
    loginButton.click();
    
    //expect(element(by.css('#pageTitle'))).toBe('This is the home page.');
  
  });
});
