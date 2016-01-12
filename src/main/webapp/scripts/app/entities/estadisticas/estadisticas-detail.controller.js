'use strict';

angular.module('ligabaloncestoApp')
    .controller('EstadisticasDetailController', function ($scope, $rootScope, $stateParams, entity, Estadisticas, Partido, Jugador) {
        $scope.estadisticas = entity;
        $scope.load = function (id) {
            Estadisticas.get({id: id}, function(result) {
                $scope.estadisticas = result;
            });
        };
        $rootScope.$on('ligabaloncestoApp:estadisticasUpdate', function(event, result) {
            $scope.estadisticas = result;
        });
    });
