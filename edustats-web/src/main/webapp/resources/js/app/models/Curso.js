/**
 * Created by Jorge on 07/04/2016.
 */
define(['backbone'], function (Backbone) {
    return Backbone.Model.extend(
        {
            defaults: {
                deCurso: '',
                grado: {}
            }
        }
    );
});