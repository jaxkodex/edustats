({
	baseUrl : 'app',
	name : 'config',
	out : 'app.min.js',

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
		jqueryui : {
			deps : [ 'jquery' ]
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
		metis : '../libs/metisMenu',
		moment: '../libs/moment-with-locales'
	}
});