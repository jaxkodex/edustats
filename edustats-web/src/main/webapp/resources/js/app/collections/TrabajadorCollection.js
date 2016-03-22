define(['backbone', 'models/Trabajador'], function (Backbone, Trabajador) {
	return Backbone.Collection.extend({
		url: baseUrl+ '/api/trabajador',
		model: Trabajador
	});
});