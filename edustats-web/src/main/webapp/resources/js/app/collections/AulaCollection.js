/**
 * Created by Jorge on 08/04/2016.
 */
define(['backbone', 'models/Aula'], function (Backbone, Aula) {
    return Backbone.Collection.extend(
        {
            model: Aula,
            url: baseUrl+'/api/aula'
        }
    );
});