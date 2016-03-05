define(['backbone'], function (Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idInstitucionEducativa',
		defaults: {
			nuInstitucionEducativa: 0,
			noInstitucionEducativa: ''
		}
	});
});