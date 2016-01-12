'use strict';

angular.module('ligabaloncestoApp').controller('EstadisticasDialogController',
    ['$scope', '$stateParams', '$modalInstance', 'entity', 'Estadisticas', 'Partido', 'Jugador',
        function($scope, $stateParams, $modalInstance, entity, Estadisticas, Partido, Jugador) {

        $scope.estadisticas = entity;
        $scope.partidos = Partido.query();
        $scope.jugadors = Jugador.query();
        $scope.load = function(id) {
            Estadisticas.get({id : id}, function(result) {
                $scope.estadisticas = result;
            });
        };

        var onSaveFinished = function (result) {
            $scope.$emit('ligabaloncestoApp:estadisticasUpdate', result);
            $modalInstance.close(result);
        };

        $scope.save = function () {
            if ($scope.estadisticas.id != null) {
                Estadisticas.update($scope.estadisticas, onSaveFinished);
            } else {
                Estadisticas.save($scope.estadisticas, onSaveFinished);
            }
        };

        $scope.clear = function() {
            $modalInstance.dismiss('cancel');
        };
}]);
