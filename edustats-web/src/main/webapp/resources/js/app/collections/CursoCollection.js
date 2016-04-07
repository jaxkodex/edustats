/**
 * Created by Jorge on 07/04/2016.
 */
define(['backbone', 'models/Curso'], function (Backbone, Curso) {
    return Backbone.Collection.extend(
        {
            model: Curso,
            url: baseUrl + '/api/curso'
        }
    );
});