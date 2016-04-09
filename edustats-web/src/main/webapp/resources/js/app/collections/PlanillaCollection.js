/**
 * Created by Jorge on 05/04/2016.
 */
define(['backbone', 'models/Planilla'], function (Backbone, Planilla) {
    return Backbone.Collection.extend(
        {
            initialize: function(models, options) {
                this.idPeriodoAcademico = options.idPeriodoAcademico;
            },
            url: function () {
                return baseUrl + '/api/periodoAcademico/' +this.idPeriodoAcademico+ '/docente'
            },
            model: Planilla//,
            // modelId: function (attrs) {
            //     return 'idPeriodoAcademico:'+attrs.idPeriodoAcademico+',idTrabajador:'+attrs.trabajador.idTrabajador;
            // }
        }
    );
});
