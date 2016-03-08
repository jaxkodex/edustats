define(['marionette'], function(Marionette) {
	return Marionette.AppRouter.extend({
		appRoutes : {
			'config/institucioneducativa/' : 'listInstitucionEducativa',
			'config/institucioneducativa/new/' : 'newInstitucionEducativaForm',
			'config/institucioneducativa/edit/:id' : 'editInstitucionEducativa'
		}
	});
});