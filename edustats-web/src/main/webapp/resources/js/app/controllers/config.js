define([ 'app', 'underscore', 'views/InstitucionEducativaListView',
		'collections/InstitucionEducativa', 'models/InstitucionEducativa' ], function(
				app, _, InstitucionEducativaListView, InstitucionEducativaCollection, InstitucionEducativaModel) {
	var institucionEducativaCollection = new InstitucionEducativaCollection([]);
	return {
		listInstitucionEducativa : function() {
			var view = new InstitucionEducativaListView({
				collection: institucionEducativaCollection
			});
			institucionEducativaCollection.fetch({
				success: function () {
					app.rootView.showChildView('main', view);
				}
			});
		},
		editInstitucionEducativa: function (id) {
			var model = institucionEducativaCollection.get(id);
			if (_.isUndefined(model)) {
				model = new InstitucionEducativaModel({
					idInstitucionEducativa: id
				});
				institucionEducativaCollection.add(model);
			}
			model.fetch({
				success: function () {
					alert('go edit!');
				}
			});
		},
		newInstitucionEducativaForm: function () {
			
		}
	};
});
