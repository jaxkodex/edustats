/**
 * Created by Jorge on 07/04/2016.
 */
define(['backbone', 'models/AsignacionDocente'], function (Backbone, AsignacionDocente) {
    return Backbone.Collection.extend(
        {
            model: AsignacionDocente
        }
    );
});