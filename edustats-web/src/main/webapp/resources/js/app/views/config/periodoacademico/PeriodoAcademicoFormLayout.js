/**
 * Created by Jorge on 07/04/2016.
 */
define(['app', 'marionette',
        'tpl!templates/config/periodoacademico/formlayout.html',
        'collections/PlanillaCollection', 'collections/AulaCollection',
        'views/config/periodoacademico/PeriodoAcademicoFormView',
        'views/config/periodoacademico/PlanaDocenteView',
        'views/config/periodoacademico/AsignacionDocenteView'
       ],
       function (app, Marionette,
                 periodoAcademicoFormLayout,
                 PlanillaCollection, AulaCollection,
                 PeriodoAcademicoFormView, PlanaDocenteView, AsignacionDocenteView) {
           return Marionette.LayoutView.extend(
               {
                   initialize: function () {
                       this.planillaCollection = new PlanillaCollection([], {idPeriodoAcademico: this.model.id});
                       this.aulaCollection = new AulaCollection([]);
                   },
                   template: periodoAcademicoFormLayout,
                   regions: {
                       periodoAcademicoFormRegion: '#periodo-academico-form',
                       planaDocenteRegion: '#plana-docente',
                       asignacionDocenteRegion: '#asignacion-docente'
                   },
                   onBeforeShow: function () {
                       var me = this;
                       this.showChildView(
                           'periodoAcademicoFormRegion',
                           new PeriodoAcademicoFormView({model: this.model}));

                       this.showChildView('planaDocenteRegion', new PlanaDocenteView({
                               collection: this.planillaCollection
                           }
                       ));
                       this.showChildView('asignacionDocenteRegion', new AsignacionDocenteView({
                           collection: this.aulaCollection,
                           cursoCollection: this.options.cursoCollection,
                           seccionCollection: this.options.seccionCollection,
                           periodoAcademico: this.model
                       }));
                       if (!this.model.isNew()) {
                           this.planillaCollection.fetch();
                           this.aulaCollection.fetch(
                               {
                                   data: {
                                       idPeriodoAcademico: this.model.id
                                   }
                               }
                           );
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
               }
           );
       }
);