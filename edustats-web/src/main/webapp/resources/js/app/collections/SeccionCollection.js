/**
 * Created by Jorge on 08/04/2016.
 */
define(['backbone', 'models/Seccion'], function (Backbone, Seccion) {
    return Backbone.Collection.extend(
        {
            model: Seccion,
            url: baseUrl+'/api/seccion'
        }
    );
})
