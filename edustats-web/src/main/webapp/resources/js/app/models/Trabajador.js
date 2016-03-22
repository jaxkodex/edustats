define(['backbone'], function (Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idTrabajador',
		defaults: {
			persona: {
				tipoDocumento: {}
			}
		}
	});
});