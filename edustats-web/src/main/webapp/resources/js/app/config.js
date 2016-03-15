require.config({
	shim : {
		underscore : {
			exports : '_'
		},
		metis : {
			deps : [ 'jquery' ]
		},
		backbone : {
			deps : [ 'underscore', 'jquery' ],
			exports : 'Backbone'
		},
		bootstrap : {
			deps : [ 'jquery' ],
			exports : '$.fn.popover'
		},
		marionette : {
			deps : [ 'jquery', 'underscore', 'backbone' ],
			exports : 'Marionette'
		},
		jqueryui: {
			deps: [ 'jquery' ]
		}
	},
	paths : {
		jquery : '../libs/jquery-1.12.0',
		jqueryui : '../libs/jquery-ui',
		underscore : '../libs/underscore',
		backbone : '../libs/backbone',
		bootstrap : '../libs/bootstrap',
		marionette : '../libs/backbone.marionette',
		tpl : '../libs/tpl',
		metis: '../libs/metisMenu',
		moment: '../libs/moment-with-locales'
	},
	urlArgs : "bust=" + (new Date()).getTime()
});

require([ 'app', 'views/AppLayout', 'views/MenuView', 'views/TopView',
'init', 'backbone', 'underscore', 'bootstrap', 'metis', 'jquery', 'jqueryui' ],
function(app, AppLayout, MenuView, TopView, init, Backbone, _) {
	app.on('start', function() {
		app.rootView = new AppLayout;

		init.initialize();
		
		app.ies = init.ies;
		app.ieCollection = init.ieCollection;
		app.currentIe = init.currentIe;

		app.rootView.showChildView('menu', new MenuView);
		app.rootView.showChildView('top', new TopView);
		$('.loading-holder').fadeOut(500);
		Backbone.history.start();
	});
	app.start();
	$(document).ajaxStart(function () {
	  $('.loading-holder').stop().fadeIn(300);
	}).ajaxStop(function () {
	  $('.loading-holder').stop().fadeOut(500);
	});
});
