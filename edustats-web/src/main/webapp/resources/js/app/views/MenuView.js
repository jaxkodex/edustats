define(['underscore', 'backbone', 'marionette', 'tpl!templates/menu.html'],
function (_, Backbone, Marionette, menuTemplate) {
  return Marionette.ItemView.extend({
    template: menuTemplate,
    templateHelpers: function () {
    	var menuArray = [];
    	var menuMap = {};
    	var existingMenuMap = {};
    	_.each(userData.roles, function (rol) {
    		_.each(rol.opciones, function (opcion) {
    			if (_.isNull(opcion.opcionPadre) && _.isUndefined(menuMap[opcion.idOpcion])) {
    				menuMap[opcion.idOpcion] = opcion;
    				menuMap[opcion.idOpcion]['hijas'] = [];
    			} else if (!_.isNull(opcion.opcionPadre)) {
    				var opcionPadre = opcion.opcionPadre;
    				if (_.isUndefined(menuMap[opcionPadre.idOpcion])) {
        				menuMap[opcionPadre.idOpcion] = opcionPadre;
        				menuMap[opcionPadre.idOpcion]['hijas'] = [];
    				}
    				if (_.isUndefined(existingMenuMap[opcion.idOpcion])) {
    					menuMap[opcionPadre.idOpcion]['hijas'].push(opcion);
    					existingMenuMap[opcion.idOpcion] = opcion;
    				}
    			}
    		});
    	});
    	_.each(menuMap, function (menuItem) {
    		menuArray.push(menuItem);
    	});
    	return {
    		menuArray: menuArray
    	};
    },
    onRender: function () {
      this.$('#menu-ul').metisMenu();
    }
  });
});
