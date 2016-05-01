define(['app', 'underscore', 'jquery',
        'views/InstitucionEducativaListView', 'views/InstitucionEducativaFormView',
        'views/config/PeriodoAcademicoListView', 'views/config/periodoacademico/PeriodoAcademicoFormLayout',
        'views/config/DocenteFormView',
        'collections/InstitucionEducativa', 'models/InstitucionEducativa',
        'models/PeriodoAcademico', 'collections/PeriodoAcademicoCollection',
        'models/Trabajador', 'collections/TrabajadorCollection',
        'collections/CursoCollection', 'collections/SeccionCollection',
        'collections/GradoCollection'],
       function (app, _, $, InstitucionEducativaListView,
                 InstitucionEducativaFormView,
                 PeriodoAcademicoListView,
                 PeriodoAcademicoFormLayout,
                 DocenteFormView,
                 InstitucionEducativaCollection,
                 InstitucionEducativa,
                 PeriodoAcademico, PeriodoAcademicoCollection,
                 Trabajador, TrabajadorCollection,
                 CursoCollection, SeccionCollection, GradoCollection) {
           var institucionEducativaCollection = new InstitucionEducativaCollection([]);
           var periodoAcademicoCollection = new PeriodoAcademicoCollection([]);
           var trabajadorCollection = new TrabajadorCollection([]);
           var cursoCollection = new CursoCollection([]);
           var seccionCollection = new SeccionCollection([]);
           var gradoCollection = new GradoCollection();

           return {
               listInstitucionEducativa: function () {
                   var view, me;
                   me = this;
                   view = new InstitucionEducativaListView({
                       collection: institucionEducativaCollection
                   });
                   institucionEducativaCollection.fetch(
                       {
                           success: function () {
                               app.rootView.showChildView('main',
                                                          view);
                           }
                       }
                   );
                   view.on('goto:new', function () {
                       me.newInstitucionEducativaForm();
                       Backbone.history.navigate('config/institucioneducativa/new/');
                   });

                   view.on('goto:edit', function (id) {
                       me.editInstitucionEducativa(id);
                       Backbone.history.navigate('config/institucioneducativa/edit/' + id);
                   });
               },
               editInstitucionEducativa: function (id) {
                   var model, me;
                   me = this;

                   model = institucionEducativaCollection.get(id);
                   if (_.isUndefined(model)) {
                       model = new InstitucionEducativa({
                           idInstitucionEducativa: id
                       });
                       institucionEducativaCollection.add(model);
                   }
                   var view = new InstitucionEducativaFormView({
                       model: model
                   });
                   model.fetch({
                                   success: function () {
                                       app.rootView.showChildView('main', view);
                                   }
                               });

                   view.on('goto:list', function () {
                       me.listInstitucionEducativa();
                       Backbone.history.navigate('config/institucioneducativa/');
                   });
               },
               newInstitucionEducativaForm: function () {
                   var model, view, me;
                   me = this;
                   model = new InstitucionEducativa();
                   institucionEducativaCollection.add(model);
                   var view = new InstitucionEducativaFormView({
                       model: model
                   });
                   app.rootView.showChildView('main', view);

                   view.on('goto:list', function () {
                       me.listInstitucionEducativa();
                       Backbone.history.navigate('config/institucioneducativa/');
                   });

                   view.on('goto:edit', function (id) {
                       me.editInstitucionEducativa(id);
                       Backbone.history.navigate('config/institucioneducativa/edit/' + id);
                   });
               },

               showPeriodoAcademicoListView: function () {
                   var me, view;
                   me = this;
                   view = new PeriodoAcademicoListView({
                       collection: periodoAcademicoCollection
                   });
                   periodoAcademicoCollection.fetch(
                       {
                           data: {
                               idInstitucionEducativa: app.currentIe.idInstitucionEducativa
                           },
                           success: function () {
                               if (periodoAcademicoCollection.isEmpty()) {
                                   me.showPeriodoAcademicoNewFormView();
                                   Backbone.history.navigate(
                                       'config/periodoacademico/new/');
                               } else {
                                   app.rootView.showChildView('main',
                                                              view);
                               }
                           }
                       }
                   );

                   view.on('goto:edit', function (id) {
                       me.showPeriodoAcademicoEditFormView(id);
                       Backbone.history.navigate('config/periodoacademico/edit/' + id);
                   });
               },
               showPeriodoAcademicoNewFormView: function () {
                   var model, me, view;
                   me = this;
                   model = new PeriodoAcademico();
                   periodoAcademicoCollection.add(model);
                   view = new PeriodoAcademicoFormLayout({
                       model: model
                   });
                   app.rootView.showChildView('main', view);

                   view.on('goto:edit', function (id) {
                       me.showPeriodoAcademicoEditFormView(id);
                       Backbone.history.navigate('config/periodoacademico/edit/' + id);
                   });

                   view.on('goto:list', function () {
                       me.showPeriodoAcademicoListView();
                       Backbone.history.navigate('config/periodoacademico/');
                   });
               },
               showPeriodoAcademicoEditFormView: function (id) {
                   var model, me, view;
                   me = this;
                   model = periodoAcademicoCollection.get(id);
                   if (_.isUndefined(model)) {
                       model = new PeriodoAcademico({
                           idPeriodoAcademico: id
                       });
                       periodoAcademicoCollection.add(model);
                   }
                   view = new PeriodoAcademicoFormLayout({
                       model: model,
                       cursoCollection: cursoCollection,
                       seccionCollection: seccionCollection,
                       gradoCollection: gradoCollection
                   });
                   var complete = _.invoke([model, cursoCollection, seccionCollection, gradoCollection], 'fetch');
                   $.when.apply($, complete).done(function () {
                       app.rootView.showChildView('main', view);
                   });

                   view.on('goto:list', function () {
                       me.showPeriodoAcademicoListView();
                       Backbone.history.navigate('config/periodoacademico/');
                   });
               },

               showPeriodoAcademicoDocenteNewFormView: function (idPeriodoAcademico) {
                   var me, view;
                   me = this;
                   view = new DocenteFormView({
                       model: new Trabajador,
                       idPeriodoAcademico: idPeriodoAcademico
                   });
                   app.rootView.showChildView('main', view);
               }
           };
       });
