define(['app', 'marionette', 'tpl!templates/config/periodoacademicoformlayout.html',
        'tpl!templates/config/periodoacademicoform.html', 'tpl!templates/config/periodoacademicoplanadocente.html',
        'tpl!templates/config/periodoacademicoagregardocenteform.html',
        'collections/PlanillaCollection', 'collections/DocenteCollection',
        'moment'],
       function (app, Marionette, periodoAcademicoFormLayout,
                 periodoAcademicoFormTemplate, periodoAcademicoPlanaDocente,
                 periodoAcademicoAgregarDocenteForm,
                 PlanillaCollection, DocenteCollection, moment) {
           var PeriodoAcademicoView, PlanaDocenteView;

           PeriodoAcademicoView = Marionette.ItemView.extend(
               {
                   template: periodoAcademicoFormTemplate,
                   onRender: function () {
                       this.$('.date').datepicker();
                   },
                   templateHelpers: function () {
                       return {
                           isNew: this.model.isNew(),
                           moment: moment
                       };
                   },
                   events: {
                       'click .btn-save': 'guardar',
                       'click .btn-cancel': 'cancelar'
                   },
                   guardar: function (evt) {
                       evt.preventDefault();
                       var obj, me, isNew;
                       me = this;
                       isNew = this.model.isNew();
                       obj = {
                           coPeriodoAcademico: this.$('input[name=coPeriodoAcademico]').val(),
                           feInicio: moment(this.$('input[name=feInicio]').val(), 'DD/MM/YYYY')
                               .toDate().getTime(),
                           institucionEducativa: app.currentIe
                       };
                       this.model.save(obj, {
                           success: function () {
                               if (isNew) {
                                   me.trigger('goto:edit', me.model.id)
                               }
                           }
                       });
                   },
                   cancelar: function (evt) {
                       evt.preventDefault();
                       this.triggerMethod('goto:list');
                   }
               });

           var PlanaDocenteChildView = Marionette.ItemView.extend(
               {
                   initialize: function () {
                       this.docenteCollection = new DocenteCollection([]);
                   },
                   template: periodoAcademicoAgregarDocenteForm,
                   templateHelpers: function () {
                       console.log(this.model.cid);
                       return {
                           cid: this.model.cid
                       };
                   },
                   events: function () {
                       var evtHash = {};
                       evtHash['change #nuDocumento-'+this.model.cid] = 'onChangeNuDocumento';
                       return evtHash;
                   },
                   onChangeNuDocumento: function () {
                       var me = this;
                       this.docenteCollection.fetch(
                           {
                               reset: true,
                               data: {
                                   by: 'nuDocumento',
                                   nuDocumento: this.$('#nuDocumento-'+this.model.cid).val()
                               },
                               success: function (collection, response, options) {
                                   if (collection.isEmpty()) {
                                       return;
                                   }
                                   me.model.set('trabajador', collection.at(0).toJSON());
                                   me.render();
                               }
                           });
                   }
               }
           );
           var NoChildrenView = Marionette.ItemView.extend(
               {
                   className: 'text-center',
                   template: _.template('<i>Aún no ha agregado docentes para este periodo.</i>')
               }
           );
           PlanaDocenteView = Marionette.CompositeView.extend(
               {
                   template: periodoAcademicoPlanaDocente,
                   childView: PlanaDocenteChildView,
                   emptyView: NoChildrenView,
                   childViewContainer: '#plana-docente-collection',
                   events: {
                       'click .btn-add-docente': 'onClickDocenteAdd'
                   },
                   onClickDocenteAdd: function () {
                       this.collection.add(
                           {
                               idPeriodoAcademico: this.collection.idPeriodoAcademico,
                               trabajador: {
                                   persona: {}
                               }
                           }
                       );
                   }
               }
           );

           return Marionette.LayoutView.extend(
               {
                   initialize: function () {
                       this.planillaCollection =
                           new PlanillaCollection([], {idPeriodoAcademico: this.model.id});
                   },
                   template: periodoAcademicoFormLayout,
                   regions: {
                       periodoAcademicoFormRegion: '#periodo-academico-form',
                       planaDocenteRegion: '#plana-docente'
                   },
                   onBeforeShow: function () {
                       var me = this;
                       this.showChildView(
                           'periodoAcademicoFormRegion',
                           new PeriodoAcademicoView({model: this.model}));

                       this.showChildView('planaDocenteRegion', new PlanaDocenteView({
                               collection: this.planillaCollection
                           }
                       ));
                       this.planillaCollection.fetch();
                   },
                   childEvents: {
                       'goto:list': 'onGotoList',
                       'render': 'onChildRender'
                   },
                   templateHelpers: function () {
                       return {
                           isNew: this.model.isNew()
                       };
                   },
                   onGotoList: function (childView) {
                       this.trigger('goto:list');
                   }
               });
       });