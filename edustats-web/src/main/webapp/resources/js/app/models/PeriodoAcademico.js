define(['backbone', 'moment'], function (Backbone, moment) {
	return Backbone.Model.extend({
		idAttribute: 'idPeriodoAcademico',
		defaults: {
			coPeriodoAcademico: '',
			feInicio: (new Date()).getTime(),
			feFin: '',
			feCierre: ''
		}
	});
});