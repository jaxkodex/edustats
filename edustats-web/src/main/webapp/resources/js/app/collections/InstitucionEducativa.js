define(['backbone', 'models/InstitucionEducativa'], function (Backbone, InstitucionEducativa) {
	return Backbone.Collection.extend({
		url: baseUrl+'/api/ie',
		model: InstitucionEducativa
	});
});