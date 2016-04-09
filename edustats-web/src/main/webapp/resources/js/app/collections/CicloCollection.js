/**
 * Created by Jorge on 08/04/2016.
 */
define(['backbone', 'models/Ciclo'], function (Backbone, Ciclo) {
    return Backbone.Collection.extend(
        {
            model: Ciclo,
            url: baseUrl+'/api/ciclo'
        }
    );
});