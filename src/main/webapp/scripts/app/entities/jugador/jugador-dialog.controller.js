'use strict';

angular.module('ligabaloncestoApp').controller('JugadorDialogController',
    ['$scope', '$stateParams', '$modalInstance', 'entity', 'Jugador', 'Estadisticas', 'Equipo',
        function($scope, $stateParams, $modalInstance, entity, Jugador, Estadisticas, Equipo) {

        $scope.jugador = entity;
        $scope.estadisticass = Estadisticas.query();
        $scope.equipos = Equipo.query();
        $scope.load = function(id) {
            Jugador.get({id : id}, function(result) {
                $scope.jugador = result;
            });
        };

        var onSaveFinished = function (result) {
            $scope.$emit('ligabaloncestoApp:jugadorUpdate', result);
            $modalInstance.close(result);
        };

        $scope.save = function () {
            if ($scope.jugador.id != null) {
                Jugador.update($scope.jugador, onSaveFinished);
            } else {
                Jugador.save($scope.jugador, onSaveFinished);
            }
        };

        $scope.clear = function() {
            $modalInstance.dismiss('cancel');
        };
}]);
