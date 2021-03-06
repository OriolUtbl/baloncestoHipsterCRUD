'use strict';

angular.module('ligabaloncestoApp').controller('ArbitroDialogController',
    ['$scope', '$stateParams', '$modalInstance', 'entity', 'Arbitro', 'Partido', 'Liga',
        function($scope, $stateParams, $modalInstance, entity, Arbitro, Partido, Liga) {

        $scope.arbitro = entity;
        $scope.partidos = Partido.query();
        $scope.ligas = Liga.query();
        $scope.load = function(id) {
            Arbitro.get({id : id}, function(result) {
                $scope.arbitro = result;
            });
        };

        var onSaveFinished = function (result) {
            $scope.$emit('ligabaloncestoApp:arbitroUpdate', result);
            $modalInstance.close(result);
        };

        $scope.save = function () {
            if ($scope.arbitro.id != null) {
                Arbitro.update($scope.arbitro, onSaveFinished);
            } else {
                Arbitro.save($scope.arbitro, onSaveFinished);
            }
        };

        $scope.clear = function() {
            $modalInstance.dismiss('cancel');
        };
}]);
