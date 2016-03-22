define(['marionette', 'tpl!templates/config/periodoacademicolist.html', 
        'tpl!templates/config/periodoacademicoitemlist.html', 
        'underscore', 'moment'], function (Marionette, periodoAcademicoListTemplate, periodoAcademicoItemListTemplate, _,  moment) {
	var ChildView = Marionette.ItemView.extend({
		tagName: 'tr',
		template: periodoAcademicoItemListTemplate,
		templateHelpers: function () {
			return {
				moment: moment
			}
		},
		events: {
			'click .btn-edit': 'gotoEdit'
		},
		gotoEdit: function (evt) {
			evt.preventDefault();
			this.model.collection.trigger('goto:edit', this.model.id);
		}
	});
	
	return Marionette.CompositeView.extend({
		template: periodoAcademicoListTemplate,
		childView: ChildView,
		childViewContainer: 'tbody',
		collectionEvents: {
			'goto:edit': 'gotoEdit'
		},
		gotoEdit: function (id) {
			this.trigger('goto:edit', id);
		}
	});
});