function fn() {
	var env = karate.env; // get system property 'karate.env'
		karate.log('karate.env system property was:', env);
		
	var runwithnewuser = karate.properties['myapp.source'];
	karate.log('karate.env run with new user :', runwithnewuser);
	if (!env) {
		env = 'STG';
	}
	
	// set the global environment and global environment variables
	var config = {
		env: env,
		myVarName: 'someValue',
		baseurlconduit: 'https://api.realworld.io/api/',
		email: 'patildinesh19@hotmail.com',
		password: 'DD123@dd123',
		randomemailaddress: setrandmoemail()
		
	}
	// set the other environment and environment variables 
	if (env == 'dev') {
		config.email = 'patildinesh19@gmail.com',
		config.password = 'DD123@dd123'


	} else if (env == 'QA') {
		config.email = 'patildinesh19@yahh.com',
		config.password = 'Test@123'

	} else if (env == 'STG') {
		config.email = 'patildinesh19@hotmail.com',
		config.password = 'DD123@dd123'
	}
		if(runwithnewuser == 'N')
		{
		var accesstoken = karate.callSingle('classpath:Datadriven/login.feature', config);
		config.accesstoken1 = accesstoken.token;
		config.userdetails = accesstoken.username;
		karate.log('token details', accesstoken);
		}else if(runwithnewuser == 'Y')
		{
		var accesstoken = karate.callSingle('classpath:Datadriven/createnewuser.feature', config);
		config.accesstoken1 = accesstoken.token;
		config.userdetails = accesstoken.username;
		karate.log('token details', accesstoken);
		}
	//************function to generate random values and use those values as environment variables */

	function setrandmoemail() {
		var emailaddress = '';
		const uuid = Math.random().toString(36).substring(2, 15);
		Math.random().toString().substring(2, 15);
		const email1 = "randomemail_123" + uuid + "@gmail.com";
		var emailaddress = email1;
		return emailaddress;	
	}

	return config;
}