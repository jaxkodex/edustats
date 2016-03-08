define(['marionette', 'tpl!templates/ieform.html'], 
		function (Marionette, IEFormTemplate) {
	
	return Marionette.ItemView.extend({
		template: IEFormTemplate,
		events: {
			'click .cancel': 'gotoBackToListView',
			'click .guardar': 'guardar'
		},
		gotoBackToListView: function (evt) {
			evt.preventDefault();
			this.trigger('goto:list');
		},
		guardar: function (evt) {
			evt.preventDefault();
			var obj, me;
			me = this;
			
			this.$('.form-group').removeClass('has-warning');
			this.$('.form-group .help-block').text('');
			
			obj = {
					noInstitucionEducativa: this.$('input[name=noInstitucionEducativa]').val().trim(),
					nuInstitucionEducativa: this.$('input[name=nuInstitucionEducativa]').val().trim(),
			};
			this.model.save(obj, {
				success: function () {
					alert('Registro exitoso!');
					me.trigger('goto:edit', me.model.id);
				},
				error: function (model, response, options) {
					if (response.status == 422) {
						me.onInvalidModel(me.model, response.responseJSON.errors, {});
					}
				}
			});
		},
		onInvalidModel: function (model, error, options) {
			var me = this;
			_.each(error, function (v) {
				var e = me.$('input[name='+v.attribute+']');
				e.closest('.form-group').addClass('has-warning');
				e.closest('.form-group').find('.help-block').text(v.error);
			});
		}
	});
});