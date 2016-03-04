define(['marionette', 'tpl!templates/top.html', 'jquery'], function (Marionette, topTemplate, $) {
  return Marionette.ItemView.extend({
    className: 'col-sm-12',
    template: topTemplate,
    templateHelpers: function () {
    	return userData;
    },
    events: {
      'click #menu-toggler': 'onClickMenuToggler'
    },
    onClickMenuToggler: function (evt) {
      evt.preventDefault();
      $("#wrapper").toggleClass("toggled");
    }
  });
});
