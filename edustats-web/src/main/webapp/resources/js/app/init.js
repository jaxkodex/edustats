define(['routers/index', 'controllers/index',
        'routers/config', 'controllers/config', 'jquery'],
function (IndexRouter, indexController,
		ConfigRouter, configController) {
  return {
    initialize: function () {
      new IndexRouter({
        controller: indexController
      });
      new ConfigRouter({
    	  controller: configController
      });
      
      $(document).ajaxError(function (event, jqxhr, settings, thrownError) {
    	  if (jqxhr.status == 403) {
    		  alert("No tiene permiso para acceder a esta opción.");
    	  }
      });
    }
  };
});
