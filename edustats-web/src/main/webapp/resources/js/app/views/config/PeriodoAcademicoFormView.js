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
                                   me.triggerMethod('goto:edit', me.model.id);
                                   // me.trigger('goto:edit', me.model.id)
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
                           cid: this.model.cid,
                           moment: moment
                       };
                   },
                   events: function () {
                       var evtHash = {
                           'click .btn-save': 'onClickBtnSave'
                       };
                       evtHash['change #nuDocumento-'+this.model.cid] = 'onChangeNuDocumento';
                       return evtHash;
                   },
                   onRender: function () {
                       this.$('.date').datepicker();
                   },
                   onChangeNuDocumento: function () {
                       var me = this;
                       this.docenteCollection.fetch(
                           {
                               reset: true,
                               data: {
                                   by: 'nuDocumento',
                                   nuDocumento: this.$('#nuDocumento-'+this.model.cid).val(),
                                   idTipoDocumento: this.$('#coTipoDocumento-'+this.model.cid).val()
                               },
                               success: function (collection, response, options) {
                                   if (collection.isEmpty()) {
                                       return;
                                   }
                                   me.model.set('trabajador', collection.at(0).toJSON());
                                   me.render();
                               }
                           }
                       );
                   },
                   onClickBtnSave: function () {
                       var persona = {
                           nuDocumento: this.$('#nuDocumento-'+this.model.cid).val(),
                           apPersona: this.$('#apPersona-'+this.model.cid).val(),
                           amPersona: this.$('#amPersona-'+this.model.cid).val(),
                           noPersona: this.$('#noPersona-'+this.model.cid).val(),
                           feNacimiento: moment(this.$('#feNacimiento-'+this.model.cid).val(), 'DD/MM/YYYY').toDate().getTime(),
                           tipoDocumento: {
                               idTipoDocumento: this.$('#coTipoDocumento-'+this.model.cid).val()
                           }
                       }, trabajador = {
                           persona: persona
                       };
                       this.model.save(
                           {
                               trabajador: trabajador
                           }
                       );
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
                       if (!this.model.isNew()) {
                           this.planillaCollection.fetch();
                       }
                   },
                   childEvents: {
                       'goto:list': 'onGotoList',
                       'goto:edit': 'onGotoEdit',
                       'render': 'onChildRender'
                   },
                   templateHelpers: function () {
                       return {
                           isNew: this.model.isNew()
                       };
                   },
                   onGotoList: function (childView) {
                       this.trigger('goto:list');
                   },
                   onGotoEdit: function (childView, id) {
                       this.trigger('goto:edit', id);
                   }
               });
       });