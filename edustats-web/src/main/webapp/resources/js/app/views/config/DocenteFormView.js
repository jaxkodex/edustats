define(['marionette', 'tpl!templates/config/docenteform.html'], function (Marionette, docenteFormTemplate) {
	return Marionette.ItemView.extend({
		template: docenteFormTemplate
	});
});