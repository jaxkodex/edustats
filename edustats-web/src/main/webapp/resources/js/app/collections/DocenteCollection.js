/**
 * Created by Jorge on 05/04/2016.
 */
define(['backbone', 'models/Trabajador'],
       function (Backbone, Trabajador) {
           return Backbone.Collection.extend(
               {
                   model: Trabajador,
                   url: baseUrl+'/api/docente'
               }
           );
       }
);
