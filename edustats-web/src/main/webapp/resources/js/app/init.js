define(['routers/index', 'controllers/index',
        'routers/config', 'controllers/config'],
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
    }
  };
});
