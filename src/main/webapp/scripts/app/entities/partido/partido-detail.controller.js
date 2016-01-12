'use strict';

angular.module('ligabaloncestoApp')
    .controller('PartidoDetailController', function ($scope, $rootScope, $stateParams, entity, Partido, Arbitro, Equipo, Temporada, Estadisticas) {
        $scope.partido = entity;
        $scope.load = function (id) {
            Partido.get({id: id}, function(result) {
                $scope.partido = result;
            });
        };
        $rootScope.$on('ligabaloncestoApp:partidoUpdate', function(event, result) {
            $scope.partido = result;
        });
    });
