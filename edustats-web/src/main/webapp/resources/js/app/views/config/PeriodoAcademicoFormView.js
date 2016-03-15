define(['app', 'marionette', 'tpl!templates/config/periodoacademicoform.html', 'moment'], function (app, Marionette, periodoAcademicoFormTemplate, moment) {
	return Marionette.ItemView.extend({
		template: periodoAcademicoFormTemplate,
		onRender: function () {
			this.$('.date').datepicker();
		},
		templateHelpers: function () {
			return {
				isNew: this.model.isNew(),
				moment: moment
			};
		},
		events: {
			'click .btn-save': 'guardar',
			'click .btn-cancel': 'cancelar'
		},
		guardar: function (evt) {
			evt.preventDefault();
			var obj, me, isNew;
			me = this;
			isNew = this.model.isNew();
			obj = {
					coPeriodoAcademico: this.$('input[name=coPeriodoAcademico]').val(),
					feInicio: moment(this.$('input[name=feInicio]').val(), 'DD/MM/YYYY').toDate().getTime(),
					institucionEducativa: app.currentIe
			};
			console.log(obj);
			this.model.save(obj, {
				success: function () {
					if (isNew) {
						me.trigger('goto:edit', me.model.id)
					}
				}
			});
		},
		cancelar: function (evt) {
			evt.preventDefault();
			this.trigger('goto:list');
		}
	});
});