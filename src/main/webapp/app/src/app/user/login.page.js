var Page = require('astrolabe').Page;

module.exports = Page.create({
	
	url: {value: 'http://localhost:8080/princess/app/index.html#/login'},
	
	username: {get: function(){return this.findElement(this.by.model('credentials.name'));}},

	password: {get: function(){return this.findElement(this.by.model('credentials.password'));}},
	
	submit: {get: function(){return this.findElement(this.by.id('login'));}},
	
	
	InvalidLoginException: { get: function() { return this.exception('Invalid Login'); } },
	
	signIn: {value: function(name, password){
	
		var page = this;
		
		page.go();
		
		page.username.sendKeys(name);
		page.password.sendKeys(password);
		
		page.submit.click();
		
	}}

});
