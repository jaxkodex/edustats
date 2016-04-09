/**
 * Created by Jorge on 05/04/2016.
 */
define(['backbone'], function (Backbone) {
    return Backbone.Model.extend(
        {
            idAttribute: 'idPlanilla',
            defaults: {
                trabajador: {
                    persona: {}
                }
            }
        }
    );
});