define(['marionette', 'tpl!templates/ielist.html', 'tpl!templates/ielistitem.html'], 
		function (Marionette, IEListTemplate, IEListItemTemplate) {
	var ItemView = Marionette.ItemView.extend({
		tagName: 'tr',
		template: IEListItemTemplate,
		events: {
			'click .editButton': 'gotoEditForm'
		},
		gotoEditForm: function (evt) {
			evt.preventDefault();
			this.model.collection.trigger('goto:edit', this.model.id);
		}
	});
	
	return Marionette.CompositeView.extend({
		childView: ItemView,
		template: IEListTemplate,
		childViewContainer: 'tbody',
		events: {
			'click .new': 'gotoNewForm'
		},
		collectionEvents: {
			'goto:edit': 'gotoEditForm'
		},
		gotoNewForm: function (evt) {
			evt.preventDefault();
			this.trigger('goto:new');
		},
		gotoEditForm: function (id) {
			this.trigger('goto:edit', id);
		}
	});
});