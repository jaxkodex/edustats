define(['routers/index', 'controllers/index',
        'routers/config', 'controllers/config',
        'collections/InstitucionEducativa',
        'jquery', 'jqueryui'],
function (IndexRouter, indexController,
		ConfigRouter, configController,
		InstitucionEducativaCollection,
		$) {
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
      
      $.datepicker.setDefaults({
    		closeText: "Cerrar",
    		prevText: "&#x3C;Ant",
    		nextText: "Sig&#x3E;",
    		currentText: "Hoy",
    		monthNames: [ "enero","febrero","marzo","abril","mayo","junio",
    		"julio","agosto","septiembre","octubre","noviembre","diciembre" ],
    		monthNamesShort: [ "ene","feb","mar","abr","may","jun",
    		"jul","ago","sep","oct","nov","dic" ],
    		dayNames: [ "domingo","lunes","martes","miércoles","jueves","viernes","sábado" ],
    		dayNamesShort: [ "dom","lun","mar","mié","jue","vie","sáb" ],
    		dayNamesMin: [ "D","L","M","X","J","V","S" ],
    		weekHeader: "Sm",
    		dateFormat: "dd/mm/yy",
    		firstDay: 1,
    		isRTL: false,
    		showMonthAfterYear: false,
    		yearSuffix: "" });
    },
    ies: ies,
    ieCollection: new InstitucionEducativaCollection(ies),
    currentIe: ies.length ? ies[0] : null
  };
});
