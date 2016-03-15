define(['backbone', 'models/PeriodoAcademico'], function (Backbone, PeriodoAcademico) {
	return Backbone.Collection.extend({
		model: PeriodoAcademico,
		url: baseUrl+'/api/periodoAcademico'
	});
});