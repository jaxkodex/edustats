/**
 * Created by Jorge on 08/04/2016.
 */
define(['backbone', 'models/Grado'], function (Backbone, Grado) {
    return Backbone.Collection.extend(
        {
            model: Grado,
            url: baseUrl + '/api/grado'
        }
    );
});
