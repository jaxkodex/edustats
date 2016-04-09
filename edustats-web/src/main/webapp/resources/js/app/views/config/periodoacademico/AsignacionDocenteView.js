/**
 * Created by Jorge on 07/04/2016.
 */
define(['marionette', 'tpl!templates/config/periodoacademico/asignaciondocente.html',
        'tpl!templates/config/periodoacademico/asignaciondocenteitem.html',
        'collections/GradoCollection', 'collections/CicloCollection',
        'collections/CursoCollection'],
       function (Marionette, asignacionDocenteTemplate,
                 asignacionDocenteItemTemplate,
                 GradoCollection, CicloCollection, CursoCollection) {
           var childView = Marionette.ItemView.extend(
               {
                   className: 'list-group-item',
                   template: asignacionDocenteItemTemplate
               }
           );

           return Marionette.CompositeView.extend(
               {
                   initialize: function () {
                       var me = this;
                       this.gradoCollection = new GradoCollection([]);
                       this.cicloCollection = new CicloCollection([]);

                       this.options.cursoCollection.each(function (curso) {
                           var grado = curso.get('grado');
                           me.gradoCollection.add(grado);
                           me.cicloCollection.add(grado.ciclo);
                       });

                       this.form = {
                           idCiclo: this.cicloCollection.at(0).id
                       }
                   },
                   template: asignacionDocenteTemplate,
                   childView: childView,
                   childViewContainer: '#aula-container',
                   templateHelpers: function () {
                       var me = this;
                       return {
                           form: this.form,
                           seccionCollection: this.options.seccionCollection,
                           cicloCollection: this.cicloCollection,
                           gradoCollection: new GradoCollection(this.gradoCollection.filter(function (grado) { return grado.get('ciclo').idCiclo == me.form.idCiclo }))
                       }
                   },
                   events: {
                       'click #btn-new-classroom': 'onClickBtnNewClasswoom',
                       'click #btn-cancel-new-classroom': 'onClickBtnCancelNewClasswoom',
                       'change #formIdCicloSlct': 'onChangeFormIdCicloSlct',
                       submit: 'onSubmit'
                   },
                   onClickBtnNewClasswoom: function (evt) {
                       evt.preventDefault();
                       this.render();
                       this.$('#new-classroom-form').removeClass('hidden');
                   },
                   onClickBtnCancelNewClasswoom: function (evt) {
                       evt.preventDefault();
                       this.$('#new-classroom-form').addClass('hidden');
                   },
                   onChangeFormIdCicloSlct: function () {
                       this.form.idCiclo = this.$('#formIdCicloSlct').val();
                       this.render();
                   },
                   onSubmit: function (evt) {
                       evt.preventDefault();
                       var me = this;
                       var aulaObject = {
                           grado: this.gradoCollection.get(this.$('#formIdGradoSlct').val()).toJSON(),
                           seccion: { coSeccion: this.$('#formIdSeccionSlct').val() },
                           periodoAcademico: this.options.periodoAcademico.toJSON()
                       };
                       this.collection.create(aulaObject, {
                           success: function () {
                               me.$('#new-classroom-form').addClass('hidden');
                           }
                       });
                   }
               }
           );
       }
);
