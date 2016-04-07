/**
 * Created by Jorge on 07/04/2016.
 */

define(['marionette',
        'tpl!templates/config/periodoacademicoagregardocenteform.html',
        'tpl!templates/config/periodoacademicoplanadocente.html',
        'collections/DocenteCollection', 'moment'],
       function (Marionette,
                 periodoAcademicoAgregarDocenteForm, periodoAcademicoPlanaDocente,
                 DocenteCollection,
                 moment) {
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
                   className: 'periodo-academico-docente',
                   events: function () {
                       var evtHash = {
                           'click .btn-save': 'onClickBtnSave'
                       };
                       evtHash['change #nuDocumento-'+this.model.cid] = 'onChangeNuDocumento';
                       return evtHash;
                   },
                   onRender: function () {
                       this.$('.date').datepicker(
                           {
                               maxDate: new Date(),
                               changeMonth: true,
                               changeYear: true
                           }
                       );
                       if (this.model.isNew()) {
                           this.$el.addClass('in-action-edit');
                       }
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

           return Marionette.CompositeView.extend(
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
       }
);
