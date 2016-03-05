define(['marionette', 'tpl!templates/ielist.html', 'tpl!templates/ielistitem.html'], 
		function (Marionette, IEListTemplate, IEListItemTemplate) {
	var ItemView = Marionette.ItemView.extend({
		tagName: 'tr',
		template: IEListItemTemplate
	});
	
	return Marionette.CompositeView.extend({
		childView: ItemView,
		template: IEListTemplate,
		childViewContainer: 'tbody'
	});
});