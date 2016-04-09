/**
 * Created by Jorge on 08/04/2016.
 */
define(['backbone'], function (Backbone) {
    return Backbone.Model.extend(
        {
            idAttribute: 'coSeccion',
            defaults: {
                deSeccion: ''
            }
        }
    );
});
