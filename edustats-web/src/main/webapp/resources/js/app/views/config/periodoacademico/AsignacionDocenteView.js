/**
 * Created by Jorge on 07/04/2016.
 */
define(['marionette', 'tpl!templates/config/periodoacademico/asignaciondocente.html',
        'tpl!templates/config/periodoacademico/asignaciondocenteitem.html'],
       function (Marionette, asignacionDocenteTemplate) {
           var childView = Marionette.ItemView.extend(
               {
                   template: asignacionDocenteTemplate
               }
           );

           return Marionette.CompositeView.extend(
               {
                   template: asignacionDocenteTemplate,
                   childView: childView
               }
           );
       }
);
