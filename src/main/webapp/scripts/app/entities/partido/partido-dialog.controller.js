'use strict';

angular.module('ligabaloncestoApp').controller('PartidoDialogController',
    ['$scope', '$stateParams', '$modalInstance', 'entity', 'Partido', 'Arbitro', 'Equipo', 'Temporada', 'Estadisticas',
        function($scope, $stateParams, $modalInstance, entity, Partido, Arbitro, Equipo, Temporada, Estadisticas) {

        $scope.partido = entity;
        $scope.arbitros = Arbitro.query();
        $scope.equipos = Equipo.query();
        $scope.temporadas = Temporada.query();
        $scope.estadisticass = Estadisticas.query();
        $scope.load = function(id) {
            Partido.get({id : id}, function(result) {
                $scope.partido = result;
            });
        };

        var onSaveFinished = function (result) {
            $scope.$emit('ligabaloncestoApp:partidoUpdate', result);
            $modalInstance.close(result);
        };

        $scope.save = function () {
            if ($scope.partido.id != null) {
                Partido.update($scope.partido, onSaveFinished);
            } else {
                Partido.save($scope.partido, onSaveFinished);
            }
        };

        $scope.clear = function() {
            $modalInstance.dismiss('cancel');
        };
}]);
