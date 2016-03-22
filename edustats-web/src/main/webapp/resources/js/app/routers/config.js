define(['marionette'], function(Marionette) {
	return Marionette.AppRouter.extend({
		appRoutes : {
			'config/institucioneducativa/' : 'listInstitucionEducativa',
			'config/institucioneducativa/new/' : 'newInstitucionEducativaForm',
			'config/institucioneducativa/edit/:id' : 'editInstitucionEducativa',

			'config/periodoacademico/': 'showPeriodoAcademicoListView',
			'config/periodoacademico/new/': 'showPeriodoAcademicoNewFormView',
			'config/periodoacademico/edit/:idPeriodoAcademico': 'showPeriodoAcademicoEditFormView',
			
			'config/periodoacademico/edit/:idPeriodoAcademico/docente/new': 'showPeriodoAcademicoDocenteNewFormView'
		}
	});
});