define([ 'app', 'underscore', 
         'views/InstitucionEducativaListView', 'views/InstitucionEducativaFormView',
		'collections/InstitucionEducativa', 'models/InstitucionEducativa' ], function(
				app, _, InstitucionEducativaListView,
				InstitucionEducativaFormView,
				InstitucionEducativaCollection, InstitucionEducativa) {
	var institucionEducativaCollection = new InstitucionEducativaCollection([]);
	return {
		listInstitucionEducativa : function() {
			var view, me;
			me = this;
			view = new InstitucionEducativaListView({
				collection: institucionEducativaCollection
			});
			institucionEducativaCollection.fetch({
				success: function () {
					app.rootView.showChildView('main', view);
				}
			});
			view.on('goto:new', function () {
				me.newInstitucionEducativaForm();
				Backbone.history.navigate('config/institucioneducativa/new/');
			});
			
			view.on('goto:edit', function (id) {
				me.editInstitucionEducativa(id);
				Backbone.history.navigate('config/institucioneducativa/edit/'+id);
			});
		},
		editInstitucionEducativa: function (id) {
			var model, me;
			me = this;
			
			model = institucionEducativaCollection.get(id);
			if (_.isUndefined(model)) {
				model = new InstitucionEducativa({
					idInstitucionEducativa: id
				});
				institucionEducativaCollection.add(model);
			}
			var view = new InstitucionEducativaFormView({
				model: model
			});
			model.fetch({
				success: function () {
					app.rootView.showChildView('main', view);
				}
			});
			
			view.on('goto:list', function () {
				me.listInstitucionEducativa();
				Backbone.history.navigate('config/institucioneducativa/');
			});
		},
		newInstitucionEducativaForm: function () {
			var model, view, me;
			me = this;
			model = new InstitucionEducativa();
			institucionEducativaCollection.add(model);
			var view = new InstitucionEducativaFormView({
				model: model
			});
			app.rootView.showChildView('main', view);
			
			view.on('goto:list', function () {
				me.listInstitucionEducativa();
				Backbone.history.navigate('config/institucioneducativa/');
			});
			
			view.on('goto:edit', function (id) {
				me.editInstitucionEducativa(id);
				Backbone.history.navigate('config/institucioneducativa/edit/'+id);
			});
		}
	};
});
